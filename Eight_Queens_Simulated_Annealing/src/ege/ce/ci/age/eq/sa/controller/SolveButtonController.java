package ege.ce.ci.age.eq.sa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;

public class SolveButtonController implements ActionListener {
  private ProblemSolver solver;

  public void init(ProblemSolver solver) {
    this.solver = solver;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    solver.solveProblem();
  }
}
