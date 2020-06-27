package calcbasic;
/**
 * Custom exception class for calculator.
 * @author Pawel Daniewski
 *
 */

public class IncorrectInputException extends Exception {
 
  private static final long serialVersionUID = 1L; //called by java as necesarry 

  /**
   * Custom exception, it is invoked thru out the code when it catches other
   * exceptions (ex. ArrayOutOfBoundsExcepttion) and different issues, used mostly
   * in two types of calculator.
   */
  public IncorrectInputException() {
    super("Incorrect input");
  }
  
  /**
   * Method that returns custom exception message. 
   */

  public String getMessage() {
    return super.getMessage();
  }

}
