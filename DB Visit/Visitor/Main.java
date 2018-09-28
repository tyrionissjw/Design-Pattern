/*
	 Visitor模式：另一个可以不改变类层次结构而向其增加新方法的模式	 
	 使用场景：
	 ①若一个应用存在需要以许多不同的方式进行解析的数据结构，就可以使用Visitor。在每个访问者的情况中，所使用的数据结构都独立于它的用途
	 ②应用程序使用配置的数据，不同的子系统通过使用它们自己特有的访问者遍历配置数据来对自己进行初始化
*/
public class Main {
	 /*		 
		 1.需求：有类层次结构Moderm，需要向该类层次结构中(Moderm接口)增加一个新方法，用于
		 使各个Moderm可以在Unix环境下工作，并且子类对该方法的实现都不同。
		 2.若对每一个操作系统的Moderm配置都向Moderm层次结构增加一个新方法，则导致Moderm
		 永远无法关闭。		 
	 */
	 public static void main(String[] args) {
		 /*
			 1.Visitor模式解决上述问题,它使用了Visitor的双重分发技术
			 2.对于被访问层次(Moderm)的每一个子类，访问者都有一个对应的方法，这是从子类到方法的90度转换
			 3.Visitor模式使用其Visitor的子类替代了向Node层次中增加的新方法。
			 4.第一个分发是accept函数，第二个分发是visit函数
			 5.visitor模式的两次分发形成一个功能矩阵，矩阵的一条是不同类型的Moderm，另一条是不同类型的OS，
			 该矩阵的每一条单元格都被一项功能填充			 
		 */
		 ModermVisitor visitor = new UnixModermConfiguration();
		 ModermNode node1 = new HayezModermNode();
		 node1.accept(visitor);		 
		 ModermNode node2 = new ZoomModermNode();
		 node2.accept(visitor);
		 ModermNode node3 = new ErnleModermNode();
		 node3.accept(visitor);
		 
		 /*
			 1.Visitor模式缺点：存在一个依赖环，被访问层次(moderm)依赖于访问层次的基类(ModermVisitor),
				而访问层次依赖于所有被访问的子类。这种方式把访问者和被访问者绑定，每当被访问者增加一个新类
				时，就必须重新编译访问者(ModermVisitor)及其所有子类(即对Visitor基类及子类增加一个新的方法)
			 2.使用Acyclic Visitor模式解决上述依赖环的问题
			 3.它相对Visitor的改变：		
				 ①.基类ModermVisitor变为退化的(AModermVistor即没有方法)，从而解除依赖环(原因：退还后的接口没有方法
				 因此，不依赖于被访问者的三个子类(Moderm))
				 ②.访问者的子类(AUnixModermConfiguration)同样派生自接口，但是是4个。对于被访问层次结构中的每一个子类都有
				 一个对应的接口，这是一个子类到接口的180度转换
			4.Acyclic Visitor适用于被访问层次结构不稳定的情况，但是不适用于实时系统(因为转型需要花费时间)。而Visitor模式相反
			5.Acyclic Visitor创建了一个稀疏矩阵。所有访问者类不需要针对每一个被访问的派生类都实现visit函数。它允许通过不实现
			某个被访问者子类对应的访问者的接口忽略某些派生类和功能的组合(而visitor模式中则会对忽略的visit函数进行空实现)。
		 */
	 }
}