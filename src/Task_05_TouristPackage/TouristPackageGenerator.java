package Task_05_TouristPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* Task 05
5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
  Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class TouristPackageGenerator {
    private TouristPackage[] touristPackage;

    public TouristPackageGenerator() {
    }

    public TouristPackageGenerator(TouristPackage... touristPackage) {
        this.touristPackage = touristPackage;
    }

    @Override
    public String toString() {
        if (this.touristPackage != null) {
            StringBuilder tpSet = new StringBuilder();
            for (TouristPackage tp : touristPackage) {
                tpSet.append(tp.toString() + ";\n");
            }
            return "Список туристических путевок:\n" + tpSet.toString();
        } else {
            return "Список туристических путевок пуст.";
        }
    }

    //вывод в консоль списка путевок отсортированных по country
    public void printSortCountry() {
        sortCountry();
        System.out.println("Туристические путевки упорядочены по стране назначения:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по locality
    public void printSortLocality() {
        sortLocality();
        System.out.println("Туристические путевки упорядочены по пункту назначения:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по type
    public void printSortType() {
        sortType();
        System.out.println("Туристические путевки упорядочены по типу путевки:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по transport
    public void printSortTransport() {
        sortTransport();
        System.out.println("Туристические путевки упорядочены по виду транспорта:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortNutrition() {
        sortNutrition();
        System.out.println("Туристические путевки упорядочены по виду питания:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortNumberDays() {
        sortNumberDays();
        System.out.println("Туристические путевки упорядочены по количеству дней:\n" + toString());
    }

    //Сортировка страна->пункт назначения->тип->транспорт->питание->количество дней
    public TouristPackage[] sortCountry() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortCountry);
        return this.touristPackage;
    }

    //Сортировка: пункт назначения->страна->тип->транспорт->питание->количество дней
    public TouristPackage[] sortLocality() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortLocality);
        return this.touristPackage;
    }

    //Сортировка: тип->страна->пункт назначения->транспорт->питание->количество дней
    public TouristPackage[] sortType() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortType);
        return this.touristPackage;
    }

    //Сортировка транспорт->страна->пункт назначения->тип->питание->количество дней
    public TouristPackage[] sortTransport() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortTransport);
        return this.touristPackage;
    }

    //Сортировка питание->страна->пункт назначения->тип->транспорт->количество дней
    public TouristPackage[] sortNutrition() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortNutrition);
        return this.touristPackage;
    }

    //Сортировка количество дней->страна->пункт назначения->тип->транспорт->питание
    public TouristPackage[] sortNumberDays() {
        Arrays.sort(this.touristPackage, ComparatorTouristPackage.SortNumberDays);
        return this.touristPackage;
    }

    //Динамический поиск путевок по порядку: отдых -> трансорт -> питание -> количестов дней (интервал) с выводом на экран
    public void dynamicSearch(BufferedReader reader) throws IOException {
        sortCountry();
        ArrayList<TouristPackage> list = new ArrayList<>();
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
        for (TouristPackage tp : touristPackage) {
            if (type.equalsIgnoreCase(tp.getType())) {
                System.out.println(tp.toString());
                list.add(tp);
            }
        }
        if (list.size() != 0) {
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
            ArrayList<TouristPackage> listTransport = new ArrayList<>();
            for (TouristPackage tp : list) {
                if (transport.equalsIgnoreCase(tp.getTransport())) {
                    listTransport.add(tp);
                    System.out.println(tp.toString());
                }
            }
            if (listTransport.size() != 0) {
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
                ArrayList<TouristPackage> listNutrition = new ArrayList<>();
                for (TouristPackage tp : listTransport) {
                    if (nutrition.equalsIgnoreCase(tp.getNutrition())) {
                        listNutrition.add(tp);
                        System.out.println(tp.toString());
                    }
                }
                if (listNutrition.size() != 0) {
                    int beginNumDays = 0;
                    int endNumDays = 0;
                    boolean test = true;
                    while (test) {
                        try {
                            System.out.print("Введите интервал дней отдых для подбора списка путевок:\nот ");
                            beginNumDays = Integer.parseInt(reader.readLine());
                            System.out.print("до ");
                            endNumDays = Integer.parseInt(reader.readLine());
                            test = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка! Количество дней введено некорректно: " + e);
                            test = true;
                        }
                    }
                    for (TouristPackage tp : listNutrition) {
                        if (tp.getNumberDays() >= beginNumDays && tp.getNumberDays() <= endNumDays) {
                            System.out.println(tp.toString());
                        }
                    }
                }
            }
        }
        System.out.println("Больше ничего не найдено, поиск окончен!");
    }

    //Поиск и сортировка путевки по стране назначения
    public void searchCountry(String countrySearch) {
        sortCountry();
        System.out.println("Список туристических путевок для страны назначения '" + countrySearch + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (countrySearch.equalsIgnoreCase(tp.getCountry())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки в страну назначения '" + countrySearch + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по пункту назначения
    public void searchLocality(String localitySearch) {
        sortLocality();
        System.out.println("Список туристических путевок для пункта назначения '" + localitySearch + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (localitySearch.equalsIgnoreCase(tp.getLocality())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки в пункт назначения '" + localitySearch + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по типу путевки
    public void searchType(String typeSearch) {
        sortType();
        System.out.println("Список туристических путевок для типа '" + typeSearch + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (typeSearch.equalsIgnoreCase(tp.getType())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки типа '" + typeSearch + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по виду транспорта
    public void searchTransport(String transportSearch) {
        sortTransport();
        System.out.println("Список туристических путевок для вида транспорта '" + transportSearch + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (transportSearch.equalsIgnoreCase(tp.getTransport())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки для вида транспорта '" + transportSearch + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по наличию питания
    public void searchNutrition(String nutritionSearch) {
        sortNutrition();
        System.out.println("Список туристических путевок по виду питания '" + nutritionSearch + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (nutritionSearch.equalsIgnoreCase(tp.getNutrition())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки по виду питания '" + nutritionSearch + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по количеству дней
    public void searchNumberDays(int numberDaysSearch) {
        sortNumberDays();
        System.out.println("Список туристических путевок на '" + numberDaysSearch + "' дней отдыха:");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (numberDaysSearch == tp.getNumberDays()) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки на '" + numberDaysSearch + "' дней отдыха не найдены.");
        }
    }

    //Поиск путевки по типу, транспорту, наличию питания и количеству деней (интервал)
    public void searchTypeTransportNutritionNumberDays(String type, String transport, String nutrition, int[] numberDays) {
        sortCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "', вид питания '" + nutrition + "', количество дней [" + numberDays[0] +
                " - " + numberDays[1] + "]:");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (type.equalsIgnoreCase(tp.getType()) && transport.equalsIgnoreCase(tp.getTransport()) &&
                    nutrition.equalsIgnoreCase(tp.getNutrition()) && tp.getNumberDays() >= numberDays[0]
                    && tp.getNumberDays() <= numberDays[1]) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
    }

    //Поиск по типу отдыха, транспорту
    public void searTypeTransport(String type, String transport) {
        sortCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (type.equalsIgnoreCase(tp.getType()) && transport.equalsIgnoreCase(tp.getTransport())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
    }

    public TouristPackage[] getTouristPackage() {
        return touristPackage;
    }

    public void setTouristPackage(TouristPackage... touristPackage) {
        this.touristPackage = touristPackage;
    }


}
