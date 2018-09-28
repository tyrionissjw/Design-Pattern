import java.util.*;
import java.io.UnsupportedEncodingException;
public class MultitonPatternNoLimit {
    private String region = "US";
	private String language = "en";	
	public final static  String FILE_NAME = "res";
		
	private Locale locale;
	private ResourceBundle resourceBundle;
	
	private static Map<String, MultitonPatternNoLimit> instances = new HashMap<String, MultitonPatternNoLimit>();
	
		
	private MultitonPatternNoLimit(String language, String region) {	     
         this.language = language;
		 this.region = region;		 
		 locale = new Locale(language,region);
		 resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);
         instances.put(makeLocaleCode(language,region), this);		 
	}
    
    private MultitonPatternNoLimit() {
	     locale = new Locale(language, region);
		 resourceBundle = ResourceBundle.getBundle(FILE_NAME, locale);
		 instances.put(makeLocaleCode(language,region), this);
	}
	
     private static String makeLocaleCode(String language, String region) {
        return language+"_"+region;	
	}
	
	public synchronized static MultitonPatternNoLimit getInstance(String language, String region) {
	     String tempLocaleCode = makeLocaleCode(language, region);
         if (instances.containsKey(tempLocaleCode)) {
		     return instances.get(tempLocaleCode);
         } else {
		     return new MultitonPatternNoLimit(language, region);
         }		 
	}
	
	public synchronized static MultitonPatternNoLimit getInstance() {
	    String tempLocaleCode = makeLocaleCode("en", "US");
         if (instances.containsKey(tempLocaleCode)) {
		     return instances.get(tempLocaleCode);
		 } else {
		     return new MultitonPatternNoLimit();
		 }
	}
	

	
	public String getLocaleString(String code) {
	    String value = resourceBundle.getString(code);
		if (value != null) {
		   try {
		       value =  new String(value.getBytes("ISO-8859-1"),"GBK");
		   } catch(UnsupportedEncodingException ex) {
		      throw new RuntimeException("±àÂëÎÞ·¨×ª»»: "+ex);
		   }
		}
	    return value;
	}
}