/*
	 1.���ã����ԶԿͻ���͸���ķ�ʽ��̬��չ������(���ͻ�����װ��ǰ�󲻻���ò�ͬ)���Ǽ̳з�����һ������(
	 ͨ��������������������Ĺ�����չ)
	 
	 2.���ϣ�
	 ����Ҫ��̬��չһ����Ĺ���
	 ����Ҫ��̬��һ���������ӹ��ܣ���Щ���ܿ��Զ�̬������(ֻ����ĳ�������װ�ζ��󣬶�����ļ���Ͷ�̬������)
	 ����Ҫ����һЩ�ɻ�������������϶������ķǳ������Ĺ��ܣ��Ӷ�ʹ�̳�����չ�����ܵĲ���ʵ������滻
	 
	 3.����װ�ν�ɫ(ConcreteDecorator)Ӧ��Component�����࣬�����ͻ��˲���͸������
	 
	 4.װ��ģʽ��̳е���ȱ��
	 ��װ��ģʽ����̬�����ӻ���ٹ��ܣ����̳й�ϵ�Ǿ�̬�ģ�ϵͳ����ǰ�Ѿ��������ܵĶ���
	 ��ͨ��ʹ�ò�ͬ�ľ���װ�����Լ���Щ�����Ͽ��Դ��첻ͬ��Ϊ�����̳���������ͨ������ļ̳з�ʽ��ÿһ�ֲ�ͬ�����������ƺ�
	 �������Ҳ�����׳���װ��ģʽ�������ٵ��࣬���ǲ����϶�Ķ��󣬶���̫��ʹ���������	 
	 
	 5.�����װ��ģʽ���ǰ�͸���ģ�������ConcreteDecorator�в�ͬ�ڽӿ�Component�ķ�����������ΪConcreteCompoent����)
	 ��͸��ģʽ���Կ���������ģʽ����Ϊ��װ�ζ����װ�ζ���û����ͬ�ӿڣ��������ص�����(��������������)����˱�װ�ζ���ת��Ϊ
	 װ�ζ���Ľӿڡ���װ��ģʽ�������Ǳ��ֽӿ�
     
     6�����Խ��������������������з��룬�˴˻���Ӱ�졣�������ӣ�BufferedOutputStream��
     FileOutputStream��װ������BufferedOutputStream��Ҫ�������ӻ��壬�Ż�I/O���ܡ�
	 
	 
*/	
public class Main {
	 public static void main(String[] args) {
		 Component c = new ConcreteCompoent();
		 Component c1 = new ConcreteDecorator(c);
		 Component c2 = new ConcreteDecorator1(c1);
		 // c2ӵ��c+c1�Ĺ���
		 // c2.f();
		 
		 
		 // û��Component�ӿڵ������ConcreteComponent��Ϊ˫�ؽ�ɫ��Decorator�����̳�
		 ConcreteComponentNoComponent cn = new ConcreteComponentNoComponent();
		 ConcreteComponentNoComponent cn1 = new ConcreteDecoratorNoComponent(cn);
		 cn1.f();
	 }
}
/**
    ʹ�÷�������װ��ģʽ���ձ���
    ������һ���Ƚ�ͨ�õ�װ��ģʽ��ֻ��Ҫ���屻װ�ε����Լ�װ���༴�ɣ�
    װ����Ϊ�ɶ�̬����ʵ�֣�ʵ����װ����ͱ�װ������ȫ����
**/
interface Animal {
    public void doStuff();
}
// ����
class Rat implements Animal {
    public void doStuff() {
        ...
    }
}
// �����ر������һЩ����
interface Feature {
    public void load();
}
// ��������
class FlyFeature implements Feature {
    public void load() {...}
}
// �������
class DigFeature implements Feature {
    public void load() {...}
}
/* ����Щ��������һ���ر������
      һ��װ�����ͱ�����Compent(��Animal)�������ͣ�������Ҫʵ��doStuff�����doStuff
      ί�и��˶�̬����ִ�У�
*/
class DecorateAnimal implements Animal {
    // ����װ�Ķ���
    private Animal animal;
    // ʹ����һ����װ��
    private Class<? extends Feature> clz;
    public DecorateAnimal(Animal _animal, Class<? extends Feature> _clz) {
        animal = _animal;
        clz = _clz;
    }
    @Override
    public void doStuff() {
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object p, Method m, Object[] args) throws Throwable {
                Object obj = null;
                // ���ð�װ�����������public�����ŵ���
                if (Modifier.isPublic(m.getModifiers())) {
                    obj = m.invoke(clz.newInstance(), args);
                }
                animal.doStuff();
                return obj;
            }
        };
        ClassLoader cl = getClass().getClassLoader();
        Feature proxy = (Feature)Proxy.newInstance(cl, clz.getInterfaces(), handler);
        proxy.load();
    }
}
// ���÷�ʽ
Animal Jerry = new Rat();
Jerry = new DecorateAnimal(Jerry, FlyFeature.class);
Jerry = new DecorateAnimal(Jerry, DigFeature.class);
Jerry.doStuff();
