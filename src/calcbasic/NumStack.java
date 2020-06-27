package calcbasic;

/**
 * Facade for stack that only stores numbers.
 * 
 * @author Pawel Daniewski
 *
 */

public class NumStack {

  public Stack numStack; //Custom stack, not from javaApi.

  /**
   * Constructor for NumStack.
   */

  public NumStack() {
    numStack = new Stack();
  }

  /**
   * Push method for NumStack, pushes float number on stack.
   * 
   * @param i float number pushed on stack.
   *          
   */

  public void push(float i) {

    numStack.push(new Entry(i));

  }
  
  /**
   * IsEmpty method for NumStack. 
   * @return boolean that depends on SumStack being empty.
   */

  public boolean isEmpty() {

    return numStack.isEmpty();
  }
  
  /**
   * Pop method for NumStack.
   */

  public void pop() {
    numStack.pop();
    // TODO Auto-generated method stub

  }
  
  /**
   * Peek method for num stack, returns top number from the stack.
   * @return top number from NumStack.
   */

  public float peek() {
    return numStack.peek();
  }

}
