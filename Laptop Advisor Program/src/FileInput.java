/*
* This class reads in the laptop data from an external csv file and stores it into a laptop array (a parameter 
* for the class’ constructor).  The data includes both information about the laptop and objective ratings 
* for some its components.
*
* author - Julia Ren
*/




import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class FileInput {
	
	//constructor method
	public FileInput(Laptop[] laptop) {
		
		int index = 0;
		
		try {


			//scan information from the csv file
			Scanner input = new Scanner (new File ("Laptop.csv"));
			
			input.useDelimiter(",");
			
			input.nextLine();


			//store information read in from csv file into variables
			while(index < laptop.length){
				
				laptop[index] = new Laptop();




				laptop[index].setBrand(input.next().replaceAll("//n//r", ""));
				
				laptop[index].setModel(input.next());
				
				laptop[index].setPrice(input.nextDouble());		


				laptop[index].setScreenSize(input.nextDouble());
				
				laptop[index].setDisplay(input.next());
				
				laptop[index].setTouch(input.nextBoolean());
			
				laptop[index].setConvertible(input.nextBoolean());
				
				laptop[index].setCPU(input.next());
				laptop[index].getRatings()[0] = input.nextInt();
				
				laptop[index].setStorage(input.next());
				laptop[index].getRatings()[1] = input.nextInt();
				
				laptop[index].setGraphicsCard(input.next());			
				laptop[index].getRatings()[2] = input.nextInt();
				
				laptop[index].setAudio(input.next());
				
				laptop[index].setBattery(input.nextDouble());
				
				laptop[index].setSoftware(input.next());
				laptop[index].getRatings()[3] = input.nextInt();
				
				laptop[index].setColour(input.next());
				
				laptop[index].setWeight(input.nextDouble());
				
				laptop[index].setWarranty(input.nextInt());
				
				laptop[index].setHyperlink(input.next());
				
				index++;




			}
			
			input.close();
			
		//in case the file is not found
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
			
			e.printStackTrace();
		}
	
	}








}
