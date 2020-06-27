package calcbasic;

/**
 * This is the class that implements method of calculating string expression
 * that is already in reverse polish notation notation.
 * 
 * @author Pawel Daniewski
 *
 */

public class RevPolishCalc implements Calculator {

  private NumStack stack;

  /**
   * Constructor for RevPolishCalc, takes NumStack.
   */

  public RevPolishCalc() {
    stack = new NumStack();

  }

  /**
   * This is a private method that evaluates if string is s number.
   * 
   * @param strNum string that is tested to be number.
   *          
   * @return boolean value.
   */

  private boolean isNumeric(String strNum) {
    boolean isItNum = true;
    try {
      @SuppressWarnings("unused")
      float num = Float.parseFloat(strNum); //tries to convert string to float
    } catch (NumberFormatException e) { //catches exception if can't be converted
      isItNum = false;
    }
    if (isItNum) { 
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method that calculates string expression of equation in reverse polish
   * notation notation.
   * 
   * @return float value corresponding to equation solution.
   * @throws IncorrectInputException Custom exception.
   *           
   */

  @Override
  public float evaluate(String what) throws IncorrectInputException {

    stack = new NumStack();
    float value = 0;
    float tempVal1 = 0;
    float tempVal2 = 0;
    try {
      String[] splited = what.split(" "); // splits equation into an array of strings
      if (splited.length == 1 && isNumeric(splited[0])) { // Checks if the input is only one number
        value += Float.parseFloat(splited[0]);
        return value;
      }
      for (int i = 0; i < splited.length; i++) { // iterates over an array
        String temp = splited[i];

        if (isNumeric(temp)) { // if it's numeric pushes on stack
          stack.push(Float.parseFloat(temp));
        } else {
          tempVal1 = stack.peek(); // peeks first number on stack
          stack.pop();
          tempVal2 = stack.peek();// after pop, peeks second number
          stack.pop();
          if (temp.equals("+")) { // depending on symbol it will perform operation 
            value = tempVal1 + tempVal2;
          } else if (temp.equals("-")) {
            value = tempVal2 - tempVal1;
          } else if (temp.equals("/")) {
            value = tempVal2 / tempVal1;
          } else if (temp.equals("*")) {
            value = tempVal2 * tempVal1;
          } else {
            throw new IncorrectInputException();
          }

          stack.push(value);// pushes result of equation on stack
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IncorrectInputException();
    }

    return value;

  }

}
