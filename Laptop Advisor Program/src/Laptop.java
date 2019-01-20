import java.util.Arrays;

public class Laptop {
	
	private String brand;
	private String model;
	private double price;
	private double screenSize;
	private String display;
	private boolean touch;
	private boolean convertible;
	private String CPU;
	private String storage;	
	private double battery;
	private String graphicsCard;
	private String audio;
	private String software;
	private String colour;
	private double weight;
	private int warranty;
	private String hyperlink;
	
	
	private int[] ratings = new int[11];
	
	/* IN ORDER FROM OBJECTIVE TO SUBJECTIVE
	 * [0]- CPU
	 * [1]- Storage
	 * [2]- Graphics
	 * [3]- Software
	 * [4]- Brand
	 * [5]- Price
	 * [6]- Screen Size
	 * [7]- Touch
	 * [8]- Convertible
	 * [9]- Weight
	 * [10]- Warranty
	 * 
	 */
	private int score;




	//Getters and Setters


	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public double getScreenSize() {
		return screenSize;
	}




	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}




	public String getDisplay() {
		return display;
	}




	public void setDisplay(String display) {
		this.display = display;
	}
	
	public boolean isTouch() {
		return touch;
	}




	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	public boolean isConvertible() {
		return convertible;
	}




	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}




	public String getCPU() {
		return CPU;
	}




	public void setCPU(String CPU) {
		this.CPU = CPU;
	}




	public String getStorage() {
		return storage;
	}




	public void setStorage(String storage) {
		this.storage = storage;
	}




	public double getBattery() {
		return battery;
	}




	public void setBattery(double battery) {
		this.battery = battery;
	}




	public String getGraphicsCard() {
		return graphicsCard;
	}




	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}




	public String getAudio() {
		return audio;
	}




	public void setAudio(String audio) {
		this.audio = audio;
	}




	public String getSoftware() {
		return software;
	}




	public void setSoftware(String software) {
		this.software = software;
	}




	public String getColour() {
		return colour;
	}




	public void setColour(String colour) {
		this.colour = colour;
	}




	public double getWeight() {
		return weight;
	}




	public void setWeight(double weight) {
		this.weight = weight;
	}




	public int getWarranty() {
		return warranty;
	}




	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}




	public String getHyperlink() {
		return hyperlink;
	}




	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}




	public int[] getRatings() {
		return ratings;
	}




	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	@Override
	public String toString() {
		return "Brand: " + brand + "\n"+ "Model:" + model + "\n"+  "Price:"
				+ price + "\n"+ "Screen Size:" + screenSize + "\n"+ "Display:" + display
				+ "\n"+ "Touch Screen" + touch + "\n"+ "Convertible:" + convertible
				+ "\n"+ "CPU:" + CPU + "\n"+ "Storage:" + storage + "\n"+ "Battery:"
				+ battery + "\n"+ "Graphics Card:" + graphicsCard + "\n"+ "Audio:"
				+ audio + "\n"+ "Software:" + software + "\n"+ "Colour:" + colour
				+ "\n"+ "Weight:" + weight + "\n"+ "Warranty:" + warranty
				+ "\n"+ "Hyperlink:" + hyperlink + "\n"+ "Ratings:"
				+ Arrays.toString(ratings) + "Score:" + score + "]";
	}
	







}
