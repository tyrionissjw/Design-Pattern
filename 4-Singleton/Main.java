import java.io.*;
/*
1������ģʽ�ص㣺1.ֻ��һ��ʵ��  2.ʵ����������  3.Ϊ���������ṩ��ʵ��
2������ģʽ��Ӧ��:��Դ������(����ڲ����ⲿ)��windows����վ�����󹤳������幤��������Ľ�����
��ʹ��EJB,RMI,JINI�ȷֲ�ʽϵͳ�л�����һ��JVM���ж����������������(�磺J2EE������������servlet����)����ʹ����״̬�ĵ�������
3������Ƶ��ʹ�õĶ���ʡ�Դ�������Ļ���ʱ�䣬����������������˵����new������
�������٣����ϵͳ�ڴ��ʹ���ʽ��ͣ�����GCѹ��������GCͣ��ʱ�����ϵͳ�ؼ���
���ͱ�Ƶ��ʹ�õĶ���ʹ�õ�������

��Ӧ�õ���ģʽ����ɹ�����Դ����������
��ʹ����������instance����null��ϵͳ�����������ط�����instance���޷��������ա�����ٵ���getInstance()�����ʹ�������һ��ʵ������ʹ������ʵ��������Ϊ������
һ����״̬�ĵ���һ���ǿɱ����һ��û״̬�ĵ���һ���ǲ��ɱ����
����ȫ�������й��еĹ��캯�����ŵ㣺�ͻ������ѡ�����ʵ������ȱ�㣺ѡ�����
����ģʽʹ���˼򵥹���ģʽ�ṩ�Լ���ʵ��


Math���Ƿ�Ϊ����ģʽ���𣺲��ǡ���Ȼ����˽�еĹ��캯���������������㵥��ģʽ���ص�3��ʵ�������Ĺ���˽�к���ֻ��Ϊ��
���㲻��ʵ����

˫�ؼ�鱾���Ŀ�ģ�������ͨ������ʽģʽ��ͬ����ֻ�ڵ���������ֵ֮ǰ��Ч����ֵ�����ͬ����ƿ��
���ʹ��˫�ؼ����ͬ���������if�жϡ�
������java�Զ���ĳ�ʼ������(1.����һ���ڴ� 2.�����ַ�������� 3.��������)
��Ӱ��if�ж�(�ڵ�2����)�����˫�ؼ����java�в����á�

˫�ؼ����Java version 5.0���������еúܺã���Ϊsynchronized��volatile�����Ѿ�ʵ����
public class ApplicationCache{
 
   private Map<String, Object> attributeMap;
   // volatile so that JVM out-of-order writes do not happen
   private static volatile ApplicationCache instance;
 
   public static ApplicationCache getInstance(){
      // Checked once
      if(instance == null){
         // Synchronized on Class level lock
         synchronized(ApplicationCache.class){
            // Checked again
            if(instance == null){
               instance == new ApplicationCache();
            }
         }
      }
      return instance;
   }
 
   private ApplicationCache(){
      attributeMap = createCache(); // Initialize the cache
   }
}
��instance����volatile������JVM����������д����(out-of-order writes)���ڶԳ�ʼ��ͬ��ʱ����
instance�Ƿ���null��������Σ������ͱ������������ϵ��̴߳������һ��cache��ʵ��

4��ע�⣺
�ٷ���(Reflection)API�����˽�еĹ����������ڵ���ģʽΪ�˷�ֹ��������һ��ʵ��������ͨ���ӹ������׳��쳣�������
�����л��ͷ����л����ܻᴴ��������ͬ��ʵ��������ͨ����д���л�API�е�readResolve()�����������

5��ö��ʵ�ֵ���
public enum MaYun {
	himself; //����һ��ö�ٵ�Ԫ�أ��ʹ���MaYun��һ��ʵ��
	private String anotherField;
	MaYun() {
	//MaYun����Ҫ��������
	//�������Ҳ����ȥ����������ʱ����Ҫ�����������instance��ֵ��ʱ��
	/** himself = MaYun() {
	* //MaYun����Ҫ��������
	* }
	**/
}
public void splitAlipay() {
	System.out.println(��Alipay���ҵ���������ѾYahoo��ü���۵����š�������);
}
}
Call��MaYun.himself.splitAlipay();
*/
/**
 * ʹ��ö�ٵĵ���ģʽ
 *
 * @author yzl
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public class EnumSingleton{
    private EnumSingleton(){}
    public static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    
    private static enum Singleton{
        INSTANCE;
        
        private EnumSingleton singleton;
        //JVM�ᱣ֤�˷�������ֻ����һ��
        private Singleton(){
            singleton = new EnumSingleton();
        }
        public EnumSingleton getInstance(){
            return singleton;
        }
    }
}
public class Main {   
   /*        ����ʽ������ʽ
       1.���豣֤˽�й��캯������ֹ�ⲿֱ��ʵ����
       �ٶ���Eagar����ģʽ������intance������static�ģ����JVM���ص�����ʱ����������
        �ͻᴴ�������κ�ʹ�øõ��������ĵط�(craeteString)�ͻ��Զ����������࣬�������Ƿ�
        ���ܱ��õ�������������ഴ����ʱ�������ϵͳ��غ���������
        ��Lazy����������
        ��Eagar��Lazy������ǰ�߲���Ҫͬ����������������Ҫ��ѭ�����ԣ�����
        ���2����������
	   2.ʵ������instance��getInstance��Ϊstatic(����ʽ��ʵ������instance��final����)
   */      

   public static void main(String[] args)  {
      /*         �Ǽ�ʽ����
        1.�˷� ����ʽ������ʽ���ɼ̳е��ص�
		2.�������������ʽ(�Ӹ���̳е��ص�)
		3.����Ĺ��캯��������protected�ģ���Ϊ����Ҫ�̳�
		4.����Ĺ��캯��������public�ģ���Ϊ�ڸ����getInstance��ʹ��Class.forName(����).newInstance()�����������		
   */
        RegSingleton rs = RegSingletonChild.getInstance();
		rs.doBusiness();
		RegSingleton rs1 = RegSingleton.getInstance("RegSingleton");
		rs1.doBusiness();
				
		//Runtime�ǵ����࣬ÿ��java����ֻ��һ�������������������runtime��һ���ⲿ����
		try {
		   Runtime.getRuntime().exec("notepad.exe");
		} catch(IOException ex) {
		    ex.printStackTrace();
		}
		
		/*
			 1.Monostateģʽ��ͨ�������б�����Ϊstatic�ģ���ʵ�ֵ���
			 ���ƣ�
			 �ٶ�̬�ԣ�����Monostate��ʵ������static�Ĳ��ҹ��췽��Ҳ����˽�еģ�����ֲ���ͨ����ģʽ���ܼ̳е�ȱ��(����Ҳ��Monostateģʽ)
			 ��͸���ԣ���ͨ��new XXX()���������ֲ���ͨ����ģʽ����ʹ��getInstance��ʹ�ͻ�֪������һ������ģʽ�Ĳ�͸���ԡ�
			 ȱ�㣺
			 �ٲ���ͨ������ķ�ʽ��������ת��ΪMonostateģʽ
			 ��Ч�����⣬ͨͨ��new XXX()��Monostate����Ȼ���ظ��������󣬲�û��������ĵ���ֻ����һ�����󣬻ᵼ�´��������ٵĿ���
			 ���ڴ�ռ�ã���ʹ��δʹ��Monstate�����ı���ҲҪռ���ڴ�			 
			 ��������Զ���ᶪʧ��ʹʵ��������
		*/
		 Monostate singleton = new Monostate();
		 
		 /*
		   Initialization on Demand Holder(�̰߳�ȫ+�ӳټ���+static����)
            ��SingeltonIodh������ʱ�����ڲ��಻�ᱻ��ʼ�����ʿ���ȷ����SingeltonIodh������JVM
            ʱ�������ʼ�������࣬��������getInstance�Ż����SingeltonIodhHodler���Ӷ���ʼ��
            instance������ʵ���Ľ������������ʱ��ɣ��̰߳�ȫ�����ʡ����synchronized�ؼ��֡�
		 */
		 SingletonIodh instance = SingletonIodh.getInstance();
   }
}