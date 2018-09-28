public class Main {
	 public static void main(String[] args) {
		 /* 
			 未重构前
			 ①与特定Employee类型相关的值域和方法都混杂在Employee中
			 ②当需要添加一个新的Employee类型时，需要逐一修改doBusiness()类似方法中的switch语句
		 */
		 Employee e = new Employee(Employee.ENGINEER);
		 e.doBusiness();
		 /*
			 Replace Type Code With Subclasses
			 ①有不可变的typeCode，它影响宿主class(Employee)行为
			 ②当switch/if-else的出现，这时需要使用Replace Conditional With Polymorphism重构。
				 而这种重构的前提就是使用本项方法先重构
             ③当typecode值在对象创建后改变或者宿主类已经有subclass时，无法使用本项重构，应该使用Replace Type Code With State/Strategy
             ④将subclass作为宿主类的子类，并且将特定子类有关的行为推入子类。
			 ⑤优点：对不同行为的了解从class用户搬移到了class自身，当需要加入新的行为时，只需加入一个新的子类
				 也只有一处会用到switch，即决定创建何种对象
		 */
		 EmployeeRef1 ref1 = EmployeeRef1.create(EmployeeRef1.ENGINEER);		 
		 /*
			 Replace Type Code With State/Strategy
		 */
		 EmployeeRef2 e2 = new EmployeeRef2(EmployeeType.ENGINEER);
		 e2.pay();
		 /*
			 Replace Type Code With Polymorphism(上面是前提)
			 1.将与动作有关的行为放入State对象(EmployeeTypeRef3)中作为抽象方法，并在子类实现
				 这也是它与Replace Type Code With State/Strategy的区别
		 */
		 EmployeeRef3 e3 = new EmployeeRef3(EmployeeTypeRef3.ENGINEER);
		 e3.pay();
	 }
}