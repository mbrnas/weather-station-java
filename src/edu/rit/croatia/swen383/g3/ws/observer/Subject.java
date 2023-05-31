package edu.rit.croatia.swen383.g3.ws.observer;

import java.util.*;

public class Subject {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observe) {
        if (observe == null) {
            throw new NullPointerException();
        }
        if (!observers.contains(observe)) {
            observers.add(observe);
        }
    }

    public void detach(Observer observe) {
        observers.remove(observe);
    }

    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update();
        });
    }

}