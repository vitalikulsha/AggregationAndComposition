package Task_05_TouristPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Task 05
5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
  Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TouristPackageGenerator tpGenerator = new TouristPackageGenerator(tpSet);
        tpGenerator.searchCountry(readCountry(reader));
        tpGenerator.searchLocality(readLocality(reader));
        tpGenerator.searchType(readType(reader));
        tpGenerator.searchTransport(readTransport(reader));
        tpGenerator.searchNutrition(readNutrition(reader));
        tpGenerator.searchNumberDays(readNumberDays(reader));
        tpGenerator.searchTypeTransportNutritionNumberDays(readType(reader), readTransport(reader),
                readNutrition(reader), readIntervalNumberDays(reader));
        tpGenerator.searTypeTransport(readType(reader), readTransport(reader));*/
        tpGenerator.dynamicSearch(reader);
        reader.close();
    }

    //ввод страны назначения для поиска
    public static String readCountry(BufferedReader reader) throws IOException {
        System.out.print("Введите страну назначения для подбора списка путевок: ");
        String country = reader.readLine();
        return country;
    }

    //ввод пункта назначения для поиска
    public static String readLocality(BufferedReader reader) throws IOException {
        System.out.print("Введите пункт назначения для подбора списка путевок: ");
        String locality = reader.readLine();
        return locality;
    }

    //ввод типа путевки для поиска
    public static String readType(BufferedReader reader) throws IOException {
        System.out.print("Введите тип путевки для подбора списка путевок: ");
        String type = reader.readLine();
        while (true) {
            if (type.equalsIgnoreCase("отдых") || type.equalsIgnoreCase("экскурсия") ||
                    type.equalsIgnoreCase("лечение") || type.equalsIgnoreCase("шопинг") ||
                    type.equalsIgnoreCase("круиз")) {
                break;
            } else {
                System.out.print("Тип путевки введен некорректно. Введите еще раз: ");
                type = reader.readLine();
            }
        }
        return type;
    }

    //ввод вида транспорта для поиска
    public static String readTransport(BufferedReader reader) throws IOException {
        System.out.print("Введите вид транспорта для подбора списка путевок: ");
        String transport = reader.readLine();
        while (true) {
            if (transport.equalsIgnoreCase("поезд") || transport.equalsIgnoreCase("автобус") ||
                    transport.equalsIgnoreCase("самолет")) {
                break;
            } else {
                System.out.print("Вид транспорта введен некорректно. Введите еще раз: ");
                transport = reader.readLine();
            }
        }
        return transport;
    }

    //ввод вида питания для поиска
    public static String readNutrition(BufferedReader reader) throws IOException {
        System.out.print("Введите вид питания для подбора списка путевок: ");
        String nutrition = reader.readLine();
        while (true) {
            if (nutrition.equalsIgnoreCase("без питания") || nutrition.equalsIgnoreCase("завтрак") ||
                    nutrition.equalsIgnoreCase("двухразовое") || nutrition.equalsIgnoreCase("трехразовое") ||
                    nutrition.equalsIgnoreCase("все включено")) {
                break;
            } else {
                System.out.print("Вид питания введен некорректно. Введите еще раз: ");
                nutrition = reader.readLine();
            }
        }
        return nutrition;
    }

    //ввод количества дней для поиска
    public static int readNumberDays(BufferedReader reader) throws IOException {
        int numberDays = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.print("Введите количество дней для подбора списка путевок: ");
                numberDays = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                test = true;
            }
        }
        return numberDays;
    }

    //ввод количества дней для поиска
    public static int[] readIntervalNumberDays(BufferedReader reader) throws IOException {
        int[] numberDays = new int[2];
        boolean test = true;
        while (test) {
            try {
                System.out.print("Введите интервал дней отдых для подбора списка путевок:\nот ");
                numberDays[0] = Integer.parseInt(reader.readLine());
                System.out.print("до ");
                numberDays[1] = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                test = true;
            }
        }
        return numberDays;
    }

    //список туристических путевок
    private static TouristPackage tp_00 = new TouristPackage("Украина", "Львов", "экскурсия", "автобус", "без питания", 3);
    private static TouristPackage tp_01 = new TouristPackage("Украина", "Львов", "экскурсия", "автобус", "завтрак", 5);
    private static TouristPackage tp_02 = new TouristPackage("Украина", "Хмельницкий", "шопинг", "автобус", "без питания", 3);
    private static TouristPackage tp_03 = new TouristPackage("Украина", "Чернигов", "шопинг", "автобус", "без питания", 2);
    private static TouristPackage tp_04 = new TouristPackage("Украина", "Буковель", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_05 = new TouristPackage("Беларусь", "Нарочь", "лечение", "автобус", "трехразовое", 14);
    private static TouristPackage tp_06 = new TouristPackage("Беларусь", "Гродненская обл.", "экскурсия", "автобус", "без питания", 1);
    private static TouristPackage tp_07 = new TouristPackage("Беларусь", "Витебск", "экскурсия", "поезд", "завтрак", 3);
    private static TouristPackage tp_08 = new TouristPackage("Польша", "Белосток", "шопинг", "автобус", "без питания", 2);
    private static TouristPackage tp_09 = new TouristPackage("Литва", "Вильнюс", "экскурсия", "поезд", "двухразовое", 4);
    private static TouristPackage tp_10 = new TouristPackage("Латвия", "Рига", "отдых", "автобус", "трехразовое", 9);
    private static TouristPackage tp_11 = new TouristPackage("Латвия", "Юрмала", "отдых", "поезд", "завтрак", 7);
    private static TouristPackage tp_12 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_13 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 14);
    private static TouristPackage tp_14 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 5);
    private static TouristPackage tp_15 = new TouristPackage("Турция", "Анталия", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_16 = new TouristPackage("Турция", "Анталия", "отдых", "самолет", "завтрак", 5);
    private static TouristPackage tp_17 = new TouristPackage("Италия", "Неаполь", "круиз", "самолет", "трехразовое", 7);
    private static TouristPackage tp_18 = new TouristPackage("Италия", "Генуя", "круиз", "самолет", "трехразовое", 5);
    private static TouristPackage tp_19 = new TouristPackage("Испания", "Барселона", "экскурсия", "самолет", "завтрак", 4);
    private static TouristPackage tp_20 = new TouristPackage("Северная Корея", "Пхеньян", "экскурсия", "поезд", "трехразовое", 5);
    private static TouristPackage[] tpSet = new TouristPackage[]{tp_00, tp_01, tp_02, tp_03, tp_04, tp_05, tp_06, tp_07,
            tp_08, tp_09, tp_10, tp_11, tp_12, tp_13, tp_14, tp_15, tp_16, tp_17, tp_18, tp_19, tp_20};

}
