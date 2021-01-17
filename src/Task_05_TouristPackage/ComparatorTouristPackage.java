package Task_05_TouristPackage;

import java.util.Comparator;

public class ComparatorTouristPackage {
    //Сортировка: страна->пункт назначения->тип->транспорт->питание->количество дней
    public static Comparator<TouristPackage> SortCountry = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getCountry().compareTo(tp2.getCountry());
            if (compareResult == 0) {
                compareResult = tp1.getLocality().compareTo(tp2.getLocality());
                if (compareResult == 0) {
                    compareResult = tp1.getType().compareTo(tp2.getType());
                    if (compareResult == 0) {
                        compareResult = tp1.getTransport().compareTo(tp2.getTransport());
                        if (compareResult == 0) {
                            compareResult = tp2.getNutrition().compareTo(tp2.getNutrition());
                            if (compareResult == 0) {
                                compareResult = tp1.getNumberDays() - tp2.getNumberDays();
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };

    //Сортировка: пункт назначения->страна->тип->транспорт->питание->количество дней
    public static Comparator<TouristPackage> SortLocality = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getLocality().compareTo(tp2.getLocality());
            if (compareResult == 0) {
                compareResult = tp1.getCountry().compareTo(tp2.getCountry());
                if (compareResult == 0) {
                    compareResult = tp1.getType().compareTo(tp2.getType());
                    if (compareResult == 0) {
                        compareResult = tp1.getTransport().compareTo(tp2.getTransport());
                        if (compareResult == 0) {
                            compareResult = tp2.getNutrition().compareTo(tp2.getNutrition());
                            if (compareResult == 0) {
                                compareResult = tp1.getNumberDays() - tp2.getNumberDays();
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };

    //Сортировка: тип->страна->пункт назначения->транспорт->питание->количество дней
    public static Comparator<TouristPackage> SortType = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getType().compareTo(tp2.getType());
            if (compareResult == 0) {
                compareResult = tp1.getCountry().compareTo(tp2.getCountry());
                if (compareResult == 0) {
                    compareResult = tp1.getLocality().compareTo(tp2.getLocality());
                    if (compareResult == 0) {
                        compareResult = tp1.getTransport().compareTo(tp2.getTransport());
                        if (compareResult == 0) {
                            compareResult = tp2.getNutrition().compareTo(tp2.getNutrition());
                            if (compareResult == 0) {
                                compareResult = tp1.getNumberDays() - tp2.getNumberDays();
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };

    //Сортировка: транспорт->страна->пункт назначения->тип->питание->количество дней
    public static Comparator<TouristPackage> SortTransport = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getTransport().compareTo(tp2.getTransport());
            if (compareResult == 0) {
                compareResult = tp1.getCountry().compareTo(tp2.getCountry());
                if (compareResult == 0) {
                    compareResult = tp1.getLocality().compareTo(tp2.getLocality());
                    if (compareResult == 0) {
                        compareResult = tp1.getType().compareTo(tp2.getType());
                        if (compareResult == 0) {
                            compareResult = tp2.getNutrition().compareTo(tp2.getNutrition());
                            if (compareResult == 0) {
                                compareResult = tp1.getNumberDays() - tp2.getNumberDays();
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };

    //Сортировка: питание->страна->пункт назначения->тип->транспорт->количество дней
    public static Comparator<TouristPackage> SortNutrition = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getNutrition().compareTo(tp2.getNutrition());
            if (compareResult == 0) {
                compareResult = tp1.getCountry().compareTo(tp2.getCountry());
                if (compareResult == 0) {
                    compareResult = tp1.getLocality().compareTo(tp2.getLocality());
                    if (compareResult == 0) {
                        compareResult = tp1.getType().compareTo(tp2.getType());
                        if (compareResult == 0) {
                            compareResult = tp2.getTransport().compareTo(tp2.getTransport());
                            if (compareResult == 0) {
                                compareResult = tp1.getNumberDays() - tp2.getNumberDays();
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };

    //Сортировка: количество дней->страна->пункт назначения->тип->транспорт->питание
    public static Comparator<TouristPackage> SortNumberDays = new Comparator<TouristPackage>() {
        @Override
        public int compare(TouristPackage tp1, TouristPackage tp2) {
            int compareResult = tp1.getNumberDays() - tp2.getNumberDays();
            if (compareResult == 0) {
                compareResult = tp1.getCountry().compareTo(tp2.getCountry());
                if (compareResult == 0) {
                    compareResult = tp1.getLocality().compareTo(tp2.getLocality());
                    if (compareResult == 0) {
                        compareResult = tp1.getType().compareTo(tp2.getType());
                        if (compareResult == 0) {
                            compareResult = tp2.getTransport().compareTo(tp2.getTransport());
                            if (compareResult == 0) {
                                compareResult = tp1.getNutrition().compareTo(tp2.getNutrition());
                            }
                        }
                    }
                }
            }
            return compareResult;
        }
    };
}
