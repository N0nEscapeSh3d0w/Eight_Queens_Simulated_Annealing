package ege.ce.ci.age.eq.sa.algorithm;

public class Queens {
  private int NUM_QUEENS = 8;
  private int[] currentQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1}; // SATRANC
  // TAHTASI.
  private int[] newQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1}; // DENEME TAHTASI.

  /**
   * VEZIRLERI TAHTADA FARKLI SUTUNLARDA RASTGELE SATIRLARA YERLESTIRIR.
   * 
   * @return TAHTADAKI ATAK SAYISI.
   */
  public int generateRandomPositions() {
    currentQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};

    for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
      boolean repetitions = true;

      while (repetitions) {
        currentQueensPositions[iQueen] = (int) (Math.random() * 8);

        if (!checkRepetitions(currentQueensPositions)) {
          repetitions = false;
        }
      }
    }

    return calculateAttacks(currentQueensPositions);
  }

  /**
   * VEZIRLERI TAHTADA FARKLI SUTUNLARDA RASTGELE SATIRLARA YERLESTIREN FONKSIYON ILE BASLANGIC
   * DURUMU YARATIR.
   * 
   * @return TAHTADAKI ATAK SAYISI.
   */
  public int initialState() {
    return generateRandomPositions();
  }

  /**
   * TAHTADAKI ATAK SAYISINI HESAPLAR.
   * 
   * @param board ATAK SAYISI HESAPLANACAK OLAN TAHTA.
   * @return TAHTADAKI ATAK SAYISI.
   */
  public int calculateAttacks(int[] board) {
    int numAttacks = 0;

    for (int iQueen = 0; iQueen < NUM_QUEENS - 1; iQueen++) {
      for (int iAttackingQueen = iQueen + 1; iAttackingQueen < NUM_QUEENS; iAttackingQueen++) {
        if (board[iQueen] == board[iAttackingQueen]) {
          numAttacks++;
        } else if (iQueen + board[iQueen] == iAttackingQueen + board[iAttackingQueen]) {
          numAttacks++;
        } else if (iQueen - board[iQueen] == iAttackingQueen - board[iAttackingQueen]) {
          numAttacks++;
        }
      }
    }
    return numAttacks;
  }

  /**
   * RASTGELE BIR HAMLE URETIR.
   * 
   * @return RASTGELE HAMLE SONUCUNDAKI ATAK SAYISI.
   */
  public int generateRandomSuccessor() {
    for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
      newQueensPositions[iQueen] = currentQueensPositions[iQueen];
    }

    int changingQueen = (int) (Math.random() * NUM_QUEENS);

    newQueensPositions[changingQueen] =
        (((newQueensPositions[changingQueen] + ((int) (Math.random() * 3) - 1)) % 8) + 8) % 8;

    return calculateAttacks(newQueensPositions);
  }

  public boolean checkRepetitions(int[] board) {
    int howMany = NUM_QUEENS;

    for (int iQueen = 0; iQueen < howMany - 1; iQueen++) {
      if (board[iQueen] == -1) {
        continue;
      }
      for (int iCheckQueen = iQueen + 1; iCheckQueen < howMany; iCheckQueen++) {
        if (board[iCheckQueen] == -1) {
          continue;
        }
        if (board[iQueen] == board[iCheckQueen]) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * DENEME TAHTASINDAKI POZISYONLARI KABUL EDEREK SATRANC TAHTASINI GUNCELLER.
   */
  public void acceptSuccessor() {
    for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
      currentQueensPositions[iQueen] = newQueensPositions[iQueen];
    }
  }

  /**
   * @return SATRANC TAHTASINDAKI POZISYONLAR.
   */
  public int[] getCurrentPositions() {
    if (currentQueensPositions[0] == -1) {
      return new int[NUM_QUEENS];
    }
    return currentQueensPositions;
  }
}
