package ege.ce.ci.age.eq.sa.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Field extends JLabel {
  private static final long serialVersionUID = -7847852602183377317L;

  public Field(Color color) {
    super("", SwingConstants.CENTER);

    setBackground(color);
    setPreferredSize(new Dimension(40, 40));
    setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    setOpaque(true);
  }

  public void putQueen() {
    ImageIcon iconLogo = null;
    if (getBackground().equals(Color.BLACK)) {
      iconLogo = new ImageIcon("img/black_queen.png");
    } else if (getBackground().equals(Color.WHITE)) {
      iconLogo = new ImageIcon("img/white_queen.png");
    }
    this.setIcon(iconLogo);
  }

  public void removeQueen() {
    this.setIcon(null);
  }

}
