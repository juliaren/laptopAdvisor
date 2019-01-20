/*
 * Name(s): Isha Raulji, Parth Patel, Julia Ren
 * Date: November 22, 2016
 * Course code: ICS3U1-01
 * Purpose: To create an application that advises the user the best 3 laptops which suits the requirements they inputted.
 * Major skills: File Input, GUI, Arrays, Weighted Decision Matrix...
 * Extra features: menu bar, landing page, background color, user's name
 * Areas of concern: user's name, button image does not match text area info, only show partial laptop image, weighting of laptop
*/




/*
* This is a test class that runs the application.  It includes an array that stores the laptops.  This 
* class then runs the LaptopAdvisorFileInput class and the LaptopAdvisorGUI class.
*
* author - Julia Ren
*/


public class LaptopTest {

	static Laptop[] laptop = new Laptop[30];


	public static void main(String[] args) {

		new FileInput(laptop);

		//for (int x = 0; x < laptop.length; x++)
			//System.out.println(laptop[x]);

		new LaptopAdvisorGUI(laptop);

	}


}