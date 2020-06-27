package calcbasic;

/**
 * Class that creates enums used operators used in mathematical equations.
 * 
 * @author GS63
 *
 */

public enum Symbol {
  LEFTBRACKET("("), RIGHTBRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID("");

  public String symbol;

  /**
   * Constructor for a symbol.
   * @param exSymbol string representing symbol.
   */
  Symbol(String exSymbol) {
    this.symbol = exSymbol;
  }

  /**
   * Method that returns string value of symbol. 
   * @return string value of symbol.
   */
  public String valOfSymbol() {
    return symbol;
  }

}
