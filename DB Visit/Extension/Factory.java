package dp.extension;

public interface Factory {
	public Product getInstance();
}

class AssemblyFactory implements Factory {

	@Override
	public Product getInstance() {
		Product assemble = new AssembleProduct();
		assemble.addExtension("xml", new AssembleProductXMLExtension());
		assemble.addExtension("db", new AssembleProductDBExtension());
		return null;
	}
	
}