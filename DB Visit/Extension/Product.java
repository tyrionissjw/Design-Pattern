package dp.extension;

import java.util.HashMap;
import java.util.Map;

public abstract class Product {
	private Map<String, ProductExtension> its =new HashMap<String, ProductExtension>();
	
	
	public void addExtension(String name, ProductExtension extension) {
		its.put(name, extension);
	}
	
	public ProductExtension getExtension(String name) {
		ProductExtension extension = its.get(name);
		if (extension == null)
			return new BadExtension();
		return extension;
	}
}
