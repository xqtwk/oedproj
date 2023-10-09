package main.observer;

import java.util.ArrayList;
import java.util.List;

class HRSystem {

    private List<Observer> observers;

    public HRSystem() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void hireEmployee(String employeeName, String employeeRole) {
        if (employeeRole == "ITC") {
            observers.add(new ConcreteObserver(employeeName, employeeRole));
        }
        for (Observer observer : observers) {
            observer.update("Naujas darbuotojas " + employeeName + " idarbintas kaip " + employeeRole);
        }
    }
    public static void main(String[] args) {
        HRSystem hrSystem = new HRSystem();

        hrSystem.hireEmployee("Jonas", "ITC");
        hrSystem.hireEmployee("Arnas", "ITC");
        hrSystem.hireEmployee("Arvydas", "ITC");


    }
}
