package calcbasic;

/**
 * Facade for Stack class that only creates a stack that can be felled with
 * string values. This facade class is not used in the final program.
 * 
 * @author Pawel Daniewski
 *
 */

public class StrStack {

  private Stack strStack;

  /**
   * Constructor for SrtStack.
   */
  public StrStack() {
    strStack = new Stack();

  }

  /**
   * Checks is the strStack is empty.
   * 
   * @return boolean value.
   */
  public boolean isEmpty() {
    return strStack.isEmpty();
  }

  /**
   * Push method for strStack, pushes new string to stack.
   * 
   * @param string string that is pushed onto the stack.
   */
  public void push(String string) {
    strStack.push(new Entry(string));

  }

  /**
   * Pop method for strStack, pops top element of the stack.
   */
  public void pop() {
    strStack.pop();

  }

}
