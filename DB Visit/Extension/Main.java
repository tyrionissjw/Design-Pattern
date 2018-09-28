package dp.extension;

/*
 1.Extension Object模式:在本身模型中(product)注册一些Extension对象，在运行时通过key得到相应的扩展对象执行相应的功能
 2.它是另一种可以在不改变类层次结构的情况下向类增加功能的方法
 3.层次结构中每个对象都有一个特定的扩展对象列表(product中的itsExtension)，同时，每个对象也提供一个通过名字查找扩展对象的方法(getExtension)
 	扩展对象提供了操作原始层次结构对象的方法。
 4.对于每个功能，都有一个扩展子接口，子接口继承一个顶级父标识接口，扩展功能自己形成一个类体系结构
 5.对于产品对象，产品的顶级是一个抽象父类，对于每一个子产品，上面扩展子接口都针对该对象有一个具体的实现类。

 */
public class Main {

	public static void main(String[] args) {
		Product pieceProduct = new PieceProduct();
		PieceProductDBExtension db = (PieceProductDBExtension) pieceProduct.getExtension("db");
		PieceProductXMLExtension xml = (PieceProductXMLExtension) pieceProduct.getExtension("xml");
		ProductExtension badExtension = pieceProduct.getExtension("aa");
		if (badExtension instanceof BadExtension) {
			System.out.println("bad");
		}
		db.doPersist();
		xml.getXml();

		/*
		 * 扩展对象是通过构造函数传入结构对象(PiecePart,
		 * Assembly)中的，这在某种程度上让结构对象仍然依赖于扩展对象，因此用一个工厂去创建对象结构 对象并装入扩展对象
		 */
		Factory factory = new AssemblyFactory();
		Product assemble = factory.getInstance();
		AssembleProductDBExtension db1 = (AssembleProductDBExtension) assemble.getExtension("db");
		AssembleProductXMLExtension xml1 = (AssembleProductXMLExtension) pieceProduct.getExtension("xml");
		db1.doPersist();
		xml1.getXml();
	}

}
