package calcbasic;
/**
 * This is a main custom Stack class.
 * 
 * @author Pawel Daniewski
 * @version 1.0
 * 
 * @see #size
 * @see #value
 * @see #isEmpty()
 * @see #push(Entry)
 * @see #pop()
 * @see #peek()
 * @see #toString()
 * @see #size()
 *
 */

public class Stack {

  private int size = 0; // stores stack size
  private Entry[] value = new Entry[100]; // arrey repository of stack content

  /**
   * Checks if the stack is empty, by retruning boolean True if the size of stack
   * is equal 0.
   * 
   * @return Boolean
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Pushes new Entry to stack.
   * 
   * @paramNew pushed new entry.
   * 
   */
  public void push(Entry entry) {
    value[size++] = entry;

  }

  /**
   * Method that removes top element of the stack.
   * 
   * @return Popped Stack
   */
  public Entry pop() {
    return value[--size];
  }

  /**
   * Returns integer value of top of the Stack.
   * 
   * @return Integer value of top element of the stack.
   */
  public float peek() {
    return value[size - 1].getValue();
  }

  /**
   * Custom to toString method.
   * 
   * @return String representation of Stack
   */
  @Override
  public String toString() {
    String stackPrint = "";
    for (int i = 0; i < size; i++) { // iterates thru Stack entries
      stackPrint += value[i].toString() + ", "; //adds String value of Entites to final string
    }
    return stackPrint;

  }

  /**
   * Method that returns size of a stack. 
   * 
   * @return integer value of stack size
   */

  public int size() { // created last for future development possibilites.

    return size;
  }
  
  /**
   * Method that retruns String expression of string storing symbol.
   * @return string representation of symbol 
   */

  public String peekSym() {
    
    return value[size - 1].getSymbol().valOfSymbol();
  }

}
