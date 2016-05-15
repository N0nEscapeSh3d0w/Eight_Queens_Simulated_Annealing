package ege.ce.ci.age.eq.sa.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;
import ege.ce.ci.age.eq.sa.observer.NotifyAction;
import ege.ce.ci.age.eq.sa.observer.Observer;
import ege.ce.ci.age.eq.sa.observer.Subject;

public class ChessPanel extends JPanel implements Observer {
  private static final long serialVersionUID = -3750323525250432419L;
  private final Field[][] fields;
  private JPanel panel = new JPanel(new GridLayout(8, 8));

  public ChessPanel() {
    this.add(panel);
    this.fields = new Field[8][8];
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        if (r % 2 == 0 && c % 2 == 0 || r % 2 == 1 && c % 2 == 1) {
          this.fields[r][c] = new Field(Color.WHITE);
        } else {
          this.fields[r][c] = new Field(Color.BLACK);
        }
        panel.add(this.fields[r][c]);
      }
    }
  }

  public void showSolution(final int[] positions) {
    for (int c = 0; c < positions.length; c++) {
      int r = positions[c];
      this.fields[r][c].putQueen();
    }
  }

  public void clearBoard() {
    for (int r = 0; r < 8; r++) {
      for (int c = 0; c < 8; c++) {
        fields[r][c].removeQueen();
      }
    }
  }

  @Override
  public void update(Subject s, NotifyAction action) {
    switch (action) {
      case START:
        updateBoard((ProblemSolver) s);
        break;
      case FINISH:
        clearBoard();
        updateBoard((ProblemSolver) s);
        break;
      default:
        break;
    }
  }

  private void updateBoard(ProblemSolver s) {
    showSolution(s.getCurrentPositions());
  }
}
