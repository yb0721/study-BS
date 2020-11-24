package entities;

public class Car {
    private Engine engine;
    private Tire tire;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void run() {
        engine.fire();
        tire.roll();
        System.out.println("汽车开动了！");
    }
}