/*
 * This class contains a frame with two panels - user and report.  It allows the user to enter their    
 * subjective ratings and their weightings for all criteria.  It then allows the user to see a report 
 * that produces the top 3 laptops that best meet their criteria (i.e. score highest using the wdm).
 *
 * authors - Isha Raulji, Parth Patel, Julia Ren
 */




import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.*;


public class LaptopAdvisorGUI extends JFrame implements ActionListener {


	//create the report panel, user panel and landing page panel
	JPanel reportPanel = new JPanel();
	JPanel userPanel = new JPanel();
	JPanel landingPanel = new JPanel();


	//create combo box arrays
	@SuppressWarnings("unchecked")
	//create combo box arrays
	JComboBox<Integer>[] weightingComboBoxArray = new JComboBox [11];


	//create menu items for the menu
	JMenuItem landingItem = new JMenuItem("Landing Page");	//directs user to the landing panel
	JMenuItem userItem = new JMenuItem("Weightings");	//directs user to the user panel
	JMenuItem reportItem = new JMenuItem("Result");	//directs user to the report panel
	JMenuItem helpItem = new JMenuItem("Help");	//pop up window with description of the program

	//create score index array
	int [] scoreIndex = new int[3];


	//labels for the panels
	JLabel userTitle = new JLabel();
	JLabel mainTitle = new JLabel("Your Laptop Advisor");
	JLabel enterName = new JLabel("Please Enter Your Name:");

	//label for radio buttons
	JLabel[] rbLabel = new JLabel[11];

	//create label array for combo boxes
	JLabel[] weightingLabelArray = new JLabel[11];


	//Buttons for starting the program, exiting, calculating your top 3 laptops and array to display laptops' image
	JButton start = new JButton();
	JButton exit = new JButton();
	JButton calculate = new JButton();
	JButton[] laptopImageButton = new JButton [3];




	//setting up a text area where the info of about the laptop is going to go
	JTextArea nameText = new JTextArea();

	//name of user
	User user = new User();

	//Declaring what each radio button group is for and [Number of radio buttons in the group]
	JRadioButton[] priceRadioButton = new JRadioButton[3];
	ButtonGroup priceButtonGroup = new ButtonGroup();


	JRadioButton[] screenSizeRadioButton = new JRadioButton[3];
	ButtonGroup screenSizeGroup = new ButtonGroup();

	JRadioButton[] convertibleRadioButton = new JRadioButton[2];
	ButtonGroup convertibleButtonGroup = new ButtonGroup();


	JRadioButton[] touchRadioButton = new JRadioButton[2];
	ButtonGroup touchButtonGroup = new ButtonGroup();


	JRadioButton[] softwareRadioButton = new JRadioButton[3];
	ButtonGroup softwareButtonGroup = new ButtonGroup();

	JRadioButton[] brandRadioButton = new JRadioButton[8];
	ButtonGroup brandButtonGroup = new ButtonGroup();


	JRadioButton[] weightRadioButton = new JRadioButton[3];
	ButtonGroup weightButtonGroup = new ButtonGroup();

	JRadioButton[] warrantyRadioButton = new JRadioButton[2];
	ButtonGroup warrantyButtonGroup = new ButtonGroup();


	JRadioButton[] CPURadioButton = new JRadioButton[3];
	ButtonGroup CPUButtonGroup = new ButtonGroup();


	JRadioButton[] storageRadioButton = new JRadioButton[3];
	ButtonGroup storageButtonGroup = new ButtonGroup();

	JRadioButton[] graphicsRadioButton = new JRadioButton[3];
	ButtonGroup graphicsButtonGroup = new ButtonGroup();

	
	/*
	 * A constructor method that reads in the full laptop list and sets up the user panel,
	 * report panel and frame
	 *
	 *  author - Parth Patel
	 */
	//Constructor method bringing the panels onto the screen
	private Laptop[] laptopArray;


	public LaptopAdvisorGUI(Laptop [] laptopArray){








		this.laptopArray = laptopArray;




		//Calling in the frames
		frameSetup();
















	}




	/*
	 * This method setups up the frame with a menu
	 *
	 * author - Julia Ren
	 */


