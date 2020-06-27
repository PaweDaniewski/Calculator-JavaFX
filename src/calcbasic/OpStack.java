package calcbasic;
/**
 * Facade for a Stack class that only stores Symbol values. 
 * Oprates mostly on methods from custom Stack class.
 * @author GS63
 *
 */

public class OpStack {
  
  private Stack opStack; // custom stack.
  
  /**
   * Constructor for OpStack.
   */
  public OpStack() {
    opStack = new Stack(); //initiates custom stack.
  }

  /**
   * Checks if the stack is empty.
   * @return boolean value. 
   */
  public boolean isEmpty() {
    return opStack.isEmpty();
  }
  /**
   * Pushes new Symbol to OpStack.
   * @param i Symbol enum.
   */

  public void push(Symbol i) {
    opStack.push(new Entry(i));
    
  }
  
  /**
   * Pop method for OpStack.
   */

  public void pop() {
    opStack.pop();
      
  }
  
  /**
   * Peek method for OpStack.
   * @return String value of peeked symbol from the top of the stack.
   */

  public String peek() {
    return opStack.peekSym();
  }

 

}
