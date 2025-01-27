package CargoDelivery;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	
	
	public static void main(String[] args) {
		String tasıyıcı;// this object will used by me to take writings from txt's to normal string  
		File cities = new File("cities.txt");//instead of writing the url of every txt instead ı created file class and use it to the other class that requires urls
		File vehicles = new File("vehicles.txt");
		File packages = new File("packages.txt");
		File missions = new File("missions.txt");
		City[] city=null;
		CargoPackage[] cargoPackage=null;
		@SuppressWarnings("rawtypes")
		Vehicle[] vehicle=null;
		Mission[] mission=null;
		
		// In this part I handled creating the City objects ı used FileReader and BufferedReader to read txt and StringBuffer to get it as String
		try {
			FileReader reader= new FileReader(cities);
			BufferedReader bfReader = new BufferedReader(reader);
			StringBuffer stringBuffer = new StringBuffer();
			
			while((tasıyıcı=bfReader.readLine())!=null) {
				stringBuffer.append(tasıyıcı);
				stringBuffer.append("\r");
			}
			
			tasıyıcı=stringBuffer.toString();
			String[] strArray = tasıyıcı.lines().toArray(String[]::new);
			city= new City[strArray.length];
			
			for(int a=0;a<strArray.length;a++) {
				city[a]= new City(strArray[a]);
				
			}
			
			bfReader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// In this part I handled creating the Cargo package objects
		try {
			FileReader reader= new FileReader(packages);
			BufferedReader bfReader = new BufferedReader(reader);
			StringBuffer stringBuffer = new StringBuffer();
	
			while((tasıyıcı=bfReader.readLine())!=null) {
				stringBuffer.append(tasıyıcı);
				stringBuffer.append("\r");
			}
			
			tasıyıcı=stringBuffer.toString();
			String[] strArray = tasıyıcı.lines().toArray(String[]::new);
			cargoPackage = new CargoPackage[strArray.length];
			
			for(int a=0; a<strArray.length;a++) {
				String[] strArrayForDividing = strArray[a].split(" ");
				cargoPackage[a] = new CargoPackage(strArrayForDividing[0],strArrayForDividing[1]);
				
			}
			
			bfReader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// In this part I handled creating the Vehicle object it was really so challenging
		
		try {
			
				FileReader reader= new FileReader(vehicles);
				BufferedReader bfReader = new BufferedReader(reader);
				StringBuffer stringBuffer = new StringBuffer();
					
				while((tasıyıcı=bfReader.readLine())!=null) {
					stringBuffer.append(tasıyıcı);
					stringBuffer.append("\r");
				}
				
				tasıyıcı=stringBuffer.toString();
				String[] strArray = tasıyıcı.lines().toArray(String[]::new);
				vehicle = new Vehicle[strArray.length];
				// this part was really challenging. I even try to get help from chatgpt at first for the help we created Vehicle<CargoPackage>[] but it required casting becuase generic disable me using array but after hardnes ı come up with creating an generic object then adding to the array without generic. I asked chatgpt if the delete my generic that object it says that no so...
				for(int a=0;a<strArray.length;a++) {
					String[] strArrayForDividing = strArray[a].split(" ");
					Vehicle<CargoPackage> tempVehicleObject= new Vehicle<>(strArrayForDividing[0],strArrayForDividing[1],Double.parseDouble(strArrayForDividing[2]));     
					vehicle[a]= tempVehicleObject;
					
				}
					
					
				bfReader.close();
			} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		try {// for the missions ı Created this loop exactly like the others
			FileReader reader= new FileReader(missions);
			BufferedReader bfReader = new BufferedReader(reader);
			StringBuffer stringBuffer = new StringBuffer();
			
			while((tasıyıcı=bfReader.readLine())!=null) {
				stringBuffer.append(tasıyıcı);
				stringBuffer.append("\r");
			}
			
			tasıyıcı=stringBuffer.toString();
			String[] strArray = tasıyıcı.lines().toArray(String[]::new);
			mission= new Mission[strArray.length];
			for(int a=0;a<strArray.length;a++) {
				String[] strArrayForDividing = strArray[a].split("-");
				String[] strArrayForDividing2 = strArrayForDividing[strArrayForDividing.length-1].split(",");
				mission[a]= new Mission(strArrayForDividing[0], strArrayForDividing[1],strArrayForDividing[2],strArrayForDividing2.length, strArrayForDividing2);// ı am taking the names of the centers cargo numbers that should be unloaded at 2nd dis center and a string array cus ı dont know how much cargo that should ı leave at second part
				
			}
			
			
			bfReader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(vehicle!=null) {// this solution is given by chatgpt either ı have encountered with array is not initialized error because i initialized them in try catch blocks but with initializing at first null then controlling it buy if statement ı could handled it
			for (int a=0;a<vehicle.length;a++) {
				for(City b : city) {
					
					if(b.getName().equals(vehicle[a].getCityNameThatBelongsTo())) {//ı am trying to add the vehicle to the right city by comparing their names
						b.enterToTheDistrubutionCenter().enterTheWarehouse().addVehicleToTheWarehouse(vehicle[a]);// ıknow the warning will not affect me but @SuppressWarnings("unchecked") ı wanted to write this but ı could not.
	
					}
					else {
		
					}
				}
			}
		}
		
		if(cargoPackage!=null) {// and exactly the same progress ı am for the cargo packages
			for (int a=0;a<cargoPackage.length;a++) {
				for(City b : city) {
					
					if(b.getName().equals(cargoPackage[a].getCityNameThatBelongsTo())) {//ı am trying to add the vehicle to the right city by comparing their names
						b.enterToTheDistrubutionCenter().push(cargoPackage[a]);;// ıknow the warning will not affect me but @SuppressWarnings("unchecked") ı wanted to write this but ı could not.
						
					}
					else {
						
					}
				}
			}
		}
		
		
		
		if(mission!=null) {
			for(Mission görevler: mission) {// at the first ı did this part for mission twice because there was 2 mission now o change it to for each loops
				if(city!=null) {
					Vehicle<CargoPackage> vehicleForTheMission=null;
					for(City b : city) {// this is done by mission[]
						
						if(görevler.getStartingCityName().equals(b.getName())){
							vehicleForTheMission=b.enterToTheDistrubutionCenter().enterTheWarehouse().getVehicleFromWarehouse();
							//I get My first vehicle in the for loop ı want to finish all missions
							vehicleForTheMission.push(vehicleForTheMission);// hoca wants us to add vehicle to the head even tho it did not fit my algortihm still it is legal
							while(!b.enterToTheDistrubutionCenter().isEmpty()) {
								vehicleForTheMission.push(b.enterToTheDistrubutionCenter().pop());
							}}// I entered the first place and get all the packages from the city now for the second		   }	
			}
			for(City c :city) {
				if(görevler.getSecondDistrubutionCity().equals(c.getName())) {
					//I get My first vehicle in the for loop ı want to finish all missions
				while(!c.enterToTheDistrubutionCenter().isEmpty()) {
					vehicleForTheMission.push(c.enterToTheDistrubutionCenter().pop());
				}// I have finished getting cargos from the city but we need to leave cargos
				for(int index=0;index<görevler.cargoIndexesThatShouldBeUnloaded.length;index++) {
				 c.enterToTheDistrubutionCenter().push(vehicleForTheMission.dropPackageByIndex(görevler.cargoIndexesThatShouldBeUnloaded[index]));// in this part ı have indexes of cargos in mission so that ı am droping to dCenter from Vehicle
						}}}
					
				for(City d:city) {
					if(görevler.getTheLastDestrubitionCenter().equals(d.getName())) {// now it is time for the last part leaving the cargos and 
						//I get My first vehicle in the for loop ı want to finish all missions
						while(vehicleForTheMission.getSizeOfTheStack()>1)	{// here ı did not use the part of the İsEmpty method because ı do not want to loose the head vehicle object
						d.enterToTheDistrubutionCenter().push(vehicleForTheMission.pop());	
						}
						d.enterToTheDistrubutionCenter().enterTheWarehouse().addVehicleToTheWarehouse((Vehicle<CargoPackage>)(vehicleForTheMission.pop()));// this is seemingly wrong but ı tried in different thing if the last thing is cargıVehicle itself it works if not it is not true castinf
						vehicleForTheMission = null;
							}}	
					
				}
				}
			}
		
		
		
		// for the answer
		StringBuffer whole=new StringBuffer();
		for(City a: city) {
			StringBuffer stBfr= new StringBuffer();	
			stBfr.append(a.getName()+"\rPackages:\r");
			while(!a.enterToTheDistrubutionCenter().isEmpty()) {
				stBfr.append(a.enterToTheDistrubutionCenter().pop().getName()+"\r");
				}
			stBfr.append("Vehicles:\r");
			while(!a.enterToTheDistrubutionCenter().enterTheWarehouse().isEmpty()) {
				stBfr.append(a.enterToTheDistrubutionCenter().enterTheWarehouse().getVehicleFromWarehouse().getName()+"\r");
			}
			stBfr.append("-------------\r");
			whole.append(stBfr);
		}

		System.out.println(whole);
		
		
		// I got my result exactly like the result.txt now ı should delete it and Create new one for my self to use Io again,
		
		File resultFile= new File("result.txt");
		
		if(!resultFile.exists()) {
			try {
				resultFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter resultWriter = new FileWriter(resultFile);
			BufferedWriter bFWriter = new BufferedWriter(resultWriter);
			bFWriter.write(whole.toString());
			bFWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

		
		// I also created a tester class which very like the my Main class and I am Callin this by its own method
		System.out.println(" for the tester:\r");
		Tester testerAbi= new Tester();
		
		
		
		
		
		
		

	}

}
