package ege.ce.ci.age.eq.sa.factory;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;

public interface AbstractEightQueenFactory {
  public ProblemSolver createSolution();

  public AbstractGUIFactory createGUI();
}
