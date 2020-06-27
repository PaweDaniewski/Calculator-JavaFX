package calcbasic;

import java.io.IOException;

/**
 * Class that is solving string representation of basic mathematical equation by
 * converting it from infix to postfix notation and then evaluating it.
 * 
 * @author Pawel Daniewski
 *
 */

public class StandardCalc implements Calculator {

  private OpStack values;
  private RevPolishCalc rpCalc;

  /**
   * Constructor for standard calculator. Initiates new stack of symbols and
   * reverse polish notation calculator.
   */

  public StandardCalc() {
    values = new OpStack();
    rpCalc = new RevPolishCalc();

  }

  /**
   * Private method that evaluates if the string is a number.
   * 
   * @param strNum string is evaluated to being number.
   *          
   * @return boolean indicating if string is a number.
   */

  private boolean isNumeric(String strNum) {
    boolean isItNum = true;
    try {
      @SuppressWarnings("unused")
      float num = Float.parseFloat(strNum); // tries to convert string to float
    } catch (NumberFormatException e) {
      isItNum = false;
    }

    if (isItNum) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Private method that evaluates if given string is a symbol.
   * 
   * @param strSym string is evaluated to being symbol.
   *          
   * @return boolean indicating if string is a symbol.
   * @throws IncorrectInputException
   *           custom exception.
   */

  private boolean isSymbol(String strSym) throws IncorrectInputException {
    if (strSym.equals("+")) {
      return true;
    } else if (strSym.equals("-")) {
      return true;
    } else if (strSym.equals("/")) {
      return true;
    } else if (strSym.equals("*")) {
      return true;
    } else if (strSym.equals(")")) {
      return true;
    } else if (strSym.equals("(")) {
      return true;
    }
    throw new IncorrectInputException();
  }

  /**
   * Private method that evaluates if given string is a symbol, but if string is
   * not a stack it returns false and does not throws exception. Made to fix
   * calculator issue.
   * 
   * @param strSym string evaluated for being symbol
   *          
   * @return boolean value.
   * @throws IncorrectInputException
   *           custom exception.
   */

  private boolean isSymbolNotThrow(String strSym) throws IncorrectInputException {
    if (strSym.equals("+")) {
      return true;
    } else if (strSym.equals("-")) {
      return true;
    } else if (strSym.equals("/")) {
      return true;
    } else if (strSym.equals("*")) {
      return true;
    } else if (strSym.equals(")")) {
      return true;
    } else if (strSym.equals("(")) {
      return true;
    }
    return false;
  }

  /**
   * Method that indicates is the string is opening bracket.
   * 
   * @param strOp string to be evaluated.
   *         
   * @return boolean indicating if string is a bracket.
   */

  private boolean isOpBracket(String strOp) {
    if (strOp.equals("(")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method that indicates is the string is closing bracket.
   * 
   * @param strClo string to be evaluated.
   *         
   * @return boolean indicating if string is a bracket.
   */

  private boolean isCloBracket(String strClo) {
    if (strClo.equals(")")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method that return Symbol that corresponds to string representation of that
   * symbol. Used to push new symbols to stack of symbols.
   * 
   * @param strSym string to be evaluated.
   *          
   * @return Symbol corresponding to string.
   */

  private Symbol symbolTransfor(String strSym) throws IncorrectInputException {

    if (strSym.equals("+")) {
      return Symbol.PLUS;
    } else if (strSym.equals("-")) {
      return Symbol.MINUS;
    } else if (strSym.equals("/")) {
      return Symbol.DIVIDE;
    } else if (strSym.equals("*")) {
      return Symbol.TIMES;
    } else if (strSym.equals("(")) {
      return Symbol.LEFTBRACKET;
    } else if (strSym.equals(")")) {
      return Symbol.RIGHTBRACKET;

    } else {
      throw new IncorrectInputException();

    }

  }

  /**
   * Method created for assigning different symbols values corresponding to their
   * order in mathematical equation.
   * 
   * @param strSym string that represents symbol.
   *          
   * @return float value indicating mathematical order of symbol.
   */

  private float symbolVal(String strSym) {
    if (strSym.equals("+")) {
      return 1;
    } else if (strSym.equals("-")) {
      return 1;
    } else if (strSym.equals("/")) {
      return 2;
    } else if (strSym.equals("*")) {
      return 2;
    } else if (strSym.equals("(")) {
      return 0;
    } else if (strSym.equals(")")) {
      return 0;
    }
    return -1;
  }

  /**
   * Method that converts string representation of mathematical equation from
   * infix notation to postfix notation.
   * 
   * @param what String that is evaluated.
   *          
   * @return Postfix string representation of infix equation input.
   * @throws IncorrectInputException
   *           custom exception.
   */

  public String convert(String what) throws IncorrectInputException {

    String result = "";
    String temp = "";
    String[] splited = what.split(" ");// splits input what by spaces into array of stings

    if (splited.length == 1 && isNumeric(splited[0])) { // in stouten in which user just
      // placed number
      result += splited[0];
      return result;
    }

    if (splited.length > 1) { // if input consists of more then one number/symbol
      Boolean broken = true;
      String tempTest = "";
      for (int i = 0; i < splited.length; i++) { // checks for no symbol in equation
        tempTest = splited[i];
        if (isSymbolNotThrow(tempTest)) {
          broken = false;
        }
      }
      if (broken == true) {
        throw new IncorrectInputException();
      }
    }

    try {

      values = new OpStack();

      for (int i = 0; i < splited.length; i++) { // iterates over each element of an array
        temp = splited[i];

        if (isNumeric(temp)) { // adds to result string if it's a number
          result += temp + " ";
        } else if (isSymbol(temp)) { // if its a symbol
          if (isOpBracket(temp)) { // if symbol is opening bracket
            values.push(symbolTransfor(temp));
          } else if (isCloBracket(temp)) { // if symbol is closing bracket

            String tempSym = values.peek();
            while (!isOpBracket(tempSym) && !values.isEmpty()) {
              values.pop();
              result += tempSym + " ";
              tempSym = values.peek();

            }
            values.pop();

          } else if (values.isEmpty()) { // for every other symbol
            values.push(symbolTransfor(temp)); // pushes new symbol onto stack if it's empty
          } else {
            String tempSym = values.peek();
            while (symbolVal(tempSym) >= symbolVal(temp)) {
              result += tempSym + " ";
              values.pop();
              if (!values.isEmpty()) {
                tempSym = values.peek();
              } else {
                break;
              }

            }

            values.push(symbolTransfor(temp));
          }

        }

      }

      while (!values.isEmpty()) { // adds every symbol that is left on the stack to the answer
        String tempSym = values.peek();
        result += tempSym + " ";
        values.pop();
        if (!values.isEmpty()) {
          tempSym = values.peek();
        } else {
          break;
        }

      }

    } catch (Exception e) { //any exception indicates wrong input from the user
      if (e instanceof IOException) {
        throw new IncorrectInputException();
      } else if (e instanceof IndexOutOfBoundsException) {
        throw new IncorrectInputException();
      } else if (e instanceof IncorrectInputException) {
        throw new IncorrectInputException();
      }

    }
    return result;

  }

  /**
   * Method that evaluates mathematical expression written in infix notation and
   * returns float value as answer. Takes string representation of expression in
   * infix, converts it to postfix, and then evaluates that using postix
   * calculator.
   * 
   * @throws IncorrectInputException
   *           custom exception
   */

  @Override
  public float evaluate(String what) throws IncorrectInputException {
    StandardCalc calc = new StandardCalc();
    what = calc.convert(what);
    float result = rpCalc.evaluate(what);

    return result;

  }

}
