package ege.ce.ci.age.eq.sa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class StatisticButtonController implements ActionListener {
  private JFrame statisticFrame;

  public void init(JFrame statisticFrame) {
    this.statisticFrame = statisticFrame;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    this.statisticFrame.setVisible(true);
  }
}
