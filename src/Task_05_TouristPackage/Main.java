package Task_05_TouristPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static Task_05_TouristPackage.DatabaseTouristPackage.tpSet;

/* Task 05
5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
  Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TouristPackageGenerator tpGenerator = new TouristPackageGenerator(tpSet);
        searchSelectMethod(tpGenerator, reader);
        sortSelectMethod(tpGenerator, reader);
        reader.close();
    }

    //Выбор способа сортировки туристических путевок и вывод в консоль отсортированного списка путевок
    public static void sortSelectMethod(TouristPackageGenerator tpGenerator, BufferedReader reader) throws IOException {
        System.out.println("1 - сортировка по стране назначения.");
        System.out.println("2 - сортировка по населенному пункту.");
        System.out.println("3 - сортировка по типу путевки.");
        System.out.println("4 - сортировка по виду транспорта.");
        System.out.println("5 - сортировка по виду питания.");
        System.out.println("6 - сортировка по количеству дней.");
        System.out.println("Любая другая цифра - без сортировки.");
        System.out.print("Выберите способ сортировки туристических путевок: ");
        int num = testReadNumber(reader);
        switch (num) {
            case (1): {
                tpGenerator.printSortedByCountry();
                break;
            }
            case (2): {
                tpGenerator.printSortedByLocality();
                break;
            }
            case (3): {
                tpGenerator.printSortedByType();
                break;
            }
            case (4): {
                tpGenerator.printSortedByTransport();
                break;
            }
            case (5): {
                tpGenerator.printSortedByNutrition();
                break;
            }
            case (6): {
                tpGenerator.printSortedByNumberDays();
                break;
            }
            default: {
                System.out.println("Список туристических путевок не отсортирован:\n" + tpGenerator.toString());
                break;
            }
        }
    }

    //Выбор способа поиска путевок
    public static void searchSelectMethod(TouristPackageGenerator tpGenerator, BufferedReader reader) throws IOException {
        System.out.println("1 - поиск по стране назначения.");
        System.out.println("2 - поиск по населенному пункту.");
        System.out.println("3 - поиск по типу путевки.");
        System.out.println("4 - поиск по виду транспорта.");
        System.out.println("5 - поиск по виду питания.");
        System.out.println("6 - поиск по количеству дней.");
        System.out.println("7 - поиск по типу путевки, виду транспорта, виду питания, количеству дней.");
        System.out.println("8 - поиск по типу путевки, виду транспорта.");
        System.out.println("Любая другая цифра - динамический поиск с последовательным выбором параметров поиска.");
        System.out.print("Выберите вариант поиска туристической путевки: ");
        int num = testReadNumber(reader);
        switch (num) {
            case (1): {
                System.out.println("Поиск по стране назначения:");
                tpGenerator.searchByCountry(readCountry(reader));
                break;
            }
            case (2): {
                System.out.println("Поиск по населенному пункту:");
                tpGenerator.searchByLocality(readLocality(reader));
                break;
            }
            case (3): {
                System.out.println("Поиск по типу путевки:");
                tpGenerator.searchByType(readType(reader));
                break;
            }
            case (4): {
                System.out.println("Поиск по виду транспорта:");
                tpGenerator.searchByTransport(readTransport(reader));
                break;
            }
            case (5): {
                System.out.println("Поиск по виду питания:");
                tpGenerator.searchByNutrition(readNutrition(reader));
                break;
            }
            case (6): {
                System.out.println("Поиск по количеству дней:");
                tpGenerator.searchByNumberDays(readNumberDays(reader));
                break;
            }
            case (7): {
                System.out.println("Поиск по типу путевки и виду транспорта:");
                tpGenerator.searchByTypeTransport(readType(reader), readTransport(reader));
                break;
            }
            case (8): {
                System.out.println("Поиск по типу путевки, виду транспорта, виду питания, количеству дней:");
                tpGenerator.searchByTypeTransportNutritionNumberDays(readType(reader), readTransport(reader),
                        readNutrition(reader), readIntervalNumberDays(reader));
                break;
            }
            default: {
                System.out.println("Динамический поиск:");
                dynamicSearch(tpGenerator, reader);
                break;
            }
        }
    }

    //Динамический поиск путевок по порядку: отдых -> трансорт -> питание -> количестов дней (интервал) с выводом на экран
    //Сортировка по стране назначения (country)
    public static void dynamicSearch(TouristPackageGenerator tpGenerator, BufferedReader reader) throws IOException {
        List<TouristPackage> listType = tpGenerator.searchByType(readType(reader));
        if (listType.size() != 0) {
            TouristPackage[] tpTypeList = (TouristPackage[]) listType.toArray(new TouristPackage[0]);
            TouristPackageGenerator tpType = new TouristPackageGenerator(tpTypeList);
            List<TouristPackage> listTransport = tpType.searchByTransport(readTransport(reader));
            if (listTransport.size() != 0) {
                TouristPackage[] tpTransportList = (TouristPackage[]) listTransport.toArray(new TouristPackage[0]);
                TouristPackageGenerator tpTransport = new TouristPackageGenerator(tpTransportList);
                List<TouristPackage> listNutrition = tpTransport.searchByNutrition(readNutrition(reader));
                if (listNutrition.size() != 0) {
                    TouristPackage[] tpNumberDaysList = (TouristPackage[]) listNutrition.toArray(new TouristPackage[0]);
                    TouristPackageGenerator tpNumberDays = new TouristPackageGenerator(tpNumberDaysList);
                    List<TouristPackage> listNumbersDays = tpNumberDays.searchByNumberDaysInterval(readIntervalNumberDays(reader));
                }
            }
        }
    }

    //ввод страны назначения для поиска
    public static String readCountry(BufferedReader reader) throws IOException {
        System.out.print("Введите страну назначения: ");
        String country = reader.readLine();
        return country;
    }

    //ввод пункта назначения для поиска
    public static String readLocality(BufferedReader reader) throws IOException {
        System.out.print("Введите населенный пункт: ");
        String locality = reader.readLine();
        return locality;
    }

    //ввод типа путевки для поиска
    public static String readType(BufferedReader reader) throws IOException {
        System.out.print("Введите тип путевки: ");
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
        System.out.print("Введите вид транспорта: ");
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
        System.out.print("Введите вид питания: ");
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
                System.out.print("Введите количество дней: ");
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
                System.out.print("Введите интервал дней:\nот ");
                numberDays[0] = Integer.parseInt(reader.readLine());
                System.out.print("до ");
                numberDays[1] = Integer.parseInt(reader.readLine());
                if (numberDays[0] > numberDays[1]) {
                    System.out.println("Интервал дней введен некорректно. Попробуйте еще раз!");
                    test = true;
                } else {
                    test = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                test = true;
            }
        }
        return numberDays;
    }

    //проверка введенного числа
    public static int testReadNumber(BufferedReader reader) throws IOException {
        int num = 0;
        boolean test = true;
        while (test) {
            try {
                num = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Число введено некорректно: " + e);
                System.out.print("Попробуйте еще раз: ");
                test = true;
            }
        }
        return num;
    }
}
