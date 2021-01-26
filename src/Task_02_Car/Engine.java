package Task_02_Car;

/*
Параметры двигателя: объем (куб. см), тип топлива, расход топлива (л/100км), мощность (л.с.)
Методы: завести автомобиль (для последующей езды на нем).
 */
public class Engine {
    private int capacity;
    private String fuel;
    private double consumptionFuel;
    private int power;

    public Engine() {
    }

    public Engine(int capacity, String fuel, double consumptionFuel, int power) {
        this.capacity = capacity;
        this.fuel = fuel;
        this.consumptionFuel = consumptionFuel;
        this.power = power;
    }

    public void startEngine() {
        System.out.println("Завести двигатель. Дыр-дыр-дыр.");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getConsumptionFuel() {
        return consumptionFuel;
    }

    public void setConsumptionFuel(double consumptionFuel) {
        this.consumptionFuel = consumptionFuel;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "\nобъем = " + capacity +
                " куб.см.\nтип топлива = '" + fuel + '\'' +
                "\nрасход топлива = " + consumptionFuel +
                "л/100км\nмощность = " + power +
                " л.с.";
    }
}
