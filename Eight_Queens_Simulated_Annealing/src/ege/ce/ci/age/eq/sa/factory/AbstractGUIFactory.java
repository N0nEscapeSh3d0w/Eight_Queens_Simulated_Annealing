package ege.ce.ci.age.eq.sa.factory;

import javax.swing.JFrame;

import ege.ce.ci.age.eq.sa.controller.SolveButtonController;
import ege.ce.ci.age.eq.sa.controller.StatisticButtonController;
import ege.ce.ci.age.eq.sa.view.ButtonPanel;
import ege.ce.ci.age.eq.sa.view.ChessPanel;
import ege.ce.ci.age.eq.sa.view.ParameterPanel;
import ege.ce.ci.age.eq.sa.view.StatisticPanel;

public interface AbstractGUIFactory {
  public JFrame createEightQueenFrame();

  public ChessPanel createChessPanel();

  public ParameterPanel createParameterPanel();

  public ButtonPanel createButtonPanel();

  public SolveButtonController createSolveButtonController();

  public StatisticButtonController createStatisticButtonController();

  public JFrame createStatisticFrame();

  public StatisticPanel createStatisticPanel();
}
