package ege.ce.ci.age.eq.sa.factory;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ege.ce.ci.age.eq.sa.controller.SolveButtonController;
import ege.ce.ci.age.eq.sa.controller.StatisticButtonController;
import ege.ce.ci.age.eq.sa.model.ProblemSolver;
import ege.ce.ci.age.eq.sa.view.ButtonPanel;
import ege.ce.ci.age.eq.sa.view.ChessPanel;
import ege.ce.ci.age.eq.sa.view.ParameterPanel;
import ege.ce.ci.age.eq.sa.view.StatisticPanel;

public class EightQueenClient {

  private final AbstractEightQueenFactory eightQueenFactory;
  private final AbstractGUIFactory guiFactory;
  private ChessPanel chessPanel;
  private ParameterPanel parameterPanel;
  private ButtonPanel buttonPanel;
  private SolveButtonController solveButtonController;
  private StatisticButtonController statisticButtonController;
  private JFrame eightQueenFrame;
  private JFrame statisticFrame;
  private StatisticPanel statisticPanel;
  private final ProblemSolver solver;

  public EightQueenClient() {
    this.eightQueenFactory = new EightQueenFactory();
    this.guiFactory = this.eightQueenFactory.createGUI();
    this.solver = this.eightQueenFactory.createSolution();
    this.chessPanel = this.guiFactory.createChessPanel();
    this.parameterPanel = this.guiFactory.createParameterPanel();
    this.buttonPanel = this.guiFactory.createButtonPanel();
    this.solveButtonController = this.guiFactory.createSolveButtonController();
    this.statisticButtonController = this.guiFactory.createStatisticButtonController();
    this.eightQueenFrame = this.guiFactory.createEightQueenFrame();
    this.statisticFrame = this.guiFactory.createStatisticFrame();
    this.statisticPanel = this.guiFactory.createStatisticPanel();
    this.requestGUI();
    this.requestSolver();
  }

  private void requestSolver() {
    this.solver.addObserver(this.chessPanel);
    this.solver.addObserver(this.parameterPanel);
    this.solver.addObserver(this.statisticPanel);
  }

  private void requestGUI() {
    this.requestEightQueenFrame();
    this.requestStatisticFrame();
  }

  private void requestStatisticFrame() {
    this.statisticFrame.setTitle("Hill Climbing Statistics");
    this.statisticFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.statisticFrame.getContentPane().setLayout(new BorderLayout());
    this.statisticFrame.add(this.statisticPanel, BorderLayout.CENTER);
    this.statisticFrame.pack();
    this.statisticFrame.setLocationRelativeTo(null);
  }

  private void requestEightQueenFrame() {
    this.requestButtonPanel();
    this.eightQueenFrame.setTitle("Eight Queen Problem");
    this.eightQueenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.eightQueenFrame.getContentPane().setLayout(new BorderLayout());
    this.eightQueenFrame.add(this.requestRightPanel(), BorderLayout.EAST);
    this.eightQueenFrame.add(this.chessPanel, BorderLayout.WEST);
    this.eightQueenFrame.pack();
    this.eightQueenFrame.setLocationRelativeTo(null);
    this.eightQueenFrame.setVisible(true);
  }

  private JPanel requestRightPanel() {
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createEmptyBorder());

    rightPanel.add(this.parameterPanel);
    rightPanel.add(this.buttonPanel);

    return rightPanel;
  }

  private void requestButtonPanel() {
    this.buttonPanel.setController(this.solveButtonController, this.statisticButtonController);
    this.solveButtonController.init(this.solver);
    this.statisticButtonController.init(this.statisticFrame);
  }
}
