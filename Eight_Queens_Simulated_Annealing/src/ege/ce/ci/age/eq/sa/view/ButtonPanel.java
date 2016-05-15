package ege.ce.ci.age.eq.sa.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ege.ce.ci.age.eq.sa.controller.SolveButtonController;
import ege.ce.ci.age.eq.sa.controller.StatisticButtonController;

public class ButtonPanel extends JPanel {
  private static final long serialVersionUID = 3682338522785801993L;

  private JButton btnSolve = new JButton("Solve it!");
  private JButton btnStatistic = new JButton("Statistics");

  public ButtonPanel() {
    super(new BorderLayout());

    JPanel pnlAlign = new JPanel();
    pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
    this.add(pnlAlign, BorderLayout.CENTER);

    JPanel pnlBtn = new JPanel();
    pnlBtn.setLayout(new BoxLayout(pnlBtn, BoxLayout.Y_AXIS));
    pnlBtn.setBorder(BorderFactory.createEmptyBorder());
    pnlAlign.add(pnlBtn);

    pnlBtn.add(this.btnSolve);
    pnlBtn.add(this.btnStatistic);
  }

  public void setController(SolveButtonController solveButtonController,
      StatisticButtonController statisticButtonController) {
    this.btnSolve.addActionListener(solveButtonController);
    this.btnStatistic.addActionListener(statisticButtonController);
  }
}
