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
 * The CardCollection class implements an abstract data type for a list of baseball cards supporting some common operations on such lists.
 */
public class CardCollection {
	private BaseballCard[] cards;
	private int size;
	private static final int MAX_CARDS = 100;
	
	/**
	 * Construct an instance of the CardCollection class with no BaseballCard objects in it.
	 * 
	 * <dt><b>Postcondition:</b><dd> This CardCollection has been initialized to an empty list of BaseballCards.
	 */
	public CardCollection(){
		cards = new BaseballCard[MAX_CARDS+1];
		size = 0;
	}
	
	/**
	 * Determines the number of items currently in this collection.
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated.
	 * 
	 * @return The number of BaseballCards in this CardCollection.
	 */
	public int size() {
		return size;
	}
	/**
	 * Adds a new BaseballCard object to a specified position
	 * 
	 * @param newCard the new BaseballCard object to add to this collection 
	 * @param position the position in this CardCollection where newCard will be inserted
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated 
	 * and 1 < position < items_currently_in_list + 1. The number of BaseballCard objects 
	 * in this Menu is less than MAX_CARDS. 
	 * 
	 * <dt><b>Postcondition:</b><dd> The new BaseballCard is now stored at the desired position 
	 * in the CardCollection. All cards that were originally in positions greater than or equal to 
	 * position are moved back one position.
	 * 
	 * @throws IllegalArgumentException Indicates that position is not within the valid range.
	 * @throws FullCollectionException Indicates that there is no more room inside of the CardCollection 
	 * to store the new BaseballCard object.
	 */
	public void addCard(BaseballCard newCard, int position) throws IllegalArgumentException, FullCollectionException{
		if (position < 1 || position > size + 1)
			throw new IllegalArgumentException("position must be >= 1 and <= the # of items currently in the collection + 1");
		if (size+1>MAX_CARDS)
			throw new FullCollectionException("there is no more room inside of the CardCollection to store the new BaseballCard object");
		if (cards[position] == null)
			cards[position] = newCard;
		else {
			for (int i = size; i >= position; i--) {
				cards[i + 1] = cards[i];
			}
			cards[position] = newCard;
		}
		size++;
	}
	/**
	 * Adds a new BaseballCard object to the end of the list
	 * 
	 * @param newCard the new BaseballCard object to add to this collection 
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated. The number of BaseballCard objects 
	 * in this Menu is less than MAX_CARDS. 
	 * 
	 * <dt><b>Postcondition:</b><dd> The new BaseballCard is now stored at the end of the CardCollection. 
	 * 
	 * @throws IllegalArgumentException Indicates that position is not within the valid range.
	 * @throws FullCollectionException Indicates that there is no more room inside of the CardCollection 
	 * to store the new BaseballCard object.
	 */
	public void addCard(BaseballCard newCard) throws IllegalArgumentException, FullCollectionException {
		addCard(newCard, size+1);
	}
	
	/**
	 * Removes the BaseballCard object at the specified position in the CardCollection
	 * 
	 * @param position the position of the card in this CardCollection that will be removed
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated 
	 * and 1 < position < items_currently_in_list
	 * 
	 * <dt><b>Postcondition:</b><dd> The card at the desired position in the collection has been removed. 
	 * All cards that were originally in positions greater than or equal to position are moved forward one position. 
	 * 
	 * @throws IllegalArgumentException Indicates that position is not within the valid range.
	 */
	public void removeCard(int position) throws IllegalArgumentException {
		if (position < 1 || position > size)
			throw new IllegalArgumentException("position must be >= 1 and <= the # of items currently in the collection");
		for (int i = position; i < size; i++) {
			cards[i] = cards[i+1];
		}
		size--;
	}
	
	/**
	 * Get the BaseballCard at the given position in this CardCollection object.
	 * 
	 * @param position the position of the card in this CardCollection that will be received
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated 
	 * and 1 < position < items_currently_in_list
	 * 
	 * @return The card at the specified position in this Menu object.
	 * @throws IllegalArgumentException Indicates that position is not within the valid range.
	 */
	public BaseballCard getCard(int position) throws IllegalArgumentException{
		if (position < 1 || position > size)
			throw new IllegalArgumentException("position must be >= 1 and <= the # of items currently in the collection");
		return cards[position];
	}
	
	/**
	 * Exchange a card from this collection for a card from another collection.
	 * 
	 * @param other 	the CardCollection we will be trading with
	 * @param myPosition 	the position within this collection of the card to trade
	 * @param theirPosition 	the position within the other collection of the card to trade
	 * 
	 * <dt><b>Precondition:</b><dd> Both CardCollection objects have been instantiated 
	 * and 1 < myPosition < items_currently_in_this_list and 1 < theirPosition < items_currently_in_other_list.
	 * 
	 * @throws IllegalArgumentException Indicates that either position is not within the valid range.
	 */
	public void trade(CardCollection other, int myPosition, int theirPosition) throws IllegalArgumentException, FullCollectionException{
		if (myPosition < 1 || myPosition > size || theirPosition < 1 || theirPosition > other.size())
			throw new IllegalArgumentException("both positions must be >= 1 and <= the # of items currently in that respective collection");
		BaseballCard temp = new BaseballCard();
		temp = getCard(myPosition);
		removeCard(myPosition);
		addCard(other.getCard(theirPosition), myPosition);
		//cards[myPosition] = other.getCard(theirPosition);
		other.removeCard(theirPosition);
		other.addCard(temp, theirPosition);	
	}
	
	/**
	 * Check whether this collection contains the given card
	 * 
	 * @param card 	the BaseballCard we are looking for
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection and the BaseballCard object have both been instantiated
	 * 
	 * @return True, if this CardCollection contains the card, false otherwise.
	 */
	public boolean exists(BaseballCard card) {
		/*int index = indexOf(card);
		return (index != -1);*/
		for (int i = 1; i <= size; i++) {
			if (cards[i].equals(card))
				return true;
		}
		return false;
	}
	/*private int indexOf(BaseballCard card) {
		for (int i = 1; i <= size; i++) {
			if (cards[i].equals(card))
				return i;
		}
		return -1;
	}*/

	/**
	 * Prints a neatly formatted table of each item in the collection on its own line with its position number 
	 * as shown in the sample output.
	 * 
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated 
	 * 
	 * <dt><b>Postcondition:</b><dd> A neatly formatted table of each card in the collection on its own line with its 
	 * position number has been displayed to the user. 
	 * 
	 */
	public void printAllCards() {
		System.out.println(toString());
	}
	
	/**
	 * Gets the String representation of this CardCollection object, which is a neatly formatted table 
	 * of each BaseballCard in the CardCollection on its own line with its position number as shown in the sample output.
	 * 
	 * @return The String representation of this CardCollection object.
	 */
	public String toString() {
		String table = "";
		table += String.format("%-2s%-21s%-14s%-6s%-10s%s", "#", "Name", "Manufacturer", "Year", "Price", "Size") + "\n";
		table += String.format("%-2s%-21s%-14s%-6s%-10s%s", "_", "____", "____________", "____", "_____", "____") + "\n";
		for (int i = 1; i <= size; i++) {
			BaseballCard card = cards[i];
			String s = String.format("%-2d%-21s%-14s%-6d%-10.2f%d%s%d\n", i, card.getName(), card.getManu(), 
					card.getYear(), card.getPrice(), card.getSizeX(), "x", card.getSizeY());
			table += s;
		}
		return table;
	}
}
