package ege.ce.ci.age.eq.sa.model;

import ege.ce.ci.age.eq.sa.algorithm.SimulatedAnnealing;
import ege.ce.ci.age.eq.sa.observer.NotifyAction;
import ege.ce.ci.age.eq.sa.observer.Subject;

public class ProblemSolver extends Subject {
  SimulatedAnnealing simulatedAnnealing;

  public int[] getCurrentPositions() {
    return this.simulatedAnnealing.getCurrentPositions();
  }

  public ProblemSolver() {
    simulatedAnnealing = new SimulatedAnnealing();
  }

  /**
   * PROBLEMI COZME ASAMALARI.
   */
  public void solveProblem() {
    this.setChanged();
    this.notifyAllObservers(NotifyAction.INITIAL_STATE); // ARAYUZDEKI PARAMETRE PANELINE BILDIRIM
                                                         // GONDEREREK
                                                         // initAlgorithm FONKSIYONUNU CAGIRTIR.

    this.setChanged();
    this.notifyAllObservers(NotifyAction.START); // ARAYUZDEKI SATRANC TAHTASI PANELINE BILDIRIM
                                                 // GONDEREREK TAHTANIN ILK KONUMUNUN
                                                 // GORUNTULENMESINI SAGLAR.

    simulatedAnnealing.runSimulatedAnnealing(this); // ALGORITMAYI CALISTIRIR.
    this.setChanged();
    this.notifyAllObservers(NotifyAction.FINISH); // ALGORITMA CALISMA ISLEMININ BITTIGINI
                                                  // ARAYUZDEKI SATRANC TAHTASINA BILDIRIR.
  }

  /**
   * ARAYUZDEKI PARAMETRELER ILE ALGORITMANIN BASLANGIC DEGERLERINI ATAR.
   * 
   * @param initialTemperature
   * @param initialStabilizer
   * @param coolingFactor
   * @param stabilizingFactor
   * @param freezingTemperature
   */
  public void initAlgorithm(double initialTemperature, double initialStabilizer,
      double coolingFactor, double stabilizingFactor, double freezingTemperature) {
    simulatedAnnealing.init(initialTemperature, initialStabilizer, coolingFactor, stabilizingFactor,
        freezingTemperature);
  }

  public double getProcessTime() {
    return this.simulatedAnnealing.getProcessTime();
  }
}
