import java.util.Date;
/*
	 1.定义：一个对象的状态在对象创建后不再改变
	 2.不变模式缺少改变状态的行为
	 3.优点和缺点：
		 ①优点：允许对一个对象共享，降低并发访问开销，线程安全。
		 ②缺点：需要修改一个对象的状态时，需要建立一个新的同类型对象，并在创建
			 这个新的状态储存在新对象里面。
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 弱不变模式:
			 ①.所有属性都是私有的
			 ②.没有修改属性的公有方法
			 ③.如果属性中有对象类型，并且该对象类型是可变的。不要使用客户端传来的引用，而是在构造函数中自己创建对象。
				 如果必须通过客户端传值，需要在构造函数中克隆对象
			 ④.弱不变模式的缺点：1.子对象是可变的。2.可变子对象可以修改父对象的状态
		 */
		 WeakImmutable i1 = new WeakImmutable("A",1, new Date());
		 
		 /*
			 强不变模式(前提：满足弱不变模式的要求)：
			 ①.方法均为final:保证子类不能通过覆盖重写父类方法从而达到修改状态的目的，但是可以新增方法
			 ②.类为final:保证没有子类
			 ③.私有构造函数，静态工厂提供实例(最好方式)			
		 */
		 StrongImmutable1 si1 = new StrongImmutable1("A",1, new Date());
		 StrongImmutable2 si2 = new StrongImmutable2("A",1, new Date());
		 StrongImmutable3 si3 = StrongImmutable3.getInstance("A",1, new Date());
		 
		 /*
			 String类实际是一个封装类，它封装了char[]数组，java中其他封装类如：Integer,Float,Long等。它们的作用
			 是可以利用封装类将基本类型存入集合中(因为集合不能直接存入int,long等基本类型)。这些封装类是强不变模式
		 */
		 
		 
	 }
}


如何写一个不可变类？
1、不可变对象对于缓存是非常好的选择，因为你不需要担心它的值会被更改。不可变类的另外一个好
处是它自身是线程安全的，你不需要考虑多线程环境下的线程安全问题。
2、要创建不可变类，要实现下面几个步骤：
将类声明为final，所以它不能被继承
将所有的成员声明为私有的，这样就不允许直接访问这些成员
对变量不要提供setter方法
将所有可变的成员声明为final，这样只能对它们赋值一次
通过构造器初始化所有成员，进行深拷贝(deep copy)
在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝
package com.journaldev.java;
 
import java.util.HashMap;
import java.util.Iterator;
 
public final class FinalClassExample {
 
    private final int id;
 
    private final String name;
 
    private final HashMap testMap;
 
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    /**
     * 可变对象的访问方法
     */
    public HashMap getTestMap() {
        //return testMap;
        return (HashMap) testMap.clone();
    }
 
    /**
     * 实现深拷贝(deep copy)的构造器
     * @param i
     * @param n
     * @param hm
     */
 
    public FinalClassExample(int i, String n, HashMap hm){
        System.out.println("Performing Deep Copy for Object initialization");
        this.id=i;
        this.name=n;
        HashMap tempMap=new HashMap();
        String key;
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            key=it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap=tempMap;
    }
}