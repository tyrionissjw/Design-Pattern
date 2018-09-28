/*
	 1.作用：定义了一种一对多的依赖关系，让多个观察者同时监听某一个主题对象。这样一个主题对象在状态上的变化
	 能够通知所有的依赖于此对象的那些观察者对象，使这些观察者对象能够自动更新。
	 2.两种实现方式：
		 1.主题对象较轻：只定义接口，传统的。
		 2.主题对象较重(抽象类)：由于管理聚集的方法和notifyObserver(此方法依赖于聚集管理的方法)被所有具体主题角色公有，
			连同聚集本身都可以移动到抽象角色中。将实现放在抽象类中,java的观察者模式使用这种方式。
	 3.主题对象中的getObservers给出一个observers的不可变视图
*/

public class Main {
	 public static void main(String[] args) {
		 Observer o = new ConcreteObserver();
		 Observer o1 = new ConcreteObserver1();
		 Subject s = new ConcreteSubject();
		 s.attach(o);
		 s.attach(o1);
		 s.notifyObservers();
		 
		 
		 /*
			 Observable提供的默认实现会按照Observers对象被登记的次序的相反次序通知它们，但 Observable的子类可以更改顺序。			
		 */
		 Subjectjava sj = new Subjectjava();
		 Observerjava oj = new Observerjava(sj);
		 sj.changeData("aa");
		 
		 
	 }
}

相互递归绑定让Observer更安全
1、eg：
假设我们家里有四个成员：妈妈、爸爸、一个婴儿和一条狗。当小婴儿哭了的时候，妈妈帮他换尿布，所以我们有一个Baby类的被观察
对象和一个Mother类作为Baby的观察者：
public class Baby extends Observable {
   private String name;
   public Baby(String name) {
    this.name = name;
   }
   public void babyIsCrying() {
    setChanged();
    notifyObservers(name);
   }
}
public class Mother implements Observer {
   @Override
   public void update(Observable subject, Object param) {
    String babyName = (String) param;
    System.out.println("Let's change that diaper on " + babyName + "!");
  }
}
当狗叫的时候，爸爸会带它出去走走。所以Dog是另一个被观察者，而Father是它的观察者：
public class Dog extends Observable {
   private String name;
   public Dog(String name) {
    this.name = name;
   }
   public void barks() {
    setChanged();
    notifyObservers(name);
   }
}
public class Father implements Observer {
   @Override
   public void update(Observable o, Object arg) {
    String dogName = (String) arg;
    System.out.println(dogName + ", let's go to a walk!");
   }
}
但是，如果有人理解错了关系，把Mother作为了Dog的观察者（编译器不会报错，运行的时候会默默的
为小狗换尿布，并且甚至不会警告我们犯了这么一个严重的错误）。
验证一下：
public class TestingLegacy {
   public static void main(String[] args) {
   Baby david = new Baby("David");
    Mother mom = new Mother();
 
    Dog rover = new Dog("Rover");
    Father john = new Father();
 
    System.out.println("Add a wrong relationship and test.");
 
    // add the father as the baby's observer
    david.addObserver(john);
    // add the mother as the dog's observer
    rover.addObserver(mom);
 
    david.babyIsCrying();
    rover.barks();
   }
}
为了确保一个Subject-Observer关系被很好的建立，我们应该用Java 5的最好的功能之一：泛型。通过泛型可以让更多的bug在编译时就可
以被检测出来，这样可以增加代码的稳定性。但这里有一个小问题，因为Obervable和Observer是Java docs中的一部分，我们不能也不应该改
变它们。所以，我们可以去增加绑定，使用泛型签名来创建它们的子类而不是它们本身。通过泛型签名来编译泛型对象，但是运行的代码是子
类文件
class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A>
interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A>
修改后
class Baby extends Observable<Baby, Mother, String>
class Mother implements Observer<Baby, Mother, String>
class Dog extends Observable<Dog, Father, String>
class Father implements Observer<Dog, Father, String>
这样，如果创建Mother-Dog关系，编译报错
