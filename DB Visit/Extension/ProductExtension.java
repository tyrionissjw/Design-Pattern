package dp.extension;

public interface ProductExtension {

}

interface DBExtension extends ProductExtension {
	public void doPersist();
}

interface XMLExtension extends ProductExtension {
	public String getXml();
}

class BadExtension implements ProductExtension {
	
}

