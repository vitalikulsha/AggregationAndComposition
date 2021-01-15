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
        Engine engine = new Engine(2200, "ДТ", 9.1, 150);
        car.setEngine(engine); //автомобиля car управляет двигателем engine
        engine.setCar(car); //двигателем engine управляет автомобиль car
        //вывод автомобиля, на который установлен двигатель car (проверка композиции)
        System.out.println("Двигатель: " + engine.toString() + ", установлен на:\n" +
                engine.getCar().toString());
        car.printTitle();
        car.driveCar();
        car.refuelCar();
        Wheel newWheel = new Wheel(265, 45, 'R', 17, "winter");
        car.replacementWheel(newWheel, 2);
        //Проверка замены колеса
        System.out.println('\n' + car.toString());
    }
}

