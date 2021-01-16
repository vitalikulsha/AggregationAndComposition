package Task_02_Car;

/*
Параметры автомобиля: марка, модель, тип кузова, тип двигателя, тип и количество колес
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
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

    public Car(String carBrand, String model, String type, Wheel[] wheel) {
        this.carBrand = carBrand;
        this.model = model;
        this.type = type;
        this.engine = new Engine();
        this.wheel = wheel;
        this.numberWheels = wheel.length;
    }

    //ехать
    public void driveCar() {
        engine.startEngine();
        System.out.println("Ехать. Вж-ж-ж-ж-ж.");
    }

    //заправить автомобиль
    public void refuelCar() {
        System.out.println("Заправить автомобиль топливом - " + this.engine.getFuel() + ". Буль-буль-буль.");
    }

    //вывести в консоль марку автомобиля
    public void printTitle() {
        System.out.println("Марка автомобиля: " + this.carBrand + " " + this.model);
    }

    //Заменить колесо
    public Wheel[] replacementWheel(Wheel newWheel, int numberWheel) {
        if (numberWheel <= this.wheel.length) {
            System.out.println("Заменить колесо №" + numberWheel + " - \"" + this.wheel[numberWheel - 1].toString() +
                    "\" на колесо \"" + newWheel.toString() + '\"');
            for (int i = 0; i < this.wheel.length; i++) {
                this.wheel[numberWheel - 1] = newWheel;
            }
        } else {
            System.out.println("Колесо с номером " + numberWheel + " не существует, невозможно произвести замену.");
        }
        return this.wheel;
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
            sb.append((i + 1) + " - " + wheel[i].toString() + ", ");
        }
        return "Автомобиль: " +
                "\nмарка автомобиля: '" + carBrand + '\'' +
                "\nмодель: '" + model + '\'' +
                "\nтип кузова: '" + type + '\'' +
                "\nДвигатель: " + engine.toString() +
                "\nколичество колес = " + numberWheels +
                ": " + sb.substring(0, sb.length() - 2).toString();
    }
}
