package Task_02_Car;

/* Task 02
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
 */

/*
1. Доработать toString класса Wheel
2. Доработать
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Car myCar = new Car();
        myCar.setCarBrand("Renault");
        myCar.setModel("Vel Satis");
        myCar.setType("hatchback");
        myCar.setEngine(new Engine(2200, "ДТ", 9.1, 150));
        myCar.setNumberWheels(4);
        Wheel[] wheelArr = new Wheel[myCar.getNumberWheels()];
        for (int i = 0; i < wheelArr.length; i++) {
            wheelArr[i] = new Wheel(255, 55, 'R', 17, "winter");
        }
        myCar.setWheel(wheelArr);
        System.out.println(myCar.toString());
    }

    public static void printTitleCar(Car car) {
        System.out.println(car.getCarBrand() + " " + car.getModel());
    }
}

