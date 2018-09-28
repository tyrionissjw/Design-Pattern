/*
	 ①作用：将对象组织到树结构中去，可以用来描述整体与部分关系。它使客户端将单纯元素与复合元素同等看待
	 ②分类：透明式和安全式
	 ③在compoent中加入set和get方法，用以储存父对象。
	 ④在Composite中缓存子构件，通过返回不可修改视图。
	 ⑤透明式中Leaf的add和remove方法可以空实现或者抛出不可支持异常
	 ⑥假设有类A和类B是一对一关联的，想把关联改为一对多。无需构建一个对象列表用于储存这种一对多关系
	 仍使用"一对一"(Composite将单纯元素和复合元素同等看待)。这样，列表管理和遍历的代码在组合类中出现一次，
	 而不是在客户端重复出现。这种改造的前提：只有那些以一致方式对待列表中每一个元素的情况才适合
	 ⑦JDK中使用模式的地方：java.util.Map.putAll(Map m);  
	 
*/
public class Main {
	 public static void main(String[] args) {
		 SafetyComponent cLeaf = new SafetyLeaf();
		 cLeaf.business();
		 SafetyComponent l1 = new SafetyLeaf();
		 SafetyComponent l2 = new SafetyLeaf();
		 SafetyComposite cc = new SafetyComposite();
		 cc.add(l1);
		 cc.add(l2);		 
		 cc.business();
		 System.out.println(cc.getBufferedChildren());
	 }	
}