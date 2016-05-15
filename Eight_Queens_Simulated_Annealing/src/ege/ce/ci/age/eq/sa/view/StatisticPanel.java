package ege.ce.ci.age.eq.sa.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;
import ege.ce.ci.age.eq.sa.observer.NotifyAction;
import ege.ce.ci.age.eq.sa.observer.Observer;
import ege.ce.ci.age.eq.sa.observer.Subject;

public class StatisticPanel extends JPanel implements Observer {
  private static final long serialVersionUID = -2299996637736692394L;
  private JLabel[][] fields;
  private JPanel panel = new JPanel(new GridLayout(28, 1));
  int dataCount = 1;

  public StatisticPanel() {
    this.add(panel);
    this.init();
  }

  private void init() {
    this.fields = new JLabel[28][1];
    for (int r = 0; r < 28; r++) {
      for (int c = 0; c < 1; c++) {
        this.fields[r][c] = new JLabel();
        this.fields[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.fields[r][c].setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(this.fields[r][c]);
      }
    }
    fields[0][0].setText("Process Time(millis)");
    fields[26][0].setText("Mean(millis)");
    fields[27][0].setText("0");
  }

  public void addStatistic(ProblemSolver s) {
    if (dataCount > 25) {
      dataCount = 1;
      this.clear();
      this.init();
    }
    fields[dataCount][0].setText(String.valueOf(s.getProcessTime()));
    Double currentMean = Double.valueOf(fields[27][0].getText());
    fields[27][0]
        .setText(String.valueOf((currentMean * (dataCount - 1) + s.getProcessTime()) / dataCount));
    dataCount++;
  }

  public void clear() {
    for (int r = 0; r < 28; r++) {
      for (int c = 0; c < 1; c++) {
        panel.remove(this.fields[r][c]);
      }
    }
  }


  @Override
  public void update(Subject s, NotifyAction action) {
    switch (action) {
      case FINISH:
        addStatistic((ProblemSolver) s);
        break;
      default:
        break;
    }
  }
}
