/*
	 0.���壺��һ�������ж���һ���㷨�ĹǼܣ�����һЩ�����ӳٵ������С�ģ�巽��ʹ����������ڲ��ı��㷨
	 �ṹ������£����¶����㷨�е�ĳЩ���衣
	 1.ʹ��ģ�巽��ʱ��ÿ������һ���µ�����ʱ����Ҫ���տ������̵�˼·ȥ�룬��ʹӦ�ð���"����"��˼·ȥ�룬
	 Ӧ�ÿ�����Щ����ʱ������д�ģ���Щ�ǿ�����д�ģ���Щ�ǲ�����д�ġ�
	 2.�������ģ�巽���������б��벻�����޸ĵ���ȫ�̳У�����Υ��ģ�巽�������⡣
	 3.�����������������ģ�巽������������һ����ÿһ��ģ�巽�������Ե������������巽����
	 4.ģ�巽��ģʽ�еĻ��������ķ��ࣺ
		 �ٳ��󷽷���protected���Σ�����ʵ��
		 �ھ��巽����private�޸ģ����಻ʵ�ֻ���д
		 �۹��ӷ�����protected���Σ��������ṩĬ��ʵ�ֻ��ʵ�֣����������չ����do������ͷ
	 5.�ڶ�һ���̳еȼ��ṹ���ع�ʱ��Ӧ����ѭ��ԭ����ǽ���Ϊ�����ƶ����ṹ�ĸ߶ˣ�����״̬�����ƶ����ṹ�ĵͶˡ�
		 ��һ�����ʵ�����Ƚ�������Ϊ�Ļ����ϣ�������״̬�Ļ����ϡ�
		 ��ʵ����Ϊʱ�����ó���״̬�����Ǿ���״̬�������Ϊ�漰�������״̬��ʹ��ȡֵ����������ֱ���������ԡ�
	 ���ַ�ʽ���Խ�����;���ָ�����Ӷ���֤�����������޶ȵı����á�	 
	 
	 Servlet����
	 1.���е�Servlet������ѭjava servlet api.�������������ɣ�
		 ��javax.servlet:�������ṩ��ͨservletģ��(�ٶ�������TCP/IPЭ���ϵ�)
		 ��javax.servlet.http:�������ṩHTTP��HTTPS��servletģ��(����HTTP��HTTPS�йص��߼������������)
		 ��������Ŀ�ģ����̶��ϰѿ��ܱ仯�Ĳ��ֺ�һ�����߼��ֿ������ϰ��ÿ���ԭ��
	 2.Servlet������������ṩ����Ҫ��Servlet�ܹ�������������ǣ�Servlet, GenericServlet,HttpServlet
		 ��Servlet�Ǹ��ӿڣ�����������������init(), destroy(), service()������������������servlet����������
		 ��GenericServlet�Ǹ������࣬�ṩ��Servlet�ӿڵ�Ĭ��ʵ�֣���ȴ������һ��service����������������ǳ���ġ�
			 �κξ����servlet�������ṩ�÷�����ʵ��
		 ��HttpServlet�Ǹ������࣬�̳���GenericServlet��������service�������߸�do������Ĭ��ʵ�֣����߸�do����������HttpЭ��ĸ�������
	 3.java�е�servlet����ֱ�ӻ��ӵ�ʵ��servlet�ӿڣ�������servlet�����ṩ�����������У��������������������������
	 4.servlet����������
		 �ټ��أ���������һ������servlet����������̿�������������servlet��ʱִ�У�����servlet������Ӧ����ʱִ�У�Ҳ��������֮���κ�ʱ��ִ�С�
		 �ڳ�ʼ��������init����
		 �۾�����servlet����ʼ����������Ӧ����ľ���״̬�����ͻ�����һ������ʱ��servlet������servletRequest��servletResponse����ת����servlet��
			�����������Բ�����ʽ����service������service�������һ������do����������Ӧ��HTTP����
		 ������destroy
	 5.HttpServlet��service������һ��ģ�巽�����������߸�do�����е�һ���򼸸�(��������ͷif�жϵ���)����ɿͻ��˵���Ӧ����Щdo������Ҫ��HttpServlet
	 �ľ�������ʵ��
	 6.Servlet�Ĺ۲���ģʽ
		 ��Servlet��������¼���ΪServlet�����¼���Session�¼�
		 ���ã�1.�������ݿ�͸�����Դ��ʹ�� 2.������������ 3.����Http Session��״̬�Լ�����		 
		 ���漰�ĸ������ӿڣ�HttpSessionListener, ServletContextListener,ServletContextAttributeListener,HttpSessionAtrributeListener���Ƕ��̳���java.util.
		 EventListener		 
		 ��Ҫ��ĳһ���¼�������Ӧ���ͱ���ʵ���������������¼��Ľӿڣ���Ϊһ����������(�۲��ߵĽ�ɫ)��һ���������������һ��Ĭ�Ϲ����ӣ�����ʵ�ּ�����
			 �ӿڵ�����Ҫ��ķ�����
			 
		 
*/
public class Main {
	 public static void main(String[] args) {
		 Template t1 = new ConcreteTemplate1();
		 t1.templateMethod();
	 }
}

/**
    ������ģ�巽��ģʽ��ǿ��
**/
// ��ͨģ�巽����һ�����ӣ�������ϵͳ����ʱ������sql����
public abstract class AbsPopulator {
    public final void dataInitialzing() throws Exception {
        doInit();
    }
    
    protected abstract void doInit();
}
// ʵ��ģ����
public class UserPopulator extends AbsPopulator {
    protected void doInit() {
        /* ��ʼ�����紴�����������ݵ�*/
    }
}
���ַ�ʽ���ã���Ϊ�����߼���һ��������д�룬����doInitû���κ�ҵ�����塣���
ʹ�÷������ģ�巽��ģʽ������ʵ�ֶ�һ���̶�����Ļ�����������(ֻ�����ڲ���Ϊ�յ����)��
public abstract class AbsPopulator {
    public final void dataInitialzing() throws Exception {
        // �������public����
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            // �ж��Ƿ������ݳ�ʼ������            
            if (isInitDataMethod(m)) {
                    m.invoke(this);
            }
        }
    }
    
    private boolean isInitDataMethod(Method m) {
        return m.getName().startWith("init")  // init��ʼ 
        && Modifier.isPublic(m.getModifiers()) // ��������
        && m.getReturnType().equals(Void.TYPE) //����ֵ��void
        && !m.isVarArgs() //�������Ϊ��
        && !Modifier.isAbstract(m.getModifiers()); // �����ǳ��󷽷�
    }
}
/* ���ַ�ʽ�����಻��Ҫʵ��ģ�����κγ��󷽷���ֻ��Ҫ�����Ƽ�������
    ����������Ҳ������Լ����ʵ���������������������������������
    �Ĺ���
*/
public class UserPopulator extends AbsPopulator {
    public void initUser() {
        /* ��ʼ���û����紴�����������ݵ� */
    }
    
    public void initPassword() {
        /* ��ʼ������ */
    }
    
    public void initJobs() {
        /* ��ʼ���������� */
    }
}



