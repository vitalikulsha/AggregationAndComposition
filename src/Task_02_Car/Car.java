package Task_02_Car;

import java.util.Arrays;

/*
Параметры автомобиля: марка, модель, тип кузова, тип двигателя, тип и количество колес
 */
public class Car {
    private String carBrand;
    private String model;
    private String type;
    private Engine engine;
    private Wheel[] wheel;
    private int numberWheels;

    public Car() {
        this.engine = new Engine();
    }

    public Car(String carBrand, String model, String type, Engine engine, Wheel[] wheel, int numberWheels) {
        this.carBrand = carBrand;
        this.model = model;
        this.type = type;
        this.engine = new Engine();
        this.wheel = wheel;
        this.numberWheels = numberWheels;
    }

    public Wheel[] createWheelArr() {
        Wheel[] wheelArr = new Wheel[this.numberWheels];
        for (int i = 0; i < wheelArr.length; i++) {
            wheelArr[i] = this.wheel[i];
        }
        return wheelArr;
    }

    public void driveCar() {
        engine.startEngine();
        System.out.println("Ехать");
    }

    public void refuelCar() {
        System.out.println("Заправить автомобиль топливом - " + engine.getFuel());
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getNumberWheels() {
        return numberWheels;
    }

    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }

    public Wheel[] getWheel() {
        return wheel;
    }

    public void setWheel(Wheel[] wheel) {
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wheel.length; i++) {
            sb.append((i + 1) + " - " + wheel.toString() + " ");
        }
        return "Автомобиль: " +
                "марка автомобиля - '" + carBrand + '\'' +
                ", модель - '" + model + '\'' +
                ", тип кузова - '" + type + '\'' +
                ", двигатель - " + engine.toString() +
                ", колеса - " + sb.toString() +
                ", количество колес = " + numberWheels +
                '}';
    }
}
