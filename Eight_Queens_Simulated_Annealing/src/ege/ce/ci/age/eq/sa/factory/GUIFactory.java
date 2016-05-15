package ege.ce.ci.age.eq.sa.factory;

import javax.swing.JFrame;

import ege.ce.ci.age.eq.sa.controller.SolveButtonController;
import ege.ce.ci.age.eq.sa.controller.StatisticButtonController;
import ege.ce.ci.age.eq.sa.view.ButtonPanel;
import ege.ce.ci.age.eq.sa.view.ChessPanel;
import ege.ce.ci.age.eq.sa.view.ParameterPanel;
import ege.ce.ci.age.eq.sa.view.StatisticPanel;

public class GUIFactory implements AbstractGUIFactory {
  @Override
  public JFrame createEightQueenFrame() {
    return new JFrame();
  }

  @Override
  public ChessPanel createChessPanel() {
    return new ChessPanel();
  }

  @Override
  public ParameterPanel createParameterPanel() {
    return new ParameterPanel();
  }

  @Override
  public ButtonPanel createButtonPanel() {
    return new ButtonPanel();
  }

  @Override
  public SolveButtonController createSolveButtonController() {
    return new SolveButtonController();
  }

  @Override
  public StatisticButtonController createStatisticButtonController() {
    return new StatisticButtonController();
  }

  @Override
  public JFrame createStatisticFrame() {
    return new JFrame();
  }

  @Override
  public StatisticPanel createStatisticPanel() {
    return new StatisticPanel();
  }
}
