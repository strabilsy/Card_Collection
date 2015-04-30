/**
 * Samier Trabilsy
 * Student ID: 109839226
 * Homework #1
 * Thursday: R04
 * Gustavo Poscidonio
 * Mahsa Torkaman
 * @author Samier
 */
package homework1;

/**
 * The BaseballCard class represents a BaseballCard object with contains the players name (String), 
 * the cards manufacturer (String), and year (int), price (double), and image size (int[], 
 * an integer array of size 2, representing the size along the x and y axes respectively).
 */
public class BaseballCard {
	private String name;
	private String manu;
	private int year;
	private double price = 0;
	private int[] imgSize = new int[2];
	
	/**
	 * Creates a new BaseballCard with default (empty) values
	 */
	public BaseballCard() {}
	
	/**
	 * Creates a new BaseballCard with specified values
	 * 
	 * @param name The player's name
	 * @param manu The card's manufacturer
	 * @param year The year
	 * @param price The price
	 * @param sizeX The image size along the x axis
	 * @param sizeY The image size along the y axis
	 */
	public BaseballCard(String name, String manu, int year, double price, int sizeX, int sizeY) {
		this.name = name;
		this.manu = manu;
		this.year = year;
		this.price = price;
		imgSize[0] = sizeX;
		imgSize[1] = sizeY;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManu() {
		return manu;
	}
	public void setManu(String manu) {
		this.manu = manu;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 * 
	 * <dt><b>Precondition:</b><dd> The price must be positive
	 * 
	 * @throws IllegalArgumentException if the new price is less than 0
	 */
	public void setPrice(double price) throws IllegalArgumentException {
		if (price < 0)
			throw new IllegalArgumentException("Price must be positive");
		this.price = price;
	}
	public int[] getImgSize() {
		return imgSize;
	}
	public void setImgSize(int[] imgSize) {
		this.imgSize = imgSize;
	}
	public int getSizeX() {
		return imgSize[0];
	}
	public int getSizeY() {
		return imgSize[1];
	}
	
	/**
	 * Creates a copy of this BaseballCard. Subsequent changes to the copy will 
	 * not affect the original, nor vice versa. Note that the return value must be typecast 
	 * to a BaseballCard before it can be used.
	 * 
	 * @return a copy of this BaseballCard
	 */
	public Object clone() {
		BaseballCard cloned = new BaseballCard(name, manu, year, price, imgSize[0], imgSize[1]);
		return cloned;	
	}
	/**
	 * Compares this BaseballCard to the specified Object. A return value of true indicates 
	 * that obj refers to a BaseballCard object with the same attributes as this BaseballCard. 
	 * Otherwise, the return value is false.
	 * 
	 * @param obj the object to compare with
	 * 
	 * @return true if this BaseballCard is equal to obj; false otherwise.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof BaseballCard) {
			BaseballCard toCompare = (BaseballCard) obj;
			return toCompare.getName().matches(name) && toCompare.getManu().matches(manu) 
					&& toCompare.getYear() == year && toCompare.getPrice() == price 
					&& toCompare.getSizeX() == imgSize[0] && toCompare.getSizeY() == imgSize[1];
		}
		else
			return false;
	}
	
}
