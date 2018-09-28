import java.util.regex.Pattern;
public class HandlerConfig {
     private Handler handler;
	 private String handlerName;
	 private String regex;
	 private Pattern pattern;
	 
	 public void setHandler(Handler handler) {
	     this.handler = handler;
	 }
	 
	 public Handler getHandler() {
	     return this.handler;
	 }
	 
	 public void setHandlerName(String handlerName) {
	     this.handlerName = handlerName;
	 }
	 
	 public String getHandlerName() {
	     return this.handlerName;
	 }
	 
	 public void setRegex(String regex) {
	     this.regex = regex;
	 }
	 
	 public String getRegex() {
	     return this.regex;
	 }
	 
	 public Pattern getPattern() {
	     return pattern;
	 }
	 
	 public void construct() {	     
		 pattern  = Pattern.compile(getRegex());
	 }
}