package entities2.impl;

import entities2.Car;
import entities2.Engine;
import entities2.Tire;

public class CarTE implements Car {
    private Engine engine;
    private Tire tire;

    public CarTE() {}

    public CarTE(Engine engine, Tire tire) {
        this.engine = engine;
        this.tire = tire;
    }

    // public void setEngine(Engine engine) {
    //     this.engine = engine;
    // }

    // public void setTire(Tire tire) {
    //     this.tire = tire;
    // }

    public void run() {
        engine.fire();
        tire.roll();
        System.out.println("汽车启动！");
    }

}