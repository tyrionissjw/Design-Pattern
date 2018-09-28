/*
	 1.���ã�������һ��һ�Զ��������ϵ���ö���۲���ͬʱ����ĳһ�������������һ�����������״̬�ϵı仯
	 �ܹ�֪ͨ���е������ڴ˶������Щ�۲��߶���ʹ��Щ�۲��߶����ܹ��Զ����¡�
	 2.����ʵ�ַ�ʽ��
		 1.���������᣺ֻ����ӿڣ���ͳ�ġ�
		 2.����������(������)�����ڹ���ۼ��ķ�����notifyObserver(�˷��������ھۼ�����ķ���)�����о��������ɫ���У�
			��ͬ�ۼ����������ƶ��������ɫ�С���ʵ�ַ��ڳ�������,java�Ĺ۲���ģʽʹ�����ַ�ʽ��
	 3.��������е�getObservers����һ��observers�Ĳ��ɱ���ͼ
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
			 Observable�ṩ��Ĭ��ʵ�ֻᰴ��Observers���󱻵ǼǵĴ�����෴����֪ͨ���ǣ��� Observable��������Ը���˳��			
		 */
		 Subjectjava sj = new Subjectjava();
		 Observerjava oj = new Observerjava(sj);
		 sj.changeData("aa");
		 
		 
	 }
}

�໥�ݹ����Observer����ȫ
1��eg��
�������Ǽ������ĸ���Ա�����衢�ְ֡�һ��Ӥ����һ��������СӤ�����˵�ʱ������������򲼣�����������һ��Baby��ı��۲�
�����һ��Mother����ΪBaby�Ĺ۲��ߣ�
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
�����е�ʱ�򣬰ְֻ������ȥ���ߡ�����Dog����һ�����۲��ߣ���Father�����Ĺ۲��ߣ�
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
���ǣ�������������˹�ϵ����Mother��Ϊ��Dog�Ĺ۲��ߣ����������ᱨ�����е�ʱ���ĬĬ��
ΪС�����򲼣������������ᾯ�����Ƿ�����ôһ�����صĴ��󣩡�
��֤һ�£�
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
Ϊ��ȷ��һ��Subject-Observer��ϵ���ܺõĽ���������Ӧ����Java 5����õĹ���֮һ�����͡�ͨ�����Ϳ����ø����bug�ڱ���ʱ�Ϳ�
�Ա��������������������Ӵ�����ȶ��ԡ���������һ��С���⣬��ΪObervable��Observer��Java docs�е�һ���֣����ǲ���Ҳ��Ӧ�ø�
�����ǡ����ԣ����ǿ���ȥ���Ӱ󶨣�ʹ�÷���ǩ�����������ǵ�������������Ǳ���ͨ������ǩ�������뷺�Ͷ��󣬵������еĴ�������
���ļ�
class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A>
interface Observer<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A>
�޸ĺ�
class Baby extends Observable<Baby, Mother, String>
class Mother implements Observer<Baby, Mother, String>
class Dog extends Observable<Dog, Father, String>
class Father implements Observer<Dog, Father, String>
�������������Mother-Dog��ϵ�����뱨��
