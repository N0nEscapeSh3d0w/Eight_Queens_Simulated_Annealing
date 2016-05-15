package ege.ce.ci.age.eq.sa.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

  private List<Observer> observers = new ArrayList<Observer>();
  private boolean changed; // Herhangi bir guncelleme var mi ?

  public void addObserver(Observer o) {
    if (o == null)
      throw new NullPointerException();
    if (!observers.contains(o)) {
      observers.add(o);
    }
  }

  public void deleteObserver(Observer o) {
    observers.remove(o);
  }

  public void clearChanged() {
    changed = false;
  }

  public void setChanged() {
    changed = true;
  }

  public boolean hasChanged() {
    return changed;
  }

  public void clearObservers() {
    observers.clear();
  }

  public void notifyAllObservers() {
    notifyAllObservers(null);
  }

  public void notifyAllObservers(NotifyAction action) {
    if (!hasChanged()) {
      return;
    }
    clearChanged();

    for (int i = observers.size() - 1; i >= 0; i--) {
      (observers.get(i)).update(this, action);
    }
  }
}
