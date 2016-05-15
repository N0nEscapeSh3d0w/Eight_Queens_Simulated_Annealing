package ege.ce.ci.age.eq.sa;

import javax.swing.UIManager;

import ege.ce.ci.age.eq.sa.factory.EightQueenClient;

public class SimulatedAnnealingSimulator {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    new EightQueenClient();
  }
}
