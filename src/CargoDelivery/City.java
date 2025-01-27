package CargoDelivery;

public class City {
	private String name ;
	private DistributionCenter<CargoPackage> dCenter;//şimdillik dursun
	
	public City(String name) {
		this.name=name;
		dCenter = new DistributionCenter<>();
	}
	
	
	public String getName() {
		return name;
	}


	public DistributionCenter<CargoPackage> enterToTheDistrubutionCenter() {
		return this.dCenter;
	}

	

}
