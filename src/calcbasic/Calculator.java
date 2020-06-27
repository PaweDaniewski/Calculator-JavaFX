package calcbasic;

/**
 * Interface for StandardCalc and RevPolishCalculator.
 * 
 * @author Pawel Daniewski
 *
 */

public interface Calculator {

  /**
   * This method is overridden by evaluate methods of both calculators.
   * @param what  Mathematical equation for evaluation in string format.
   *          
   * @return float value, depends on type of calculator.
   * @throws IncorrectInputException
   *           custom exception.
   */

  public float evaluate(String what) throws IncorrectInputException;

}