	private void frameSetup(){




		//set title of frame
		setTitle("Laptop Advisor Program");




		//set frame layout to manual
		setLayout(null);




		//exit program when frame window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




		//set size of the frame
		setSize(1366, 768);




		//create menu bar
		JMenuBar laptopMenuBar = new JMenuBar();




		//create menu
		JMenu laptopMenu = new JMenu("Menu");








		//add action listener to menu items and add them to the menu
		landingItem.addActionListener(this);
		laptopMenu.add(landingItem);


		userItem.addActionListener(this);
		laptopMenu.add(userItem);


		reportItem.addActionListener(this);
		laptopMenu.add(reportItem);


		helpItem.addActionListener(this);
		laptopMenu.add(helpItem);








		//add menu to menu bar
		laptopMenuBar.add(laptopMenu);








		//add menu bar to frame
		setJMenuBar(laptopMenuBar);






		//call the panels
		landingPanelSetup();
		userPanelSetup();
		reportPanelSetup();








		//make the frame visible
		setVisible(true);




	}



	/*
	 * This method setups the landing panel
	 *
	 * author -Julia Ren
	 */

	private void landingPanelSetup(){


		//set balance for landing page
		landingPanel.setLayout(null);
		landingPanel.setBounds(0, 0, 1366, 768);
		landingPanel.setBackground(Color.pink);






		//set balance for the labels and add it to the landing page
		mainTitle.setBounds(200, 0, 1000, 300);
		mainTitle.setFont((mainTitle.getFont().deriveFont(64.0f)));
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		landingPanel.add(mainTitle);




		enterName.setBounds(450, 100, 500, 300);
		enterName.setFont((enterName.getFont().deriveFont(28.0f)));
		enterName.setHorizontalAlignment(SwingConstants.CENTER);
		landingPanel.add(enterName);




		//set balance for the text area and add it to the landing page
		nameText.setBounds(600, 300, 200, 50);
		nameText.setFont(nameText.getFont().deriveFont(20.0f));
		landingPanel.add(nameText);
		user.setName(nameText.getText());




		//set balance for the start button and add it to the landing page
		start.setBounds(600, 400, 200, 100);
		start.setText("Start!");
		start.setFont((start.getFont().deriveFont(55.0f)));
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.addActionListener(this);
		landingPanel.add(start);



		//add landing page panel to the frame
		add(landingPanel);

	}


	/*
	 * This method setups up the user panel for inputting their subjective ratings and weightings
	 *
	 * author -Isha Raulji
	 */


	private void userPanelSetup() {




		userPanel.setLayout(null);
		userPanel.setBounds(0, 0, 1366, 768);
		userPanel.setBackground(Color.pink);


		setupRadioButtons();
		setupWeightings();


		//set balance for the calculate button and add it to the user panel
		calculate.setBounds(600, 615, 250, 75);
		calculate.setText("Find Laptops");
		calculate.setFont((calculate.getFont().deriveFont(35.0f)));
		calculate.setHorizontalAlignment(SwingConstants.CENTER);
		calculate.addActionListener(this);
		userPanel.add(calculate);


		//set balance for the title label and add it to the user panel
		userTitle.setBounds(450, 0, 600, 50);
		userTitle.setText(user.getName() + ", find the best laptop for you!");
		//userTitle.setFont((userTitle.getFont().deriveFont(30.0f)));
		userTitle.setHorizontalAlignment(SwingConstants.CENTER);
		userPanel.add(userTitle);

		userPanel.setVisible(true);




		add(userPanel);




	}




	/*
	 * This method sets up the radio buttons
	 *
	 * author -Parth Patel
	 */


