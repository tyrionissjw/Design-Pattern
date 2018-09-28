/*
	 0.定义：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法
	 结构的情况下，重新定义算法中的某些步骤。
	 1.使用模板方法时，每当定义一个新的子类时，不要按照控制流程的思路去想，而使应该按照"责任"的思路去想，
	 应该考虑哪些方法时必须重写的，哪些是可以重写的，哪些是不能重写的。
	 2.抽象类的模板方法在子类中必须不加以修改的完全继承，否则违背模板方法的用意。
	 3.抽象类可以有任意多个模板方法，而不限于一个。每一个模板方法都可以调用任意多个具体方法。
	 4.模板方法模式中的基本方法的分类：
		 ①抽象方法：protected修饰，子类实现
		 ②具体方法：private修改，子类不实现或重写
		 ③钩子方法：protected修饰，抽象类提供默认实现或空实现，子类加以扩展，以do命名开头
	 5.在对一个继承等级结构做重构时，应当遵循的原则便是将行为尽量移动到结构的高端，而将状态尽量移动到结构的低端。
		 ①一个类的实现首先建立在行为的基础上，而不是状态的基础上。
		 ②实现行为时，是用抽象状态而不是具体状态。如果行为涉及到对象的状态，使用取值方法而不是直接引用属性。
	 这种方式可以将抽象和具体分割开来，从而保证代码可以最大限度的被复用。	 
	 
	 Servlet技术
	 1.所有的Servlet必须遵循java servlet api.是由两个库包组成：
		 ①javax.servlet:这个库包提供普通servlet模型(假定建立在TCP/IP协议上的)
		 ②javax.servlet.http:这个库包提供HTTP和HTTPS的servlet模型(将与HTTP和HTTPS有关的逻辑放在这个包里)
		 这样做的目的：最大程度上把可能变化的部分和一般性逻辑分开，符合包得开闭原则
	 2.Servlet类库中三个类提供了主要的Servlet架构，这个三个类是：Servlet, GenericServlet,HttpServlet
		 ①Servlet是个接口，声明了三个方法：init(), destroy(), service()。这三个方法决定了servlet的生命周期
		 ②GenericServlet是个抽象类，提供了Servlet接口的默认实现，但却留下了一个service方法，这个方法仍是抽象的。
			 任何具体的servlet都必须提供该方法的实现
		 ③HttpServlet是个抽象类，继承自GenericServlet。它包括service方法和七个do方法的默认实现，这七个do方法涵盖了Http协议的各种请求
	 3.java中的servlet必须直接或间接的实现servlet接口，才能在servlet引擎提供的容器中运行，它的生命周期是由容器管理的
	 4.servlet的生命周期
		 ①加载：容器创建一个或多个servlet对象，这个过程可以在容器加载servlet类时执行，或者servlet对象响应请求时执行，也可在两者之间任何时候执行。
		 ②初始化：调用init方法
		 ③就绪：servlet被初始化后处在能响应请求的就绪状态。当客户端有一个请求时，servlet容器将servletRequest和servletResponse对象都转发给servlet，
			这两个对象以参数形式传给service方法，service方法会进一步调用do方法处理相应的HTTP请求。
		 ④湮灭：destroy
	 5.HttpServlet的service方法是一个模板方法，它调用七个do方法中的一个或几个(根据请求报头if判断调用)来完成客户端的响应，这些do方法需要由HttpServlet
	 的具体子类实现
	 6.Servlet的观察者模式
		 ①Servlet的引擎的事件分为Servlet环境事件和Session事件
		 作用：1.管理数据库和各种资源的使用 2.建立计数机制 3.监视Http Session的状态以及属性		 
		 ②涉及四个监听接口，HttpSessionListener, ServletContextListener,ServletContextAttributeListener,HttpSessionAtrributeListener它们都继承自java.util.
		 EventListener		 
		 ③要对某一个事件做出响应，就必须实现上面相对于这个事件的接口，成为一个监听器类(观察者的角色)。一个监听器类必须有一个默认构造子，必须实现监听器
			 接口的所有要求的方法。
			 
		 
*/
public class Main {
	 public static void main(String[] args) {
		 Template t1 = new ConcreteTemplate1();
		 t1.templateMethod();
	 }
}

/**
    反射让模板方法模式更强大
**/
// 普通模板方法的一个例子，用于在系统启动时，导入sql数据
public abstract class AbsPopulator {
    public final void dataInitialzing() throws Exception {
        doInit();
    }
    
    protected abstract void doInit();
}
// 实现模板类
public class UserPopulator extends AbsPopulator {
    protected void doInit() {
        /* 初始化表，如创建、加载数据等*/
    }
}
这种方式不好，因为所有逻辑在一个方法中写入，并且doInit没有任何业务意义。因此
使用反射改造模板方法模式，反射实现对一批固定规则的基本方法调用(只适用于参数为空的情况)：
public abstract class AbsPopulator {
    public final void dataInitialzing() throws Exception {
        // 获得虽有public方法
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            // 判断是否是数据初始化方法            
            if (isInitDataMethod(m)) {
                    m.invoke(this);
            }
        }
    }
    
    private boolean isInitDataMethod(Method m) {
        return m.getName().startWith("init")  // init开始 
        && Modifier.isPublic(m.getModifiers()) // 公开方法
        && m.getReturnType().equals(Void.TYPE) //返回值是void
        && !m.isVarArgs() //输入参数为空
        && !Modifier.isAbstract(m.getModifiers()); // 不能是抽象方法
    }
}
/* 这种方式的子类不需要实现模板类任何抽象方法，只需要按名称鉴定即可
    方法的数量也不再受约束，实现了子类灵活定义基本方法，父类批量调用
    的功能
*/
public class UserPopulator extends AbsPopulator {
    public void initUser() {
        /* 初始化用户表，如创建、加载数据等 */
    }
    
    public void initPassword() {
        /* 初始化密码 */
    }
    
    public void initJobs() {
        /* 初始化工作任务 */
    }
}



