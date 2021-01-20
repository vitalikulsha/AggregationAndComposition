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
            return tpSet.toString();
        } else {
            return "Список туристических путевок пуст.";
        }
    }

    //вывод в консоль списка путевок отсортированных по country
    public void printSortCountry() {
        sortCountry();
        System.out.println("Туристические путевки отсортированы по стране назначения:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по locality
    public void printSortLocality() {
        sortLocality();
        System.out.println("Туристические путевки отсортированы по населенному пункту:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по type
    public void printSortType() {
        sortType();
        System.out.println("Туристические путевки отсортированы по типу путевки:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по transport
    public void printSortTransport() {
        sortTransport();
        System.out.println("Туристические путевки отсортированы по виду транспорта:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortNutrition() {
        sortNutrition();
        System.out.println("Туристические путевки отсортированы по виду питания:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortNumberDays() {
        sortNumberDays();
        System.out.println("Туристические путевки отсортированы по количеству дней:\n" + toString());
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

    //Поиск и сортировка путевки по стране назначения
    public void searchCountry(String country) {
        sortCountry();
        System.out.println("Список туристических путевок для страны назначения '" + country + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (country.equalsIgnoreCase(tp.getCountry())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки в страну назначения '" + country + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по пункту назначения
    public void searchLocality(String locality) {
        sortLocality();
        System.out.println("Список туристических путевок для населенного пункта '" + locality + "':");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (locality.equalsIgnoreCase(tp.getLocality())) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки в населенный пункт '" + locality + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по типу путевки
    public ArrayList<TouristPackage> searchType(String type) {
        sortType();
        System.out.println("Список туристических путевок для типа '" + type + "':");
        ArrayList<TouristPackage> listType = new ArrayList<>();
        for (TouristPackage tp : touristPackage) {
            if (type.equalsIgnoreCase(tp.getType())) {
                listType.add(tp);
                System.out.println(tp.toString());
            }
        }
        if (listType.size() == 0) {
            System.out.println("Туристические путевки типа '" + type + "' не найдены.");
        }
        return listType;
    }

    //Поиск и сортировка путевки по виду транспорта
    public ArrayList<TouristPackage> searchTransport(String transport) {
        sortTransport();
        System.out.println("Список туристических путевок для вида транспорта '" + transport + "':");
        ArrayList<TouristPackage> listTransport = new ArrayList<>();
        for (TouristPackage tp : touristPackage) {
            if (transport.equalsIgnoreCase(tp.getTransport())) {
                System.out.println(tp.toString());
                listTransport.add(tp);
            }
        }
        if (listTransport.size() == 0) {
            System.out.println("Туристические путевки для вида транспорта '" + transport + "' не найдены.");
        }
        return listTransport;
    }

    //Поиск и сортировка путевки по наличию питания
    public ArrayList<TouristPackage> searchNutrition(String nutrition) {
        sortNutrition();
        System.out.println("Список туристических путевок по виду питания '" + nutrition + "':");
        ArrayList<TouristPackage> listNutrition = new ArrayList<>();
        for (TouristPackage tp : touristPackage) {
            if (nutrition.equalsIgnoreCase(tp.getNutrition())) {
                System.out.println(tp.toString());
                listNutrition.add(tp);
            }
        }
        if (listNutrition.size() == 0) {
            System.out.println("Туристические путевки по виду питания '" + nutrition + "' не найдены.");
        }
        return listNutrition;
    }

    //Поиск и сортировка путевки по количеству дней
    public void searchNumberDays(int numberDays) {
        sortNumberDays();
        System.out.println("Список туристических путевок на '" + numberDays + "' дней отдыха:");
        boolean test = true;
        for (TouristPackage tp : touristPackage) {
            if (numberDays == tp.getNumberDays()) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки на '" + numberDays + "' дней отдыха не найдены.");
        }
    }

    public ArrayList<TouristPackage> searchNumberDaysInterval(int[] numberDays) {
        sortNumberDays();
        System.out.println("Список туристических путевок на [" + numberDays[0] + "-" + numberDays[1] + "] дней отдыха:");
        //boolean test = true;
        ArrayList<TouristPackage> listNumberDays = new ArrayList<>();
        for (TouristPackage tp : touristPackage) {
            if (tp.getNumberDays() >= numberDays[0] && tp.getNumberDays() <= numberDays[1]) {
                //test = false;
                System.out.println(tp.toString());
                listNumberDays.add(tp);
            }
        }
        if (listNumberDays.size() == 0) {
            System.out.println("Туристические путевки на [" + numberDays[0] + "-" + numberDays[1] + "] дней отдыха не найдены.");
        }
        return listNumberDays;
    }

    //Поиск путевки по типу, транспорту, наличию питания и количеству деней (интервал)
    public void searchTypeTransportNutritionNumberDays(String type, String transport, String nutrition, int[] numberDays) {
        sortCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "', питание '" + nutrition + "', количество дней [" + numberDays[0] + "-" + numberDays[1] + "]:");
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
