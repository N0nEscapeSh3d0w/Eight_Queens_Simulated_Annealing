package ege.ce.ci.age.eq.sa.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;
import ege.ce.ci.age.eq.sa.observer.NotifyAction;
import ege.ce.ci.age.eq.sa.observer.Observer;
import ege.ce.ci.age.eq.sa.observer.Subject;

public class ParameterPanel extends JPanel implements Observer {
  private static final long serialVersionUID = 3682338522785801993L;

  private JLabel lblInitialTemperature = new JLabel("Initial Temperature");
  private JTextField tfInitialTemperature = new JTextField("35.0");
  private JLabel lblInitialStabilizer = new JLabel("Initial Stabilizer");
  private JTextField tfInitialStabilizer = new JTextField("35.0");
  private JLabel lblCoolingFactor = new JLabel("Cooling Factor");
  private JTextField tfCoolingFactor = new JTextField("0.05");
  private JLabel lblStabilizingFactor = new JLabel("Stabilizing Factor");
  private JTextField tfStabilizingFactor = new JTextField("1.005");
  private JLabel lblFreezingTemperature = new JLabel("Freezing Temperature");
  private JTextField tfFreezingTemperature = new JTextField("0.0");

  public ParameterPanel() {
    super(new BorderLayout());

    JPanel pnlAlign = new JPanel();
    pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
    this.add(pnlAlign, BorderLayout.CENTER);

    JPanel pnlParameters = new JPanel();
    pnlParameters.setLayout(new BoxLayout(pnlParameters, BoxLayout.Y_AXIS));
    pnlParameters.setBorder(BorderFactory.createTitledBorder("Parameters"));
    pnlAlign.add(pnlParameters);

    pnlParameters.add(this.lblInitialTemperature);
    pnlParameters.add(this.tfInitialTemperature);
    pnlParameters.add(this.lblInitialStabilizer);
    pnlParameters.add(this.tfInitialStabilizer);
    pnlParameters.add(this.lblCoolingFactor);
    pnlParameters.add(this.tfCoolingFactor);
    pnlParameters.add(this.lblStabilizingFactor);
    pnlParameters.add(this.tfStabilizingFactor);
    pnlParameters.add(this.lblFreezingTemperature);
    pnlParameters.add(this.tfFreezingTemperature);
  }

  private void init(ProblemSolver s) {
    s.initAlgorithm(Double.valueOf(tfInitialTemperature.getText()),
        Double.valueOf(tfInitialStabilizer.getText()), Double.valueOf(tfCoolingFactor.getText()),
        Double.valueOf(tfStabilizingFactor.getText()),
        Double.valueOf(tfFreezingTemperature.getText()));
  }

  public double getInitialTemperature() {
    return Double.valueOf(tfInitialTemperature.getText());
  }

  public double getInitialStabilizer() {
    return Double.valueOf(tfInitialStabilizer.getText());
  }

  public double getCoolingFactor() {
    return Double.valueOf(tfCoolingFactor.getText());
  }

  public double getStabilizingFactor() {
    return Double.valueOf(tfStabilizingFactor.getText());
  }

  public double getFreezingTemperature() {
    return Double.valueOf(tfFreezingTemperature.getText());
  }

  @Override
  public void update(Subject s, NotifyAction action) {
    switch (action) {
      case INITIAL_STATE:
        init((ProblemSolver) s);
        break;
      default:
        break;
    }
  }
}
