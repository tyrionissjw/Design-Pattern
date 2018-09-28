import java.util.Locale;
import java.text.NumberFormat;
public class NumberFormatTest {
     private static Locale locale_en = Locale.US;
	 private static Locale locale_ch = Locale.CHINA;
	 private static Locale locale_fr = Locale.FRANCE   ;
	 public final static Double amount = new Double(1234.45);
     public static void displayNumber() {	     
	     System.out.println("格式化数字");
	     NumberFormat formatter = NumberFormat.getNumberInstance(locale_ch);
		 System.out.println(formatter.format(amount)+"  "+locale_ch);
		 formatter = NumberFormat.getNumberInstance(locale_en);
		 System.out.println(formatter.format(amount)+"  "+locale_en);
		 formatter = NumberFormat.getNumberInstance(locale_fr);
		 System.out.println(formatter.format(amount)+"  "+locale_fr);
	 }	 
	 
	 public static void displayCurrency() {
	     System.out.println("格式化货币");
		 NumberFormat formatter = NumberFormat.getCurrencyInstance(locale_ch);
		 System.out.println(formatter.format(amount)+"  "+locale_ch);
		 formatter = NumberFormat.getCurrencyInstance(locale_en);
		 System.out.println(formatter.format(amount)+"  "+locale_en);
		 formatter = NumberFormat.getCurrencyInstance(locale_fr);
		 System.out.println(formatter.format(amount)+"  "+locale_fr);
	 }
	 
	 public static void displayPercent() {
	     System.out.println("格式化百分比");
		 NumberFormat formatter = NumberFormat.getPercentInstance(locale_ch);
		 System.out.println(formatter.format(amount)+"  "+locale_ch);
		 formatter = NumberFormat.getPercentInstance(locale_en);
		 System.out.println(formatter.format(amount)+"  "+locale_en);
		 formatter = NumberFormat.getPercentInstance(locale_fr);
		 System.out.println(formatter.format(amount)+"  "+locale_fr);
	 }
}