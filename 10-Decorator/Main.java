/*
	 1.作用：它以对客户端透明的方式动态扩展对象功能(即客户端在装饰前后不会觉得不同)，是继承方案的一个代替(
	 通过不创建更多的子类对类的功能扩展)
	 
	 2.场合：
	 ①需要动态扩展一个类的功能
	 ②需要动态给一个对象增加功能，这些功能可以动态撤销。(只是用某个级别的装饰对象，对下面的级别就动态撤销了)
	 ③需要增加一些由基本功能排列组合而产生的非常大量的功能，从而使继承来扩展对象功能的不现实情况的替换
	 
	 3.具体装饰角色(ConcreteDecorator)应是Component的子类，这样客户端才能透明调用
	 
	 4.装饰模式与继承的优缺点
	 ①装饰模式允许动态的增加或减少功能，而继承关系是静态的，系统运行前已经决定功能的多少
	 ②通过使用不同的具体装饰类以及这些类的组合可以创造不同行为，而继承则需事先通过子类的继承方式把每一种不同的排列组合设计好
	 ③灵活性也代表易出错，装饰模式产生较少的类，但是产生较多的对象，对象太多使查错变得困难	 
	 
	 5.大多数装饰模式都是半透明的（即允许ConcreteDecorator有不同于接口Component的方法，从声明为ConcreteCompoent引用)
	 半透明模式可以看成适配器模式，因为被装饰对象和装饰对象没有相同接口，但是有重叠方法(符合适配器特征)，因此被装饰对象被转换为
	 装饰对象的接口。但装饰模式的用意是保持接口
     
     6、可以将功能组件和性能组件进行分离，彼此互不影响。代表例子：BufferedOutputStream是
     FileOutputStream的装饰器，BufferedOutputStream主要用于增加缓冲，优化I/O性能。
	 
	 
*/	
public class Main {
	 public static void main(String[] args) {
		 Component c = new ConcreteCompoent();
		 Component c1 = new ConcreteDecorator(c);
		 Component c2 = new ConcreteDecorator1(c1);
		 // c2拥有c+c1的功能
		 // c2.f();
		 
		 
		 // 没有Component接口的情况：ConcreteComponent即为双重角色，Decorator从它继承
		 ConcreteComponentNoComponent cn = new ConcreteComponentNoComponent();
		 ConcreteComponentNoComponent cn1 = new ConcreteDecoratorNoComponent(cn);
		 cn1.f();
	 }
}
/**
    使用反射增加装饰模式的普遍性
    此类是一个比较通用的装饰模式，只需要定义被装饰的类以及装饰类即可，
    装饰行为由动态代理实现，实现了装饰类和被装饰类完全解耦
**/
interface Animal {
    public void doStuff();
}
// 老鼠
class Rat implements Animal {
    public void doStuff() {
        ...
    }
}
// 定义特别老鼠的一些能力
interface Feature {
    public void load();
}
// 飞行能力
class FlyFeature implements Feature {
    public void load() {...}
}
// 钻地能力
class DigFeature implements Feature {
    public void load() {...}
}
/* 把这些能力赋给一个特别的老鼠
      一个装饰类型必须是Compent(即Animal)的子类型，它必须要实现doStuff，这个doStuff
      委托给了动态代理执行，
*/
class DecorateAnimal implements Animal {
    // 被包装的动物
    private Animal animal;
    // 使用哪一个包装器
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
                // 设置包装条件，如果是public方法才调用
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
// 调用方式
Animal Jerry = new Rat();
Jerry = new DecorateAnimal(Jerry, FlyFeature.class);
Jerry = new DecorateAnimal(Jerry, DigFeature.class);
Jerry.doStuff();
