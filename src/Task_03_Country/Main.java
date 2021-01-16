package Task_03_Country;

/* Task 03
3. Создать объект класса Государство, используя классы Область, Район, Город.
Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */
public class Main {
    public static void main(String[] args) {
        Country belarus = new Country("Республика Беларусь", minsk, brestRegion, vitebskRegion, gomelRegion,
                grodnoRegion, minskRegion);
        belarus.printCapital();
        belarus.printNumberRegions();
        belarus.printAreaCountry();
        belarus.printRegionCenter();

        //Проверка методов toString()
        brest.setDistrict(brestDistr);
        System.out.println(brest.toString());
        System.out.println(brestDistr.toString());
        System.out.println(brestRegion.toString());
        System.out.println(belarus.toString());

        //проверка композиции и агрегации
        brestRegion.setCountry(belarus);
        vitebskRegion.setCountry(belarus);
        grodnoRegion.setCountry(belarus);
        gomelRegion.setCountry(belarus);
        minskRegion.setCountry(belarus);
        brestDistr.setRegion(brestRegion);
        baranovichiDistr.setRegion(brestRegion);
        grodnoDistr.setRegion(grodnoRegion);
        System.out.println(minskRegion.getName() + " - " + minskRegion.getCountry().getName());
        System.out.println(vitebskRegion.getName() + " - " + vitebskRegion.getCountry().getName());
        System.out.println(brestDistr.getName() + " - " + brestDistr.getRegion().getName());
        System.out.println(baranovichiDistr.getName() + " - " + baranovichiDistr.getRegion().getName());

        //Добавляем новый город - Жодино, Скидель
        City zhodino = new City("Жодино", 23.21, 65000, smolevichiDistr);
        System.out.println(zhodino.getName() + " входит в состав " + zhodino.getDistrict().getName());
        City skidel = new City("Скидель", 10.12, 10000, grodnoDistr);
        System.out.println(skidel.getName() + " находится в " + skidel.getDistrict().getName() +
                " " + skidel.getDistrict().getRegion().getName() + " " +
                skidel.getDistrict().getRegion().getCountry().getName());
        grodnoDistr.addCity(skidel);
        smolevichiDistr.addCity(zhodino);
        System.out.println("\nГорода " + smolevichiDistr.getName() + ':');
        for (City value : smolevichiDistr.getCity()) {
            System.out.println(value.getName());
        }
        System.out.println("\nГорода " + brestDistr.getName() + ':');
        for (City value : brestDistr.getCity()) {
            System.out.println(value.getName());
        }

        //Добавляем новый район - Березенский
        City berezino = new City("Березино", 11.21, 11000);
        District berezinoDistr = new District("Березенский район", berezino, 1940.34, 22000);
        berezino.setDistrict(berezinoDistr);
        minskRegion.addDistrict(berezinoDistr);
        System.out.println("\nРайоны " + minskRegion.getName() + ':');
        for (District value : minskRegion.getDistrict()) {
            System.out.println(value.getName());
        }

        //Добавляем новую область - Могилевскую
        Region mogilevRegion = new Region("Могилевская область", mogilev, mogilevDistr, bobruiskDistr, osipovichiDistr);
        belarus.addRegion(mogilevRegion);
        belarus.printAreaCountry();
        belarus.printRegionCenter();
        belarus.printNumberRegions();
    }

    //Города
    //Брестская область
    private static City brest = new City("Брест", 146.12, 340000);
    private static City pinsk = new City("Пинск", 47.36, 126000);
    private static City baranovichi = new City("Барановичи", 84.96, 175000);
    //Витебская область
    private static City vitebsk = new City("Витебск", 134.6, 365000);
    private static City braslav = new City("Браслав", 2.28, 10000);
    private static City lepel = new City("Лепель", 17.2, 18000);
    //Гомельская область
    private static City gomel = new City("Гомель", 139.77, 510000);
    private static City mozyr = new City("Мозырь", 44.18, 111000);
    private static City svetlogorsk = new City("Светлогорск", 25.86, 65000);
    //Гродненская область
    private static City grodno = new City("Гродно", 142.11, 357000);
    private static City lida = new City("Лида", 45.79, 103000);
    private static City shchuchin = new City("Щучин", 15.45, 16000);
    //Минская область
    private static City minsk = new City("Минск", 348.84, 2000000);
    private static City smolevichi = new City("Смолевичи", 16.45, 17000);
    private static City borisov = new City("Борисов", 46.0, 130000);
    private static City logoisk = new City("Логойск", 15.13, 15000);
    //Могилевская область
    private static City mogilev = new City("Могилев", 118.5, 357000);
    private static City bobruisk = new City("Бобруск", 96.4, 212000);
    private static City osipovichi = new City("Осиповичи", 20.32, 30000);

    //Районы
    //Брестская область
    private static District brestDistr = new District("Брестский район", brest, 1544.11, 383000);
    private static District pinskDistr = new District("Пинский район", pinsk, 3252.77, 172000);
    private static District baranovichiDistr = new District("Барановичский район", baranovichi, 2171.88, 205000);
    //Витебская область
    private static District vitebskDistr = new District("Витебский район", vitebsk, 2737, 402000);
    private static District braslavDistr = new District("Браславский район", braslav, 2270.07, 35000);
    private static District lepelDistr = new District("Лепельский район", lepel, 1822.22, 51000);
    //Гомельская область
    private static District gomelDistr = new District("Гомельский район", gomel, 1951.4, 578000);
    private static District mozyrDiste = new District("Мозырьский район", mozyr, 1603.47, 133000);
    private static District svetlogorskDistr = new District("Светлогорский район", svetlogorsk, 1899.91, 83000);
    //Гродненская область
    private static District grodnoDistr = new District("Гродненский район", grodno, 2594.05, 407000);
    private static District lidaDistr = new District("Лидский район", lida, 1566.74, 132000);
    private static District shchuchinDaistr = new District("Щучинский район", shchuchin, 1911.54, 40000);
    //Минская область
    private static District minskDistr = new District("Минский район", minsk, 2251.5, 2215000);
    private static District smolevichiDistr = new District("Смолевичский район", smolevichi, 1394.14, 46000);
    private static District logoiskDistr = new District("Логойский район", logoisk, 2365.02, 35000);
    private static District borisovDistr = new District("Борисовский район", borisov, 2987.63, 180000);
    //Могилевская область
    private static District mogilevDistr = new District("Могилевский район", mogilev, 1895.4, 397000);
    private static District bobruiskDistr = new District("Бобруйский район", bobruisk, 1599.05, 228000);
    private static District osipovichiDistr = new District("Осиповичский район", osipovichi, 1947.21, 48000);

    //Области
    private static Region brestRegion = new Region("Брестская область", brest, brestDistr, baranovichiDistr, pinskDistr);
    private static Region vitebskRegion = new Region("Витебская область", vitebsk, vitebskDistr, brestDistr, lepelDistr);
    private static Region gomelRegion = new Region("Гомельская область", gomel, gomelDistr, mozyrDiste, svetlogorskDistr);
    private static Region grodnoRegion = new Region("Гродненская область", grodno, grodnoDistr, lidaDistr, shchuchinDaistr);
    private static Region minskRegion = new Region("Минская область", minsk, minskDistr, smolevichiDistr, borisovDistr, logoiskDistr);
    //private static Region mogilevRegion = new Region("Могилевская область", mogilev, mogilevDistr, bobruiskDistr, osipovichiDistr);

}