	private void setupRadioButtons() {








		//Labels for each objective weighting
		rbLabel[0] = new JLabel("What is your price range?");
		rbLabel[1] = new JLabel("What is your preferred screen size?");
		rbLabel[2] = new JLabel("Would you like a convertible laptop?");
		rbLabel[3] = new JLabel("Would you like a touchscreen laptop?");
		rbLabel[4] = new JLabel("What level of software would you prefer?");
		rbLabel[5] = new JLabel("What brand would you prefer?");
		rbLabel[6] = new JLabel("How heavy would you prefer?");
		rbLabel[7] = new JLabel("Would you like to have a warranty?");
		rbLabel[8] = new JLabel("What rating CPU would you prefer?");
		rbLabel[9] = new JLabel("What storage size would you prefer?");
		rbLabel[10] = new JLabel("What graphics quality would you prefer?");






		//Radio buttons under price
		priceRadioButton[0] = new JRadioButton("< $500");
		priceRadioButton[1] = new JRadioButton("$500 - $1000");
		priceRadioButton[2] = new JRadioButton("> $1000");




		//Radio buttons under the screen size section
		screenSizeRadioButton[0] = new JRadioButton("< 13in");
		screenSizeRadioButton[1] = new JRadioButton("13in - 15in");
		screenSizeRadioButton[2] = new JRadioButton("> 15in");








		//Radio buttons to ask is they want convertible
		convertibleRadioButton[0] = new JRadioButton("No");
		convertibleRadioButton[1] = new JRadioButton("Yes");








		//Radio buttons asking for touch screen
		touchRadioButton[0] = new JRadioButton("No");
		touchRadioButton[1] = new JRadioButton("Yes");






		//Radio buttons asking what software they would prefer
		softwareRadioButton[0] = new JRadioButton("Low");
		softwareRadioButton[1] = new JRadioButton("Medium");
		softwareRadioButton[2] = new JRadioButton("High");






		//Radio buttons asking what brand they would prefer
		brandRadioButton[0] = new JRadioButton("Lenovo");
		brandRadioButton[1] = new JRadioButton("HP");
		brandRadioButton[2] = new JRadioButton("Acer");
		brandRadioButton[3] = new JRadioButton("Asus");
		brandRadioButton[4] = new JRadioButton("Microsoft");
		brandRadioButton[5] = new JRadioButton("Dell");
		brandRadioButton[6] = new JRadioButton("MSI");
		brandRadioButton[7] = new JRadioButton("Apple");




		//Radio buttons asking the weight they would prefer             
		weightRadioButton[0] = new JRadioButton("< 1kg");
		weightRadioButton[1] = new JRadioButton("1kg-2kg");
		weightRadioButton[2] = new JRadioButton(">2kg");






		//Radio buttons asking for warranty
		warrantyRadioButton[0] = new JRadioButton("No");
		warrantyRadioButton[1] = new JRadioButton("Yes");








		//Radio buttons asking for CPU
		CPURadioButton[0] = new JRadioButton("Low");
		CPURadioButton[1] = new JRadioButton("Medium");
		CPURadioButton[2] = new JRadioButton("High");






		//Radio buttons asking for storage
		storageRadioButton[0] = new JRadioButton("Low");
		storageRadioButton[1] = new JRadioButton("Medium");
		storageRadioButton[2] = new JRadioButton("High");






		//Radio buttons asking for graphics
		graphicsRadioButton[0] = new JRadioButton("Low");
		graphicsRadioButton[1] = new JRadioButton("Medium");
		graphicsRadioButton[2] = new JRadioButton("High");








		for (int x = 0; x < priceRadioButton.length;x++)
			priceButtonGroup.add(priceRadioButton[x]);




		for (int x = 0; x < screenSizeRadioButton.length;x++)
			screenSizeGroup.add(screenSizeRadioButton[x]);




		for (int x = 0; x < convertibleRadioButton.length;x++)
			convertibleButtonGroup.add(convertibleRadioButton[x]);




		for (int x = 0; x < touchRadioButton.length;x++)
			touchButtonGroup.add(touchRadioButton[x]);




		for (int x = 0; x < softwareRadioButton.length;x++)
			softwareButtonGroup.add(softwareRadioButton[x]);




		for (int x = 0; x < brandRadioButton.length;x++)
			brandButtonGroup.add(brandRadioButton[x]);




		for (int x = 0; x < weightRadioButton.length;x++)
			weightButtonGroup.add(weightRadioButton[x]);




		for (int x = 0; x < warrantyRadioButton.length;x++)
			warrantyButtonGroup.add(warrantyRadioButton[x]);




		for (int x = 0; x < CPURadioButton.length;x++)
			CPUButtonGroup.add(CPURadioButton[x]);




		for (int x = 0; x < storageRadioButton.length;x++)
			storageButtonGroup.add(storageRadioButton[x]);




		for (int x = 0; x < graphicsRadioButton.length;x++)
			graphicsButtonGroup.add(graphicsRadioButton[x]);




		// (Left/right, up/down)




		//Setting the position of each radio button and label


		rbLabel[0].setLayout(null);
		rbLabel[0].setBounds(15,75,150,25);
		userPanel.add(rbLabel[0]);






		for (int x = 0; x < priceRadioButton.length;x++){


			priceRadioButton[x].setLayout(null);
			priceRadioButton[x].addActionListener(this);
			//Setting the boundary of each radio button depending on its position
			priceRadioButton[x].setBounds(25, 115 + 4 * (x * 10),100 ,20);
			//adding the button to the userPanel
			userPanel.add(priceRadioButton[x]);
		}


		rbLabel[1].setLayout(null);
		rbLabel[1].setBounds(175,75,300,25);
		userPanel.add(rbLabel[1]);


		for (int x = 0; x < screenSizeRadioButton.length;x++){


			screenSizeRadioButton[x].setLayout(null);
			screenSizeRadioButton[x].addActionListener(this);
			screenSizeRadioButton[x].setBounds(225, 115 + 4 * (x * 10),100 ,20);
			userPanel.add(screenSizeRadioButton[x]);
		}


		rbLabel[2].setLayout(null);
		rbLabel[2].setBounds(400,75,300,25);
		userPanel.add(rbLabel[2]);


		for (int x = 0; x <  convertibleRadioButton.length;x++){


			convertibleRadioButton[x].setLayout(null);
			convertibleRadioButton[x].addActionListener(this);
			convertibleRadioButton[x].setBounds(450, 115 + 4 * (x * 10),100 ,20);
			userPanel.add( convertibleRadioButton[x]);
		}


		rbLabel[3].setLayout(null);
		rbLabel[3].setBounds(625,75,300,25);
		userPanel.add(rbLabel[3]);


		for (int x = 0; x <  touchRadioButton.length;x++){




			touchRadioButton[x].setLayout(null);
			touchRadioButton[x].addActionListener(this);
			touchRadioButton[x].setBounds(675, 115 + 4 * (x * 10),100 ,20);
			userPanel.add( touchRadioButton[x]);
		}


		rbLabel[4].setLayout(null);
		rbLabel[4].setBounds(855,75,250,25);
		userPanel.add(rbLabel[4]);


		for (int x = 0; x <  softwareRadioButton.length;x++){




			softwareRadioButton[x].setLayout(null);
			softwareRadioButton[x].addActionListener(this);
			softwareRadioButton[x].setBounds(900, 115 + 4 * (x * 10),100 ,20);
			userPanel.add( softwareRadioButton[x]);
		}


		rbLabel[5].setLayout(null);
		rbLabel[5].setBounds(1150,50,250,25);
		userPanel.add(rbLabel[5]);






		for (int x = 0; x <  brandRadioButton.length;x++){




			brandRadioButton[x].setLayout(null);




			brandRadioButton[x].addActionListener(this);
			brandRadioButton[x].setBounds(1200, 95 + 4 * (x * 10),100 ,20);
			userPanel.add( brandRadioButton[x]);
		}






		rbLabel[6].setLayout(null);
		rbLabel[6].setBounds(15,250,200,25);
		userPanel.add(rbLabel[6]);






		for (int x = 0; x <  weightRadioButton.length;x++){


			weightRadioButton[x].setLayout(null);
			weightRadioButton[x].setBounds(25, 290 + 4 * (x * 10),100 ,20);
			weightRadioButton[x].addActionListener(this);
			userPanel.add( weightRadioButton[x]);
		}


		rbLabel[7].setLayout(null);
		rbLabel[7].setBounds(200,250,200,25);
		userPanel.add(rbLabel[7]);






		for (int x = 0; x <  warrantyRadioButton.length;x++){


			warrantyRadioButton[x].setLayout(null);
			warrantyRadioButton[x].setBounds(225, 290 + 4 * (x * 10),100 ,20);
			warrantyRadioButton[x].addActionListener(this);
			userPanel.add( warrantyRadioButton[x]);
		}




		rbLabel[8].setLayout(null);
		rbLabel[8].setBounds(425,250,200,25);
		userPanel.add(rbLabel[8]);






		for (int x = 0; x <  CPURadioButton.length;x++){


			CPURadioButton[x].setLayout(null);
			CPURadioButton[x].setBounds(450, 290 + 4 * (x * 10),100 ,20);
			CPURadioButton[x].addActionListener(this);
			userPanel.add( CPURadioButton[x]);
		}




		rbLabel[9].setLayout(null);
		rbLabel[9].setBounds(655,250,250,25);
		userPanel.add(rbLabel[9]);






		for (int x = 0; x <  storageRadioButton.length;x++){


			storageRadioButton[x].setLayout(null);
			storageRadioButton[x].setBounds(675, 290 + 4 * (x * 10),100 ,20);
			storageRadioButton[x].addActionListener(this);
			userPanel.add( storageRadioButton[x]);
		}




		rbLabel[10].setLayout(null);
		rbLabel[10].setBounds(885,250,250,25);
		userPanel.add(rbLabel[10]);






		for (int x = 0; x <  graphicsRadioButton.length;x++){


			graphicsRadioButton[x].setLayout(null);
			graphicsRadioButton[x].setBounds(900, 290 + 4 * (x * 10),100 ,20);
			graphicsRadioButton[x].addActionListener(this);
			userPanel.add( graphicsRadioButton[x]);


		}
	}




