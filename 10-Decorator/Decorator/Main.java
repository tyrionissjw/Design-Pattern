/*
	 另一种不改变类层次结构为类增加功能的方法。
*/
public class Main {
	 public static void main(String[] args) {
		 /*
		 1.可以使用两种方式进行装饰。装饰一个业务对象并赋予read和write方法，或者装饰
		 一个知道如何读写自身的数据库对象并赋予它业务规则，后一种方法在使用面向对象数据库
		 时是很有用的。
         */
		 Product p = new ConcreteProduct();
		 Product decorator = new DBDecorator(p);
		 decorator.doBusiness();
		 
		 /*
			 1.对于Moderm类层次，如果有以下需求:
				 假设有一个有很多使用者的应用程序，每一个使用者都可通过计算机要求通过改程序利用调制解调器呼叫另一台计算机。
				 但是有些用户希望听到拨号声，有些则不。
			 对此，可以有以下设计：
				 ①通过在代码中每一处对调制解调器拨号(Moderm的dial方法)的地方询问使用者是否希望听声，代码如下				 	
					 ...
					 Moderm m = user.getModerm();
					 if (user.wantsLoudDial())
						 m.setVolume(11);
					 m.dial(...);
					 ...
				     缺点：代码重复出现在应用程序中
				 ②在每个Moderm的子类中设置一个是否听声的标志，dial方法中根据标志去设置音量
					 ...
					 private boolean wantsLoudDial = false;
					 public void dial() {
						 ...
						 if (wantsLoudDial)
						  setVolume(11);
						 else
						   setVolume(0);
					 }
					 ..
					 缺点：Moderm的子类中必须都有这段代码，Moderm新子类的编写者必须记住这段代码。
				 ③对于实现②的缺点(依赖程序员记忆)，使用Template重构Morderm将其从一个接口变为一个抽象类。
				  让它持有wantsLoudDial实例变量，并且在它的dial函数中先检测完该变量后再去调用真正的dial函数dialForReal
				  ...
				  public void dial() {
					 ...
					 if (wantsLoudDial)
						 setVolume(11);
					 else 
						 setVolume(0);
					 dialForReal();	 
				  }
				  缺点：使用者的突然想法不应该影响Moderm结构，另外因为根据SRP原则，大声拨号的需求和调制解调器的内在功能没关系，所以
				  它不应该成为调制解调器的一部分。				  				  
		 */
		 /*
			 Decorator模式对以上问题的解决.
		 */	
		 Moderm m = new HayezModerm();
		 Moderm decoratorModerm = new LoudDialModerm(m);
		 decoratorModerm.dial();
	 }
}