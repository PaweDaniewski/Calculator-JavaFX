package application;

import calcbasic.CalcModel;
import calcbasic.IncorrectInputException;

/**
 * Controller class, gives information to calculator and receives answers .
 * Modified by Pawel Daniewski.
 * 
 * @author Professor David Cohen
 *
 */

public class Controller {
  CalcModel calc = new CalcModel();
  ViewInterface myView = null;
  OpType type = OpType.INFIX; // by default GUI view evaluates infix

  /**
   * This method evaluates mathematical expression based on user preferences
   * (infix/postfix) and returns float value or Invalid exception error to users chosen view.
   */

  private void calculateAction() {

    float a;
    try {
      if (type.equals(OpType.INFIX)) { //only difference is boolean value.
        a = calc.evaluate(myView.getQuestion(), true);        
        myView.setAnswer(String.valueOf(a));
      } else if (type.equals(OpType.POSTFIX)) {
        a = calc.evaluate(myView.getQuestion(), false);
        myView.setAnswer(String.valueOf(a));
      }

    } catch (IncorrectInputException e) { //catches any caught abnormalities
      myView.setAnswer("Invalid Equation! Be sure to make spaces after each number/symbol.");
    }

  }

  private void changeType(OpType t) {
    type = t; //changes according to pressed button
    myView.setAnswer("Changed to " + t);
  }
  
  /**
   * Constructor for Controller class.
   * @param v ViewInteface
   */

  public Controller(ViewInterface v) { // constructor for class
    myView = v;
    v.addCalcObserver(this::calculateAction);
    v.addTypeObserver(this::changeType);
  }

}