	/*
	 * This method setups up the weightings
	 *
	 * author - Julia Ren
	 */


	private void setupWeightings(){


		//create each individual label and input text into the labels
		weightingLabelArray[0] = new JLabel("Importance of price:");
		weightingLabelArray[1] = new JLabel("Importance of screen size:");
		weightingLabelArray[2] = new JLabel("Importance of convertible:");
		weightingLabelArray[3] = new JLabel("Importance of CPU:");
		weightingLabelArray[4] = new JLabel("Importance of graphics:");
		weightingLabelArray[5] = new JLabel("Importance of warranty:");
		weightingLabelArray[6] = new JLabel("Importance of brand:");
		weightingLabelArray[7] = new JLabel("Importance of storage:");
		weightingLabelArray[8] = new JLabel("Importance of software:");
		weightingLabelArray[9] = new JLabel("Importance of weight:");
		weightingLabelArray[10] = new JLabel("Importance of touch screen:");






		//loop to place labels and combo boxes on the user panel
		for (int index = 0; index <= 10; index++){


			weightingComboBoxArray[index] = new JComboBox<Integer>();


			if(index<=5){
				weightingLabelArray[index].setBounds(100+index*200, 400, 200, 50);
				weightingComboBoxArray[index].setBounds(150+index*200, 450, 50, 50);
			}else{
				weightingLabelArray[index].setBounds(25+(index-5)*200, 500, 200, 50);
				weightingComboBoxArray[index].setBounds(35+(index-5)*200, 550, 50, 50);


			}


			//setup values available for the user to select inside the combo boxes
			for (int value = 0; value <= 10; value ++)
				weightingComboBoxArray[index].addItem(value);


			//add the labels and combo boxes onto the user panel
			userPanel.add(weightingLabelArray[index]);
			userPanel.add(weightingComboBoxArray[index]);




		}




	}




