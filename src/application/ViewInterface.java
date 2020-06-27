package application;

import java.util.function.Consumer;

/**
 * Inteface for calculator.
 * @author Professor David Cohen
 *
 */
public interface ViewInterface {

  void addCalcObserver(Observer f);

  void addTypeObserver(Consumer<OpType> l);

  String getQuestion();

  void setAnswer(String a);
  ///////////////////////////////////////////////////////////////////

}