// ����ģʽ�ص㣺1.�����ж��ʵ����2.�Լ������͹���ʵ����3.������ṩʵ����
/*
  ����ģʽ������һ������״̬���������ÿһ��ʵ������һ��Ψһ������״̬��һ�����������һ��Map����ÿһ��ʵ��
  ����״̬��Ϊmap�ļ������������ÿһ��ʵ����Ϊmap��ֵ
*/
public class Main {   
   
   public static void main(String[] args) {
         // �����޵Ķ���ģʽ,��ʵ����Ϊstatic����,����ʽ
        MultitonPatternWithUpper instance = MultitonPatternWithUpper.getInstance(1);				
		// û���޵Ķ���ģʽ,ʹ�ü���������ʵ��
	    // һ��Resource�ļ���properties�ļ�����û����ǰ��֧�ֶ����ԣ����߲�֧��
		/*  
		      ���´���ʹ��ResourceBundle
			  Locale locale = new Locale(language, region);
			  ResourceBundle bundle = ResourceBundle.getBundle("�ļ�������",locale);
			  ��locale��en,USʱ��ʵ�ʴ洢���������ļ���=�ļ�������+"_"+en_US			  
		*/
		/*
		   bundle.getString(code)�õ���Ӧresource�ļ��е����Զ�Ӧ��ֵ,��û��д���ļ��ķ���
	       ���bundle�ļ��������ģ�����java�ڶ�ȡpropertiesʱĬ��ʹ��iso-8859-1���룬�����һ��GBKϵͳ��
		   Ҫʹ��getString�õ����ģ������new String(xx.getBytes("iso-8859-1"),"GBK")ת��
		*/
		 MultitonPatternNoLimit mulInstance1 = MultitonPatternNoLimit.getInstance("zh","CH");
		 MultitonPatternNoLimit mulInstance2 = MultitonPatternNoLimit.getInstance();
		 
		 System.out.println("����: "+mulInstance1.getLocaleString("USD"));
		 System.out.println("Ӣ��: "+mulInstance2.getLocaleString("USD"));
		 
		 NumberFormatTest.displayNumber();
		 NumberFormatTest.displayCurrency();
		 NumberFormatTest.displayPercent();
   }
}