	/*
	 * This method sets up the report panel
	 *
	 * author - Isha Raulji
	 */


	private void reportPanelSetup() {




		//call create report method
		createReport();








		//set balance and layout
		reportPanel.setLayout(null);
		reportPanel.setBounds(0, 0, 1366, 768);
		reportPanel.setBackground(Color.pink);






		JLabel reportIntro = new JLabel(user.getName() + ", here are 3 laptops that best fit your requirements!");




		//set up exit button and add it to the report panel
		exit.setBounds(1000, 650, 225, 50);
		exit.setText("Exit Program");
		exit.setFont((exit.getFont().deriveFont(30.0f)));
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.addActionListener(this);
		reportPanel.add(exit);




		reportPanel.add(reportIntro);








		add(reportPanel);








	}




	/*
	 * This method handles all the actions that may occur on the GUI - menus, radio buttons, combo 
	 * boxes, report button, laptop image buttons
	 *
	 * author - ALL
	 */


	public void actionPerformed(ActionEvent e) {






		//if start button is clicked then show user panel
		if (e.getSource() == start){
			landingPanel.setVisible(false);
			userPanel.setVisible(true);
			reportPanel.setVisible(false);
			repaint();
		}






		//if the user menu item is clicked then show user panel
		if (e.getSource() == userItem){
			landingPanel.setVisible(false);
			userPanel.setVisible(true);
			reportPanel.setVisible(false);
			repaint();
		}




		//if the report menu item is clicked then show report panel
		if (e.getSource() == reportItem){
			landingPanel.setVisible(false);
			userPanel.setVisible(false);
			reportPanel.setVisible(true);
			repaint();


		}






		//if the help menu item is clicked then show pop up window explaining the program
		if (e.getSource() == helpItem){
			JOptionPane.showMessageDialog(null,"This program is for you to input the requirements for your dream laptop and it will advise you the best 3 laptops that fit your requirements.","Help",JOptionPane.WARNING_MESSAGE);
		}






		//if the landing menu item is clicked then show landing page
		if (e.getSource() == landingItem){
			landingPanel.setVisible(true);
			userPanel.setVisible(false);
			reportPanel.setVisible(false);
			repaint();
		}



		//if the calculate button is clicked then show report panel
		if (e.getSource() == calculate){
			landingPanel.setVisible(false);
			userPanel.setVisible(false);
			reportPanel.setVisible(true);
			repaint();
		}



		//if the exit button is clicked then exit program
		if (e.getSource() == exit){
			System.exit(0);
		}




		//if user selects a laptop image button
		for ( int index = 0 ; index < laptopImageButton.length; index ++) {
			if (e.getSource() == laptopImageButton[index])
				openWebBrowser(index);




		}


		//if user selects a price radio button
		for (int ratings = 0; ratings < priceRadioButton.length; ratings ++){


			if (e.getSource() == priceRadioButton[ratings] )
				setPriceRating(ratings); 


		}


		//if user selects a screen size radio button
		for (int ratings = 0; ratings < screenSizeRadioButton.length; ratings ++){


			if (e.getSource() == screenSizeRadioButton[ratings] )
				setScreenSizeRating(ratings); 




		}


		//if user selects a convertibleradio button
		for (int ratings = 0; ratings < convertibleRadioButton.length; ratings ++){


			if (e.getSource() == convertibleRadioButton[ratings] )
				setConvertibleRating(ratings); 




		}


		//if user selects a touch screen radio button
		for (int ratings = 0; ratings < touchRadioButton.length; ratings ++){


			if (e.getSource() == touchRadioButton[ratings] )
				setTouchRating(ratings); 




		}


		//if user selects a software radio button
		for (int ratings = 0; ratings < softwareRadioButton.length; ratings ++){


			if (e.getSource() == softwareRadioButton[ratings] )
				setSoftwareRating(ratings); 




		}


		//if user selects a brand radio button
		for (int ratings = 0; ratings < brandRadioButton.length; ratings ++){


			if (e.getSource() == brandRadioButton[ratings] )
				setBrandRating(ratings); 




		}


		//if user selects a weight radio button
		for (int ratings = 0; ratings < weightRadioButton.length; ratings ++){


			if (e.getSource() == weightRadioButton[ratings] )
				setWeightRating(ratings); 




		}


		//if user selects a warranty radio button
		for (int ratings = 0; ratings < warrantyRadioButton.length; ratings ++){


			if (e.getSource() == warrantyRadioButton[ratings] )
				setWarrantyRating(ratings); 




		}


		//if user selects a CPU radio button
		for (int ratings = 0; ratings < CPURadioButton.length; ratings ++){


			if (e.getSource() == CPURadioButton[ratings] )
				setCPURating(ratings); 




		}


		//if user selects a storage radio button
		for (int ratings = 0; ratings < storageRadioButton.length; ratings ++){


			if (e.getSource() == storageRadioButton[ratings] )
				setStorageRating(ratings); 




		}


		//if user selects a graphics radio button
		for (int ratings = 0; ratings < graphicsRadioButton.length; ratings ++){


			if (e.getSource() == graphicsRadioButton[ratings] )
				setGraphicsRating(ratings); 




		}






		//if user selects a value in the combo boxes
		for ( int index = 0 ; index < weightingComboBoxArray.length; index ++) {
			if (e.getSource() == weightingComboBoxArray [index]) 
				user.getWeightings()[index] = weightingComboBoxArray [index].getSelectedIndex();




		}


	}




