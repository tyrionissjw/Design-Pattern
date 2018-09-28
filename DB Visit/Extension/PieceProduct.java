package dp.extension;

public class PieceProduct extends Product {
	public PieceProduct() {
		this.addExtension("db", new PieceProductDBExtension());
		this.addExtension("xml", new PieceProductXMLExtension());
	}
}

class PieceProductDBExtension implements DBExtension {
	@Override
	public void doPersist() {
		System.out.println("db");
	}	
}

class PieceProductXMLExtension implements XMLExtension {

	@Override
	public String getXml() {		
		return "xml";
	}
	
}