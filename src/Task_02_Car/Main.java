package Task_02_Car;

/* Task 02
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */

public class Main {
    public static void main(String[] args) {
        Wheel[] wheelKit = new Wheel[4];
        for (int i = 0; i < wheelKit.length; i++) {
            wheelKit[i] = new Wheel(255, 55, 'R', 17, "winter");
        }
        Car car = new Car("Renault", "Vel Satis", "hatchback", wheelKit);
        //объект класса Engine (пустой) создается в классе Car (композиция)
        // заполняем поля объекта класса Engine
        car.getEngine().setCar(car);
        car.getEngine().setCapacity(2200);
        car.getEngine().setFuel("ДТ");
        car.getEngine().setConsumptionFuel(9.1);
        car.getEngine().setPower(150);
        car.printTitle();
        car.driveCar();
        car.refuelCar();
        Wheel newWheel = new Wheel(265, 45, 'R', 17, "winter");
        car.replacementWheel(newWheel, 2);
        //Проверка замены колеса
        System.out.println('\n' + car.toString());
        //вывод автомобиля, на который установлен двигатель car (проверка композиции)
        System.out.println("Двигатель: " + car.getEngine().toString() + "\nустановлен на:\n" +
                car.getEngine().getCar().toString());
    }
}

