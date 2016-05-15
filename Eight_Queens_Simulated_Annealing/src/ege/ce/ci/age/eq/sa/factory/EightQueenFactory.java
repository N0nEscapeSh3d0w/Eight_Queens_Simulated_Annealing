package ege.ce.ci.age.eq.sa.factory;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;

public class EightQueenFactory implements AbstractEightQueenFactory {
  @Override
  public ProblemSolver createSolution() {
    return new ProblemSolver();
  }

  @Override
  public AbstractGUIFactory createGUI() {
    return new GUIFactory();
  }
}
