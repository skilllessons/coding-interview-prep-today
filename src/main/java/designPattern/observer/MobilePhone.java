package main.java.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    double lat, lon;

    List<Observer> observers = new ArrayList<>();
    void move() {
        lat += 3.0;
        lon += 5.0;
        notifyUpdate();
    }

    void register(Observer observer) {
        observers.add(observer);
    }

    void notifyUpdate() {
        for (Observer observer : observers) {
            observer.update(lat, lon);
        }
    }
}

abstract class Observer {
    abstract void update(double lat, double lon);
}

class MobileApp extends Observer {

    @Override
    void update(double lat, double lon) {
        System.out.println(lat + " " + lon);

    }
}

class Test {
    public static void main(String[] args) {

        MobilePhone phone = new MobilePhone();
        phone.register(new MobileApp());
        phone.move();
        phone.move();
        phone.move();
        phone.move();

    }
}
