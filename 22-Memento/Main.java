/*
	 1.作用：用一个对象来储存另一个对象内部状态的快照。在不破坏封装的情况下(封装分为两个层次：可读不可写，不可读不可写)，
		 将一个对象的状态捕捉并且外部化，在合适的时候把这个对象还原到储存状态。
	 2.备忘录可以保护其内容不被发起人之外的任何对象读取，不可读不可写。
	 3.优点：发起人的状态改变时，可能这个状态无效。这时候就可以使用备忘录角色恢复
	 4.缺点：资源消耗大
	 
   	 ①HttpSession使用备忘录模式
	 发起人：网站系统。备忘录：Object In Session。负责人：HttpSession
	 ②Cookie使用备忘录模式
	 发起人：网站系统。备忘录：Cookie。负责人：浏览器
	 ③Q:有两个网站site1和site2，当一个用户进入site1时，使用session跟踪。用户从site1换到site2，过一段时间又回到site1.这时用户在
		 site1的旧session已经被丢掉。怎样才能保持住session并在用户回到site1后仍能使用？
		 A:第一种解决方案：将session的timeout设为-1，缺点是用户如果不适用logout退出site1而是直接关闭浏览器，session将永远在服务
		 器端存在，浪费资源。
		 B:使用备忘录模式，当HttpSessionBindingListener接口受到session失效的事件后，将session对象储存在数据库或文件中。当用户再次
		 回到site1时，可以重建session
     ④Q:当外部类 outer的实例没有引用，但是内部类Inner仍有引用时。外部类的实例会不会被垃圾回收？
		 A:不会。因为内部类有outer.this指向外部类实例的引用
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 白箱实现：即Memento对Originator和CareTaker都是宽接口，备忘录对象内部所存状态对所有对象都公开
			 白箱实现破坏封装，但通过程序员自律，白箱实现仍是有意义的
		 */
		 // 发起人角色。创建一个含有当前内部发起人内部状态的备忘录对象，使用备忘录对象储存其内部状态
		 OriginatorWhite originator = new OriginatorWhite();
		 // 负责人角色。负责保存备忘录对象，不检查其内容
		 CareTakerWhite ct = new CareTakerWhite();
		 originator.setState("on");
		 MementoWhite memento = originator.createMemento();
		 ct.saveMemento(memento);
		 originator.setState("off");
		 memento = ct.retrieveMemento();
		 originator.restoreMemento(memento);
		 System.out.println(originator.getState());
		 
		 /*
			 多检查点+黑箱实现：
				 1.黑箱的实现原理：使用双重接口(MementorNarrow和MementorBlack)并且将MementorBlack作为OriginatorBlack的内部类，
					 保证OriginatorBlack可以看到Mementor所有接口，而其他类(非同一个包)看不到(如果想看到必须通过OriginatorBlack,因为是内部类)。需要
					 将内部类的方法的修饰符都给成private保证同一个包下的其他类看不到
		 */
		 System.out.println("黑箱多检查点模式");
		 OriginatorBlack ob1 = new OriginatorBlack();
		 CareTakerBlack ct1 = new CareTakerBlack(ob1);
		 ob1.addStates("A");
		 ob1.addStates("B");
		 ct1.createMemento();
		 ob1.addStates("1");
		 ct1.createMemento();
		 ob1.addStates("2");
		 ct1.createMemento();
		 ct1.restoreMementor(0);
		 ob1.print();
		 /*
			 自述历史模式
			 优点：简单
			 缺点：如果系统中有多个发起人角色，由于它们兼任负责人角色，因此就会有多个负责人角色代码重复出现
				 ，而不能达到代码共享的目的，而且不能利用负责人的多态性针对储存多个状态还是单个状态进行负责人
				 代码的编写。
		 */
		 System.out.println("自述历史模式");
		 OriginatorBlack ob2 = new OriginatorBlack();
		 ob2.addStates("A");
		 ob2.addStates("B");
		 MementorNarrow  mementor1 = ob2.createMemento();
		 ob2.addStates("1");
		 MementorNarrow  mementor2 = ob2.createMemento();
		 ob2.addStates("2");
		 MementorNarrow  mementor3 = ob2.createMemento();		 
		 ob2.restoreMementor(mementor1);
		 ob2.print();

		 
	 }
}