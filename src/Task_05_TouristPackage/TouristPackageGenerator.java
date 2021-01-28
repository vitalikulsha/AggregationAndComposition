package Task_05_TouristPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Task 05
5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
  Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class TouristPackageGenerator {
    private TouristPackage[] touristPackages;

    public TouristPackageGenerator(TouristPackage... touristPackages) {
        this.touristPackages = touristPackages;
    }

    @Override
    public String toString() {
        if (this.touristPackages != null) {
            StringBuilder tpSet = new StringBuilder();
            for (TouristPackage tp : touristPackages) {
                tpSet.append(tp.toString() + ";\n");
            }
            return tpSet.toString();
        } else {
            return "Список туристических путевок пуст.";
        }
    }

    //вывод в консоль списка путевок отсортированных по country
    public void printSortedByCountry() {
        sortedByCountry();
        System.out.println("Туристические путевки отсортированы по стране назначения:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по locality
    public void printSortedByLocality() {
        sortedByLocality();
        System.out.println("Туристические путевки отсортированы по населенному пункту:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по type
    public void printSortedByType() {
        sortedByType();
        System.out.println("Туристические путевки отсортированы по типу путевки:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по transport
    public void printSortedByTransport() {
        sortedByTransport();
        System.out.println("Туристические путевки отсортированы по виду транспорта:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortedByNutrition() {
        sortedByNutrition();
        System.out.println("Туристические путевки отсортированы по виду питания:\n" + toString());
    }

    //вывод в консоль списка путевок отсортированных по nutrition
    public void printSortedByNumberDays() {
        sortedByNumberDays();
        System.out.println("Туристические путевки отсортированы по количеству дней:\n" + toString());
    }

    //Сортировка страна->пункт назначения->тип->транспорт->питание->количество дней
    public TouristPackage[] sortedByCountry() {
        Comparator<TouristPackage> tpComparator = new CountryComparator().thenComparing(new LocalityComparator()
                .thenComparing(new TypeComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Сортировка: пункт назначения->страна->тип->транспорт->питание->количество дней
    public TouristPackage[] sortedByLocality() {
        Comparator<TouristPackage> tpComparator = new LocalityComparator().thenComparing(new CountryComparator()
                .thenComparing(new TypeComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Сортировка: тип->страна->пункт назначения->транспорт->питание->количество дней
    public TouristPackage[] sortedByType() {
        Comparator<TouristPackage> tpComparator = new TypeComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TransportComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Сортировка транспорт->страна->пункт назначения->тип->питание->количество дней
    public TouristPackage[] sortedByTransport() {
        Comparator<TouristPackage> tpComparator = new TransportComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new NutritionComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Сортировка питание->страна->пункт назначения->тип->транспорт->количество дней
    public TouristPackage[] sortedByNutrition() {
        Comparator<TouristPackage> tpComparator = new NutritionComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new TransportComparator().thenComparing(new NumberDaysComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Сортировка количество дней->страна->пункт назначения->тип->транспорт->питание
    public TouristPackage[] sortedByNumberDays() {
        Comparator<TouristPackage> tpComparator = new NumberDaysComparator().thenComparing(new CountryComparator()
                .thenComparing(new LocalityComparator().thenComparing(new TypeComparator()
                        .thenComparing(new TransportComparator().thenComparing(new NutritionComparator())))));
        Arrays.sort(this.touristPackages, tpComparator);
        return this.touristPackages;
    }

    //Поиск и сортировка путевки по стране назначения
    public void searchByCountry(String country) {
        sortedByCountry();
        System.out.println("Список туристических путевок для страны назначения '" + country + "':");
        boolean search = true;
        for (TouristPackage tp : touristPackages) {
            if (country.equalsIgnoreCase(tp.getCountry())) {
                search = false;
                System.out.println(tp.toString());
            }
        }
        if (search) {
            System.out.println("Туристические путевки в страну назначения '" + country + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по пункту назначения
    public void searchByLocality(String locality) {
        sortedByLocality();
        System.out.println("Список туристических путевок для населенного пункта '" + locality + "':");
        boolean search = true;
        for (TouristPackage tp : touristPackages) {
            if (locality.equalsIgnoreCase(tp.getLocality())) {
                search = false;
                System.out.println(tp.toString());
            }
        }
        if (search) {
            System.out.println("Туристические путевки в населенный пункт '" + locality + "' не найдены.");
        }
    }

    //Поиск и сортировка путевки по типу путевки
    public List<TouristPackage> searchByType(String type) {
        sortedByType();
        System.out.println("Список туристических путевок для типа '" + type + "':");
        List<TouristPackage> listType = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
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
    public List<TouristPackage> searchByTransport(String transport) {
        sortedByTransport();
        System.out.println("Список туристических путевок для вида транспорта '" + transport + "':");
        List<TouristPackage> listTransport = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
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
    public List<TouristPackage> searchByNutrition(String nutrition) {
        sortedByNutrition();
        System.out.println("Список туристических путевок по виду питания '" + nutrition + "':");
        List<TouristPackage> listNutrition = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
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
    public void searchByNumberDays(int numberDays) {
        sortedByNumberDays();
        System.out.println("Список туристических путевок на '" + numberDays + "' дней отдыха:");
        boolean test = true;
        for (TouristPackage tp : touristPackages) {
            if (numberDays == tp.getNumberDays()) {
                test = false;
                System.out.println(tp.toString());
            }
        }
        if (test) {
            System.out.println("Туристические путевки на '" + numberDays + "' дней отдыха не найдены.");
        }
    }

    public List<TouristPackage> searchByNumberDaysInterval(int[] numberDays) {
        sortedByNumberDays();
        System.out.println("Список туристических путевок на [" + numberDays[0] + "-" + numberDays[1] + "] дней отдыха:");
        List<TouristPackage> listNumberDays = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
            if (tp.getNumberDays() >= numberDays[0] && tp.getNumberDays() <= numberDays[1]) {
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
    public List<TouristPackage> searchByTypeTransportNutritionNumberDays(String type, String transport, String nutrition, int[] numberDays) {
        sortedByCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "', питание '" + nutrition + "', количество дней [" + numberDays[0] + "-" + numberDays[1] + "]:");
        List<TouristPackage> list = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
            if (type.equalsIgnoreCase(tp.getType()) && transport.equalsIgnoreCase(tp.getTransport()) &&
                    nutrition.equalsIgnoreCase(tp.getNutrition()) && tp.getNumberDays() >= numberDays[0]
                    && tp.getNumberDays() <= numberDays[1]) {

                System.out.println(tp.toString());
                list.add(tp);
            }
        }
        if (list.size() == 0) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
        return list;
    }

    //Поиск по типу отдыха, транспорту
    public List<TouristPackage> searchByTypeTransport(String type, String transport) {
        sortedByCountry();
        System.out.println("Список туристических путевок по следующим параметрам - тип '" + type + "', транспорт '" +
                transport + "':");
        List<TouristPackage> list = new ArrayList<>();
        for (TouristPackage tp : touristPackages) {
            if (type.equalsIgnoreCase(tp.getType()) && transport.equalsIgnoreCase(tp.getTransport())) {
                System.out.println(tp.toString());
                list.add(tp);
            }
        }
        if (list.size() == 0) {
            System.out.println("Туристические путевки c заданными параметрами не найдены.");
        }
        return list;
    }

    public TouristPackage[] getTouristPackages() {
        return touristPackages;
    }

    public void setTouristPackages(TouristPackage... touristPackages) {
        this.touristPackages = touristPackages;
    }
}