	/*
	 * This method opens the web browser depending on the index of the laptop; it uses the java 
	 * Desktop class
	 *
	 * author - Isha Raulji
	 */


	
	private void openWebBrowser(int index) {

		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI( (laptopArray[scoreIndex[index]].getHyperlink())));


			} catch (IOException x) {
				x.printStackTrace();


			} catch (URISyntaxException y) {
				y.printStackTrace();
			}
		}
	}



	/*
	 * This method sets the graphics rating for each laptop depending on the user’s choice 
	 * (low, medium, high)
	 *
	 * author - Julia Ren
	 */


	private void setGraphicsRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (low) the weighting on graphics low are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getRatings()[2]<5)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getRatings()[2]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (medium) the weighting on Graphics medium are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getRatings()[2]<5)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getRatings()[2]<2)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=10;










				// If user chooses radio button (high) the weighting on Graphics high are the highest weighted
			}else if(choice==2){
				if(laptopArray[choice].getRatings()[2]<5)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getRatings()[2]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;








			}


		}




	}




	/*
	 * This method sets the storage rating for each laptop depending on the user’s choice 
	 * (low, medium, high)
	 *
	 * author - Julia Ren
	 */


	private void setStorageRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (low) the weighting on storage low are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getRatings()[1]<5)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getRatings()[1]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (medium) the weighting on storage medium are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getRatings()[1]<5)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getRatings()[1]<2)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=10;










				// If user chooses radio button (high) the weighting on storage high are the highest weighted
			}else if(choice==2){
				if(laptopArray[choice].getRatings()[1]<5)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getRatings()[1]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;








			}


		}




	}




	/*
	 * This method sets the CPU rating for each laptop depending on the user’s choice 
	 * (low, medium, high)
	 *
	 * author - Julia Ren
	 */


	private void setCPURating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (low) the weighting on CPU low are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getRatings()[0]<5)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getRatings()[0]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (medium) the weighting on CPU medium are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getRatings()[0]<5)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getRatings()[0]<2)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=10;










				// If user chooses radio button (high) the weighting on CPU high are the highest weighted
			}else if(choice==2){
				if(laptopArray[choice].getRatings()[0]<5)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getRatings()[0]==5)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;




			}

		}




	}




	/*
	 * This method sets the warranty rating for each laptop depending on the user’s choice 
	 * (yes or no)
	 *
	 * author - Julia Ren
	 */


	private void setWarrantyRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (No) the weighting on warranty No are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getWarranty()==0)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (Yes) the weighting on warranty Yes are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getWarranty()<0)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;


			}


		}




	}




	/*
	 * This method sets the weight rating for each laptop depending on the user’s choice 
	 * (>1 kg, 1kg-2kg, <2kg)
	 *
	 * author - Julia Ren
	 */


	private void setWeightRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (< 1kg) the weighting on weight <1kg are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getWeight()<1)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getWeight()<2)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (>1kg <2kg) the weighting on weight >1kg <2kg are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getWeight()<1)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getWeight()<2)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=10;










				// If user chooses radio button (>2kg) the weighting on weight <2kg are the highest weighted
			}else if(choice==2){
				if(laptopArray[choice].getWeight()<1)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getWeight()<2)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;








			}


		}




	}




	/*
	 * This method sets the brand rating for each laptop depending on the user’s choice 
	 * (Lenovo,HP,Acer,Asus,Microsoft,Dell,MSI,Apple)
	 *
	 * author - Julia Ren
	 */


	private void setBrandRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){




			// If user chooses radio button (Lenovo) the weighting on brand Lenovo are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getBrand()=="Lenovo")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (HP) the weighting on brand HP are the highest Branded
			}else if(choice==1){
				if(laptopArray[choice].getBrand()=="HP")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (Acer) the weighting on brand Acer are the highest Branded
			}else if(choice==2){
				if(laptopArray[choice].getBrand()=="Acer")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (Asus) the weighting on brand Asus are the highest Branded
			}else if(choice==3){
				if(laptopArray[choice].getBrand()=="Asus")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (Microsoft) the weighting on brand Microsoft are the highest Branded
			}else if(choice==4){
				if(laptopArray[choice].getBrand()=="Microsoft")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (Dell) the weighting on brand Dell are the highest Branded
			}else if(choice==5){
				if(laptopArray[choice].getBrand()=="Dell")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (MSI) the weighting on brand MSI are the highest Branded
			}else if(choice==6){
				if(laptopArray[choice].getBrand()=="MSI")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




				// If user chooses radio button (Apple) the weighting on brand Apple are the highest Branded
			}else if(choice==7){
				if(laptopArray[choice].getBrand()=="Apple")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;


			}


		}


	}




	/*
	 * This method sets the software rating for each laptop depending on the user’s choice 
	 * (Windows 10, OS X Yosemite, Windows 8.1)
	 *
	 * author - Julia Ren
	 */



	private void setSoftwareRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (low) the weighting on software low are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getRatings()[3]<6)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getRatings()[3]==6)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (medium) the weighting on software medium are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getRatings()[3]<6)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getRatings()[3]==6)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=10;










				// If user chooses radio button (high) the weighting on software high are the highest weighted
			}else if(choice==2){
				if(laptopArray[choice].getRatings()[3]<6)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getRatings()[3]==6)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;




			}

		}


	}




	/*
	 * This method sets the touch screen rating for each laptop depending on the user’s choice 
	 * (yes or no)
	 *
	 * author - Julia Ren
	 */


	private void setTouchRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (No) the weighting on touch screen No are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getSoftware() == "FALSE")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (Yes) the weighting on touch screen Yes are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getSoftware() == "TRUE")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;


			}


		}


	}




	/*
	 * This method sets the convertible rating for each laptop depending on the user’s choice 
	 * (yes or no)
	 *
	 * author - Julia Ren
	 */


	private void setConvertibleRating(int choice) {


		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){






			// If user chooses radio button (No) the weighting on convertible No are the highest weighted
			if(choice==0) {
				if(laptopArray[choice].getSoftware() == "FALSE")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses radio button (Yes) the weighting on convertible Yes are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getSoftware() == "TRUE")
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;


			}
		}


	}




	/*
	 * This method sets the price rating (0, 5 or 10) for each laptop depending on the user’s choice 
	 * (price, medium or high-end)
	 *
	 * author - Parth Patel
	 */


	private void setPriceRating (int choice){








		//counting all 30 laptops
		for(int x = 0; x <= 30; x++){
















			//If the User clicks on the first button
			if(choice==0) {




				// If user chooses first radio button (<500) the weighting on screen sizes <500 are the highest weighted
				if(laptopArray[choice].getPrice()< 500)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getPrice()<1000)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;








				// If user chooses first radio button (>500 <1000) the weighting on screen sizes >500 <1000 are the highest weighted
			} else if(choice==1){
				if(laptopArray[choice].getPrice()< 500 )
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getPrice()<1000)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;
			}








			// If user chooses first radio button (>1000) the weighting on screen sizes <13.3 are the highest weighted
			if(choice==2){
				if(laptopArray[choice].getPrice() < 500)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getPrice()<1000)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;








			}


		}




	}




	/*
	 * This method sets the screen size rating (0, 5 or 10) for each laptop depending on the user’s 
	 * choice (small, medium or large)
	 *
	 *
	 * author - Parth Patel
	 */	 


	private void setScreenSizeRating (int choice){




		for(int x = 0; x <= 30; x++){




			// If user chooses first radio button (<11) the weighting on screen sizes <13.3 are the highest weighted
			if(choice==0)
				if(laptopArray[choice].getScreenSize()<13.3)
					laptopArray[choice].getRatings()[x]=30;
				else if(laptopArray[choice].getScreenSize()>15.6)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=0;




			// If user chooses first radio button (15-17) the weighting on screen sizes <13.3 are the highest weighted
			if(choice==1)
				if(laptopArray[choice].getScreenSize()<13.3)
					laptopArray[choice].getRatings()[x]=10;
				else if(laptopArray[choice].getScreenSize()>15.6)
					laptopArray[choice].getRatings()[x]=30;
				else
					laptopArray[choice].getRatings()[x]=0;




			// If user chooses first radio button (>15) the weighting on screen sizes <13.3 are the highest weighted
			if(choice==2)
				if(laptopArray[choice].getScreenSize()<13.3)
					laptopArray[choice].getRatings()[x]=0;
				else if(laptopArray[choice].getScreenSize()>15.6)
					laptopArray[choice].getRatings()[x]=10;
				else
					laptopArray[choice].getRatings()[x]=30;


		}
	}




	/*
	 * This method creates the report
	 * author - Julia Ren
	 */


	private void createReport(){








		//don't show the user panel anymore
		userPanel.setVisible(false);








		//call the rank laptops method
		rankLaptops();








		//add the report panel to the frame and make it visible
		reportPanel.setVisible(true);








		//"refresh" the visuals
		repaint();
	}




	/*
	 * This method ranks the laptops
	 *
	 * author - Julia Ren
	 */


	private void rankLaptops() {


		//create and place the 3 laptop buttons and text area on the report panel
		for (int x = 0; x < laptopImageButton.length; x++){
			laptopImageButton[x] = new JButton();
			
			laptopImageButton[x].addActionListener(this);
			laptopImageButton[x].setLayout(null);
			laptopImageButton[x].setBounds(50+x*450, 15, 300, 300);
			reportPanel.add(laptopImageButton[x]);
			

			JTextArea laptopTextArea = new JTextArea();
			laptopTextArea.setLayout(null);
			laptopTextArea.setBounds(25+x*450, 325, 400, 325);
			laptopTextArea.setText(laptopArray[x].toString());
			reportPanel.add(laptopTextArea);

		}

		//variables to store top 3 scores and initialize it
		int highest = 0;
		int secondHighest = 0;
		int thirdHighest = 0;

		//loop to find top 3 scores
		for(Laptop currentLaptop:laptopArray){


			int index = 0;
			index ++;



			currentLaptop.setScore(wdm(null, null));


			if (currentLaptop.getScore() > thirdHighest){
				if (currentLaptop.getScore() > secondHighest){
					if (currentLaptop.getScore() > highest)
						index = highest;
					index = secondHighest;
				}
				index = thirdHighest;
			}

				
				laptopImageButton[index].setIcon(new ImageIcon(new ImageIcon("./images/laptop" + 
						scoreIndex[index] + ".jpg").getImage().getScaledInstance(450, 400, 0)));


		}



		//set score index to the top 3 scores
		scoreIndex [0] = highest;
		scoreIndex [1] = secondHighest;
		scoreIndex [2] = thirdHighest;




	}




	/*
	 * This method returns the total score by using the concept of a Weighted Decision Matrix
	 *
	 * author - Isha Raulji
	 */


	private int wdm(Laptop currentLaptop, User user) {








		//Local Variables
		int totalScore = 0;
		int weightings = 0 ; 
		int ratings = 0 ;








		for(weightings = 0; weightings < 8; weightings ++) {




			totalScore = weightings * ratings;








		}








		return totalScore;




	}






}

