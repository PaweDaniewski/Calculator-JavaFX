package calcbasic;


/**
 * This is Entry class that will fill the roll of custom stack elements. Stores
 * only integer values. This class
 * 
 * @author Pawel Daniewski
 * 
 * 
 * @see #stSize
 * @see #Entry(int)
 * @see #equals(Object)
 * @see #getValue()
 * @see #setValue(int)
 * @see #toString()
 *
 */
public class Entry {

  private float stSize;
  private String stString;
  private Symbol stSymbol;
  @SuppressWarnings("unused")
  private Type stType;

  /**
   * Constructor that makes a component of stack.
   * 
   * 
   *          
   * 
   * 
   */
  public Entry(float value) {
    stSize = value;
    stType = Type.NUMBER;
 
  }
  /**
   * Constructor that stores string in entry.
   * @param string string value that is stored in entry.
   */
  

  public Entry(String string) {
    stString = string;
    stType = Type.STRING;
    
  }
  /**
   * Constructor for Entry that stores Symbol.
   * @param which This is Symbol.
   */
      

  public Entry(Symbol which) {
    stSymbol = which;
    stType = Type.SYMBOL;
    
  }

  /**
   * Returns value of Entry.
   * 
   * @return this Entry value
   */
  public float getValue() {
    return stSize;
  }

  /**
   * Functions sets value of Entry.
   * 
   * @param i integer value that is assigned to Entry.
   * 
   * 
   */
  public void setValue(int i) {
    stSize = i;
  }

  /**
   * Custom toString method of Entry value. Retruns string representation of Entry
   * integer value.
   * 
   * @return String representation of Entry value.
   */
  @Override
  public String toString() {
    String entStr = "" + stSize;
    return entStr;

  }
  /**
   * Retruns string value from entries volding string value.
   * @return string.
   */

  public String getString() {
    return stString;
  }
  
  /**
   * Method that retruns symbol value from entries holding symbol values.
   * @return
   */

  public Symbol getSymbol() {
    return stSymbol;
  }

  
}
