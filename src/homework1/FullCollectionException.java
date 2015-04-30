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
 * The FullCollectionExcepiton class is thrown to indicate that there is no more room inside of the CardCollection 
 * to store the new BaseballCard object.
 */
public class FullCollectionException extends Exception {
	  public FullCollectionException(String message) {
		    super(message);
		  }

}
