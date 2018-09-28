package dp.extension;

public class AssembleProduct extends Product {
	 
}

class AssembleProductDBExtension implements DBExtension {
	@Override
	public void doPersist() {
		System.out.println("db");
	}	
}

class AssembleProductXMLExtension implements XMLExtension {

	@Override
	public String getXml() {		
		return "xml";
	}
	
}