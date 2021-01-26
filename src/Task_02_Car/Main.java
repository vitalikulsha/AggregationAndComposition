package Task_02_Car;

/* Task 02
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Renault", "Vel Satis", "hatchback", engine, 2002, 85, 60, wheels);
        car.printTitle();
        car.driveCar();
        car.refuelCar(10);
        car.replaceWheel(newWheel, 2);
        //Вывод в консоль описание автомобиля для проверки замены колеса и измененния уровня топлива (заправки авто)
        System.out.println('\n' + car.toString());
    }

    private static Wheel[] createArrWheels(Wheel wheel) {
        Wheel[] wheelsArr = new Wheel[4];
        for (int i = 0; i < wheelsArr.length; i++) {
            wheelsArr[i] = wheel;
        }
        return wheelsArr;
    }

    private static Wheel[] wheels = createArrWheels(new Wheel(255, 55, 'R', 17, "winter"));
    private static Engine engine = new Engine(2200, "ДТ", 9.1, 150);
    private static Wheel newWheel = new Wheel(265, 45, 'R', 17, "winter");

}

