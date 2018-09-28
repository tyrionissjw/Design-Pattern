/*
	 1.SpringCallBack中的doPrimary作为传统模板方法的基本方法,SpringTemplate的execute作为传统模板方法的模板方法
	 2.通过回调的方式，就可以通过只添加商业方法(load1等)实现传统模板方法模式中子类实现的功能
	 3.体现了spring依赖优于继承的思想
	 4.适用范围：
		 1.Spring模板方法适用于模板类需要有多个子类实现不同基本方法时，不可能一个操作就通过继承一个子类实现。而spring模板方法通过实现某些callback
		 就可轻松定制Template
		 2.经典的模板方法设计模式适用于如果每个具体的步骤都需要真正去具体实现有多个具体方法，而不是简单的改变参数或设置某个对象就ok的话，
		 使用Callback很难去订制，因为你可能需要传递多个Callback作为参数，并让用户去实现，使用Java的内部类本来就是一个比较丑陋的语法，更何况参数是多个
*/
public class Main {
	 public static void main(String[] args) {
		 SpringTemplate template = new SpringTemplate();
		 template.load1("TEST",1);
	 }
}