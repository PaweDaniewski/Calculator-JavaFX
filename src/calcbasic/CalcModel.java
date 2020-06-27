package calcbasic;

/**
 * This is a Model class for calculator, it's purpose is to interact as medium.
 * 
 * 
 * @author GS63
 *
 */

public class CalcModel {

  Calculator revPolish;
  Calculator standard;

  /**
   * constructor for CalcModel class. Initiates revPolish calculator and standard
   * calculator.
   */

  public CalcModel() {
    revPolish = new RevPolishCalc();
    standard = new StandardCalc();
  }

  /**
   * A method that evaluates a string expression of equation and returns the float
   * value of this expression result.
   * 
   * @param what string that represents equation.
   * @param infix boolean value that if true makes evaluation based on infix
   *          expression.
   *          
   * @return float value of equation
   * @throws IncorrectInputException
   *           custom exception.
   */

  public float evaluate(String what, boolean infix) throws IncorrectInputException {

    if (infix == true) { //infix calculator is associated with true values thru 
      //the project
      return standard.evaluate(what);
    } else {
      return revPolish.evaluate(what);
    }
  }

}
