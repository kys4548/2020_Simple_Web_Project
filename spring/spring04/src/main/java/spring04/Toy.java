package spring04;

import javax.Inject.Named;
import javax.inject.Inject;
public class Toy {
	
	@Inject
	@Named(value="battery1")
	Battery battery;
	
	
	public Toy() {
		
	}
	
}
