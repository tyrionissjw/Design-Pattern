// 多例模式特点：1.可以有多个实例。2.自己创建和管理实例。3.向外界提供实例。
/*
  多例模式往往有一个内蕴状态，多例类的每一个实例都有一个唯一的内蕴状态。一个多例类会有一个Map储存每一个实例
  内蕴状态作为map的键，而多例类的每一个实例作为map的值
*/
public class Main {   
   
   public static void main(String[] args) {
         // 有上限的多例模式,将实例作为static变量,饿汉式
        MultitonPatternWithUpper instance = MultitonPatternWithUpper.getInstance(1);				
		// 没上限的多例模式,使用集合来储存实例
	    // 一个Resource文件和properties文件本质没区别，前者支持多语言，后者不支持
		/*  
		      如下代码使用ResourceBundle
			  Locale locale = new Locale(language, region);
			  ResourceBundle bundle = ResourceBundle.getBundle("文件名短名",locale);
			  当locale是en,US时，实际存储的真正的文件名=文件名短名+"_"+en_US			  
		*/
		/*
		   bundle.getString(code)得到对应resource文件中的属性对应的值,它没有写入文件的方法
	       如果bundle文件中有中文，由于java在读取properties时默认使用iso-8859-1编码，因此在一个GBK系统上
		   要使用getString得到中文，需进行new String(xx.getBytes("iso-8859-1"),"GBK")转换
		*/
		 MultitonPatternNoLimit mulInstance1 = MultitonPatternNoLimit.getInstance("zh","CH");
		 MultitonPatternNoLimit mulInstance2 = MultitonPatternNoLimit.getInstance();
		 
		 System.out.println("中文: "+mulInstance1.getLocaleString("USD"));
		 System.out.println("英文: "+mulInstance2.getLocaleString("USD"));
		 
		 NumberFormatTest.displayNumber();
		 NumberFormatTest.displayCurrency();
		 NumberFormatTest.displayPercent();
   }
}