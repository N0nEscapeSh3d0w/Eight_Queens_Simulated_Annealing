package ege.ce.ci.age.eq.sa.algorithm;

import java.util.concurrent.TimeUnit;

import ege.ce.ci.age.eq.sa.model.ProblemSolver;

public class SimulatedAnnealing {
  private double currentSystemTemperature = 0.0; // SU ANKI SISTEM SICAKLIGI.
  private double currentStabilizer = 0.0; // SU ANKI DENGELEYICI DUZEYI.
  private double coolingFactor = 0.0; // SOGUTMA FAKTORU.
  private double stabilizingFactor = 0.0; // DENGELEYICI FAKTORU.
  private double freezingTemperature = 0.0; // EN DUSUK SISTEM SICAKLIGI.

  private double currentSystemEnergy; // SU ANKI ATAK SAYISI.
  private Queens queens; // SATRANC TAHTASI SINIFI.

  private double processTime;

  public void init(Double initialTemperature, Double initialStabilizer, Double coolingFactor,
      Double stabilizingFactor, Double freezingTemperature) {
    this.currentSystemTemperature = initialTemperature;
    this.currentStabilizer = initialStabilizer;
    this.coolingFactor = coolingFactor;
    this.stabilizingFactor = stabilizingFactor;
    this.freezingTemperature = freezingTemperature;

    this.queens = new Queens();
  }

  /**
   * 
   * @param temperature SISTEMIN SU ANKI SICAKLIGI.
   * @param delta YENI HAMLE DEGERI ILE ONCEKI DEGERIN FARKI.
   * @return YENI HAMLENIN KABUL EDILIP EDILMEYECEGI.
   */
  public boolean probabilityFunction(Double temperature, Double delta) {
    if (delta < 0) { // YENI HAMLE DAHA IYI ISE DIREKT KABUL EDILIR.
      return true;
    }

    // YENI HAMLE DAHA KOTUYSE ISTATISTIK ISLEMI SONUCU KABUL EDILIR.
    double C = Math.exp(-delta / temperature);
    double R = Math.random();

    if (R < C) {
      return true;
    }

    return false;
  }

  public void runSimulatedAnnealing(ProblemSolver problemSolver) {
    this.processTime = 0;

    long start = System.nanoTime();
    this.currentSystemEnergy = this.queens.initialState(); // BASLANGIC TAHTASI AYARLANIR.
    while (true) {
      if (this.currentSystemTemperature > this.freezingTemperature) { // SISTEM SICAKLIGININ EN
                                                                      // DUSUK DUZEYE
                                                                      // ULASIP ULASMADIGI KONTROL
                                                                      // EDILIR.
        for (int i = 0; i < this.currentStabilizer; i++) { // DENGELEYICI DEGERI KADAR RASTGELE
                                                           // HAMLE YAPILIR.
          double newEnergy = this.queens.generateRandomSuccessor(), // YENI RASTGELE HAMLE SONUCU
                                                                    // ATAK DEGERI.
              energyDelta = newEnergy - this.currentSystemEnergy; // YENI RASTGELE HAMLE SONUCUNDAKI
                                                                  // ATAK DEGERI VE ONCEKI ATAK
                                                                  // DEGERI FARKI DELTA.
          if (probabilityFunction(this.currentSystemTemperature, energyDelta)) { // YENI HAMLENIN
                                                                                 // KABUL
                                                                                 // EDILEBILIRLIGI.
            this.queens.acceptSuccessor(); // YENI HAMLENIN KABUL EDILIP TAHTANIN GUNCELLENMESI.
            this.currentSystemEnergy = newEnergy; // SU ANKI ATAK DEGERININ YENI HAMLE SONUCU ATAK
                                                  // DEGERI ILE GUNCELLENMESI.
            if (this.currentSystemEnergy == 0) { // GENEL OPTIMUM ELDE EDILMISTIR. PROBLEM
                                                 // COZULMUSTUR.
              long end = System.nanoTime();
              this.processTime = TimeUnit.NANOSECONDS.toMillis(end - start);
              return;
            }
          }
        }
        this.currentSystemTemperature = this.currentSystemTemperature - this.coolingFactor; // SISTEM
                                                                                            // SICAKLIGININ
                                                                                            // SOGUTMA
                                                                                            // FAKTORU
                                                                                            // KADAR
                                                                                            // DUSURULMESI.
        this.currentStabilizer = this.currentStabilizer * this.stabilizingFactor; // DENGELEYICININ
                                                                                  // DENGELEYICI
                                                                                  // FAKTORU KADAR
                                                                                  // ARTIRILMASI.
        continue; // SISTEM SICAKLIGI EN DUSUK DUZEYE ULASANA KADAR DEVAM.
      }
      this.currentSystemTemperature = this.freezingTemperature; // SISTEM SICAKLIGI EN DUSUK DUZEYE
                                                                // ULASMISTIR.
      break; // SISTEM SOGUDUGU ICIN ALGORITMA SONLANIR.
    }
  }

  public int[] getCurrentPositions() {
    return this.queens.getCurrentPositions();
  }

  public double getProcessTime() {
    return this.processTime;
  }
}
