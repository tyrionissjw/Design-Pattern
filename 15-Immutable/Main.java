import java.util.Date;
/*
	 1.���壺һ�������״̬�ڶ��󴴽����ٸı�
	 2.����ģʽȱ�ٸı�״̬����Ϊ
	 3.�ŵ��ȱ�㣺
		 ���ŵ㣺�����һ�����������Ͳ������ʿ������̰߳�ȫ��
		 ��ȱ�㣺��Ҫ�޸�һ�������״̬ʱ����Ҫ����һ���µ�ͬ���Ͷ��󣬲��ڴ���
			 ����µ�״̬�������¶������档
*/
public class Main {
	 public static void main(String[] args) {
		 /*
			 ������ģʽ:
			 ��.�������Զ���˽�е�
			 ��.û���޸����ԵĹ��з���
			 ��.����������ж������ͣ����Ҹö��������ǿɱ�ġ���Ҫʹ�ÿͻ��˴��������ã������ڹ��캯�����Լ���������
				 �������ͨ���ͻ��˴�ֵ����Ҫ�ڹ��캯���п�¡����
			 ��.������ģʽ��ȱ�㣺1.�Ӷ����ǿɱ�ġ�2.�ɱ��Ӷ�������޸ĸ������״̬
		 */
		 WeakImmutable i1 = new WeakImmutable("A",1, new Date());
		 
		 /*
			 ǿ����ģʽ(ǰ�᣺����������ģʽ��Ҫ��)��
			 ��.������Ϊfinal:��֤���಻��ͨ��������д���෽���Ӷ��ﵽ�޸�״̬��Ŀ�ģ����ǿ�����������
			 ��.��Ϊfinal:��֤û������
			 ��.˽�й��캯������̬�����ṩʵ��(��÷�ʽ)			
		 */
		 StrongImmutable1 si1 = new StrongImmutable1("A",1, new Date());
		 StrongImmutable2 si2 = new StrongImmutable2("A",1, new Date());
		 StrongImmutable3 si3 = StrongImmutable3.getInstance("A",1, new Date());
		 
		 /*
			 String��ʵ����һ����װ�࣬����װ��char[]���飬java��������װ���磺Integer,Float,Long�ȡ����ǵ�����
			 �ǿ������÷�װ�ཫ�������ʹ��뼯����(��Ϊ���ϲ���ֱ�Ӵ���int,long�Ȼ�������)����Щ��װ����ǿ����ģʽ
		 */
		 
		 
	 }
}


���дһ�����ɱ��ࣿ
1�����ɱ������ڻ����Ƿǳ��õ�ѡ����Ϊ�㲻��Ҫ��������ֵ�ᱻ���ġ����ɱ��������һ����
�������������̰߳�ȫ�ģ��㲻��Ҫ���Ƕ��̻߳����µ��̰߳�ȫ���⡣
2��Ҫ�������ɱ��࣬Ҫʵ�����漸�����裺
��������Ϊfinal�����������ܱ��̳�
�����еĳ�Ա����Ϊ˽�еģ������Ͳ�����ֱ�ӷ�����Щ��Ա
�Ա�����Ҫ�ṩsetter����
�����пɱ�ĳ�Ա����Ϊfinal������ֻ�ܶ����Ǹ�ֵһ��
ͨ����������ʼ�����г�Ա���������(deep copy)
��getter�����У���Ҫֱ�ӷ��ض��������ǿ�¡���󣬲����ض���Ŀ���
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
     * �ɱ����ķ��ʷ���
     */
    public HashMap getTestMap() {
        //return testMap;
        return (HashMap) testMap.clone();
    }
 
    /**
     * ʵ�����(deep copy)�Ĺ�����
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