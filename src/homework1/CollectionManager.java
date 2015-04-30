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

import java.util.InputMismatchException;
import java.util.Scanner;

public class CollectionManager {
	/**
	 * The main method runs a menu driven application which first creates two empty CardCollections 
	 * (referred to by the user as A and B), and then prompts the user for a command selecting the operation. 
	 * Once an operation is selected, the program prompts for any additional information required to perform 
	 * the operation, and then actually performs the operation. The operations, their action letter, and additional 
	 * information required are listed below.
	 * <br><br>
         Add Card:          A  <br>
     		Construct and add the card to the indicated collection at the indicated position)<br><br>
         Get Card:          G  <br>
     		Print out the name, manufacturer, year, and price of the card at the specified position in the indicated collection<br><br>
         Remove Card:       R  <br>
     		Remove the card at the specified position in the indicated collection) <br><br>
         Print All Cards:   P <br>
     		Print the list of all cards in each collection<br><br>
         Look for Card:     L  <br>
     		Construct the card from the input, and print out whether or not it exists in either collection. You must use the Card's equals() method for comparison.<br><br>
         Size:              S <br>
     		Print the number of cards in each collection <br><br>
         Value:             V <br>
     		Print the total value of each collection<br><br>
         Update name:              N  <br>
     		Update the name of the card in the indicated position in the indicated collection <br><br>
         Update price:      E  <br>
   			Update the price of the card in the indicated position in the indicated collection <br><br>
         Copy card:         C  <br>
     		Copy the card at the specified position in <From collection> to the end of <To collection>, using the cards clone() method. Note: <From collection> and <To collection> may be the same<br><br>
         Trade:             T  <br>
     		Exchange the card at position A in collection A with the card at position B in collection B<br><br>
         Quit:              Q <br>
     		Terminate the program gracefully <br><br>
     		
	 * @param args
	 */
	public static void main(String[] args) {
		CardCollection A = new CardCollection();
		CardCollection B = new CardCollection();
		String menu = "\nMain menu:\n\nA) Add Card\nC) Copy\nE) Update price\n"
				+ "G) Get Card\nL) Locate Card\nN) Update name\nP) Print All "
				+ "Cards\nR) Remove Card\nS) Size\nT) Trade\nV) Value of "
				+ "collections\nQ) Quit\n\nSelect an operation: ";
		Scanner input;
		String choice;
		char letter;
		String collection, name, manu;
		int year, sizeX, sizeY, position;
		double price;
		do {
			System.out.print(menu);
			input = new Scanner(System.in);
		    choice = input.next();
		    letter = choice.charAt(0);
		    switch(letter) {
		    case('A'):
		    case('a'):
		    	try {
		    		System.out.print("\nEnter the collection: ");
			    	collection = input.next();
			    	System.out.print("Enter the name: ");
			    	input.nextLine();
			    	name = input.nextLine();
			    	System.out.print("Enter the manufacturer: ");
			    	manu = input.nextLine();
			    	System.out.print("Enter the year: ");
			    	year = input.nextInt();
			    	System.out.print("Enter the size: ");
			    	sizeX = input.nextInt();
			    	sizeY = input.nextInt();
			    	System.out.print("Enter the price: ");
			    	price = input.nextDouble();
			    	System.out.print("Enter the position: ");
			    	position = input.nextInt();
		    	}catch(InputMismatchException e) {
		    		e.printStackTrace();
		    		break;
		    	}
	    		BaseballCard newCard = new BaseballCard(name, manu, year, price, sizeX, sizeY);
		    	if (collection.equalsIgnoreCase("A")) {
		    		try {
						A.addCard(newCard, position);
						System.out.printf("\nAdded %s, %s %d, %dx%d, $%.2f at "
								+ "position %d of collection %s\n", name, manu, 
								year, sizeX, sizeY, price, position, collection);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					} catch (FullCollectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
		    	}
		    	else {
		    		try {
						B.addCard(newCard, position);
						System.out.printf("Added %s, %s %d, %dx%d, $%.2f at "
								+ "position %d of collection %s\n", name, manu, 
								year, sizeX, sizeY, price, position, collection);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					} catch (FullCollectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
		    	}
		    	break;
		    case('G'):
		    case('g'):
		    	System.out.print("\nEnter the collection: ");
	    		collection = input.next();
	    		System.out.print("Enter the position: ");
		    	position = input.nextInt();
		    	BaseballCard card;
		    	if (collection.equalsIgnoreCase("A")) {
		    		card = A.getCard(position);
		    		System.out.println("\nCollection A:\n");
		    	}
		    	else {
		    		card = B.getCard(position);
		    		System.out.println("\nCollection B:\n");
		    	}
		    	
		    	String table = String.format("%-2s%-21s%-14s%-6s%-10s%s", "#", "Name", "Manufacturer", "Year", "Price", "Size") + "\n";
	    		table += String.format("%-2s%-21s%-14s%-6s%-10s%s", "_", "____", "____________", "____", "_____", "____") + "\n";
	    		String s = String.format("%-2d%-21s%-14s%-6d%-10.2f%d%s%d\n", position, card.getName(), card.getManu(), 
    					card.getYear(), card.getPrice(), card.getSizeX(), "x", card.getSizeY());
	    		table += s;
	    		System.out.println(table);
	    		break;
		    case('R'):
		    case('r'):
		    	System.out.print("\nEnter the collection to remove from: ");
	    		collection = input.next();
	    		System.out.print("Enter the position to remove: ");
	    		position = input.nextInt();
	    		BaseballCard removed;
	    		if (collection.equalsIgnoreCase("A")) {
	    			removed = A.getCard(position);
	    			A.removeCard(position);
	    		}
	    		else {
	    			removed = B.getCard(position);
	    			B.removeCard(position);
	    		}
	    		System.out.printf("\nRemoved %s, %s %d, %dx%d, $%.2f from collection %s\n", removed.getName(), removed.getManu(), 
    					removed.getYear(), removed.getSizeX(), removed.getSizeY(), removed.getPrice(), collection);
	    		break;
		    case('P'):
		    case('p'):
		    	System.out.println("\nCollection A:\n");
		    	System.out.println(A);
		    	System.out.println("\nCollection B:\n");
		    	System.out.println(B);
		    	break;
		    case('L'):
		    case('l'):
			    System.out.print("Enter the name: ");
			    input.nextLine();
			    name = input.nextLine();
			    System.out.print("Enter the manufacturer: ");
			    manu = input.nextLine();
			    System.out.print("Enter the year: ");
			    year = input.nextInt();
			    System.out.print("Enter the size: ");
			    sizeX = input.nextInt();
			    sizeY = input.nextInt();
			    System.out.print("Enter the price: ");
			    price = input.nextDouble();
			    card = new BaseballCard(name, manu, year, price, sizeX, sizeY);
			    boolean existsA = false, existsB = false;
			    for (int i = 1; i <= A.size(); i++) {
		    		if (card.equals(A.getCard(i)))
		    			existsA = true;
		    	}
			    for (int i = 1; i <= B.size(); i++) {
		    		if (card.equals(B.getCard(i)))
		    			existsB = true;
		    	}
			    String isInA = existsA ? "is " : "is not ";
			    String isInB = existsB ? "is " : "is not ";
			    System.out.println("The card " + isInA + "in collection A. The card " + isInB + "in collection B.");
		    	break;
		    case('S'):
		    case('s'):
		    	String aCards = A.size()!=1 ? "cards":"card";;
		    	System.out.print("\nCollection A has " + A.size() + " " + aCards + ". ");
		    	String bCards = B.size()!=1 ? "cards":"card";;
		    	System.out.println("Collection B has " + B.size() + " " + bCards + ".");
		    	break;
		    case('V'):
		    case('v'):
		    	double aTotal = 0, bTotal = 0;
		    	for (int i = 1; i <= A.size(); i++) {
		    		card = A.getCard(i);
		    		aTotal += card.getPrice();
		    	}
		    	for (int i = 1; i <= B.size(); i++) {
		    		card = B.getCard(i);
		    		bTotal += card.getPrice();
		    	}
		    	System.out.printf("\nThe total value of Collection A is $%.2f. The total value of Collection B is $%.2f.\n", aTotal, bTotal);
		    	break;
		    case('N'):
		    case('n'):
		    	System.out.print("\nEnter the collection: ");
	    		collection = input.next();
	    		System.out.print("Enter the position: ");
		    	position = input.nextInt();
		    	System.out.print("Enter the new name: ");
		    	input.nextLine();
		    	String newName = input.nextLine();
		    	if (collection.equalsIgnoreCase("A")) {
		    		name = A.getCard(position).getName();
		    		A.getCard(position).setName(newName);
		    	}
		    	else {
		    		name = B.getCard(position).getName();
		    		B.getCard(position).setName(newName);
		    	}
		    	System.out.printf("Changed name of collection %s position %d from \"%s\" to \"%s\"", collection, position, name, newName);
		    	break;
		    case('E'):
		    case('e'):
		    	System.out.print("\nEnter the collection: ");
	    		collection = input.next();
	    		System.out.print("Enter the position: ");
		    	position = input.nextInt();
		    	System.out.print("Enter the new price: ");
		    	double newPrice = input.nextDouble();
		    	if (collection.equalsIgnoreCase("A")) {
		    		price = A.getCard(position).getPrice();
		    	}
		    	else {
		    		price = B.getCard(position).getPrice();
		    	}
		    	System.out.printf("Changed price of collection %s position %d from $%.2f to $%.2f", collection, position, price, newPrice);
		    	break;
		    case('C'):
		    case('c'):
		    	System.out.print("\nEnter the collection to copy from: ");
	    		collection = input.next();
	    		System.out.print("Enter the position of the card to copy: ");
		    	position = input.nextInt();
		    	System.out.print("\nEnter the collection to copy to: ");
	    		String collection2 = input.next();
	    		BaseballCard copy;
		    	if (collection.equalsIgnoreCase("A")) {
		    		card = A.getCard(position);
		    	}
		    	else {
		    		card = B.getCard(position);
		    	}
		    	
	    		copy = (BaseballCard) card.clone();
	    		
		    	if (collection2.equalsIgnoreCase("A")) {
		    		try {
						A.addCard(copy);
			    		System.out.printf("Copied %s, %s %d, %dx%d, $%.2f into "
								+ "position %d of collection %s\n", card.getName(), card.getManu(), 
								card.getYear(), card.getSizeX(), card.getSizeY(), card.getPrice(), A.size(), collection2);
					} catch (IllegalArgumentException | FullCollectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
		    	}
		    	else {
		    		try {
						B.addCard(copy);
			    		System.out.printf("Copied %s, %s %d, %dx%d, $%.2f into "
								+ "position %d of collection %s\n", card.getName(), card.getManu(), 
								card.getYear(), card.getSizeX(), card.getSizeY(), card.getPrice(), B.size(), collection2);
					} catch (IllegalArgumentException | FullCollectionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
		    	}
		    	break;
		    case('T'):
		    case('t'):
		    	System.out.print("Enter the position of the card to trade from collection A: ");
		    	position = input.nextInt();
		    	System.out.print("Enter the position of the card to trade from collection B: ");
		    	int position2 = input.nextInt();
		    	BaseballCard traded = A.getCard(position);
	    		A.removeCard(position);
	    		BaseballCard traded2 = B.getCard(position2);
	    		B.removeCard(position2);
	    		try {
					A.addCard(traded2, position);
				} catch (IllegalArgumentException | FullCollectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
	    		try {
					B.addCard(traded, position2);
				} catch (IllegalArgumentException | FullCollectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
	    		System.out.printf("Traded %s, %s %d, %dx%d, $%.2f for %s, %s %d, %dx%d, $%.2f\n", traded2.getName(), traded2.getManu(), 
						traded2.getYear(), traded2.getSizeX(), traded2.getSizeY(), traded2.getPrice(), traded.getName(), traded.getManu(), 
						traded.getYear(), traded.getSizeX(), traded.getSizeY(), traded.getPrice());
			    break;
		    case('Q'):
		    case('q'):
		    	System.out.println("Quitting.");
		    	System.exit(0);
			}
		}while(letter!='Q' || letter!='q');

	}

}
