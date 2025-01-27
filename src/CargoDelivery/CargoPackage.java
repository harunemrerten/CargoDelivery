package CargoDelivery;

public class CargoPackage {
	
	private String name,cityThatBelongsTo;
	
	public CargoPackage(String name,String cityThatBelongsTo ) {
		this.name=name;
		this.cityThatBelongsTo=cityThatBelongsTo;
	}
	
	
	// I will make a getter for both car's and Vehicle's names and cities 
	String getName(){
		 return name;
	}
	String getCityNameThatBelongsTo() {
		 return cityThatBelongsTo;
	}
	 

}
