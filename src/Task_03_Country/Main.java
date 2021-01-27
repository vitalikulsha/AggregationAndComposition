package Task_03_Country;

import static Task_03_Country.Database.*;

/* Task 03
3. Создать объект класса Государство, используя классы Область, Район, Город.
Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */
public class Main {
    public static void main(String[] args) {
        Country belarus = new Country("Республика Беларусь", regions);
        belarus.printCapital();
        belarus.printNumberRegions();
        belarus.printAreaCountry();
        belarus.printRegionCenter();
    }
}
