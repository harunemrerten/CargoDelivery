package CargoDelivery;


public class Mission {
	
	private String startingCityName,secondDistrubutionCity,theLastDestrubitionCenter ;
	int[] cargoIndexesThatShouldBeUnloaded;//this is for the cargos that should be unloaded at the secondistrubiton center.
	
	public Mission(String startingCityName,String secondDistrubutionCity,String theLastDestrubitionCenter,int cargoIndexNumbers,String[] array) {
		// TODO Auto-generated constructor stub
		this.startingCityName=startingCityName;
		this.secondDistrubutionCity=secondDistrubutionCity;
		this.theLastDestrubitionCenter=theLastDestrubitionCenter;
		cargoIndexesThatShouldBeUnloaded= new int[cargoIndexNumbers];
		for (int a=0;a<cargoIndexNumbers;a++) {
			cargoIndexesThatShouldBeUnloaded[a]=Integer.parseInt(array[a]);
		}
	}
	
	
	
	
	
	
	
	
	public String getStartingCityName() {
		return startingCityName;
	}
	public String getSecondDistrubutionCity() {
		return secondDistrubutionCity;
	}
	public String getTheLastDestrubitionCenter() {
		return theLastDestrubitionCenter;
	}
	public int[] getCargoIndexesThatShouldBeUnloaded() {
		return cargoIndexesThatShouldBeUnloaded;
	}

	

	
	
}
