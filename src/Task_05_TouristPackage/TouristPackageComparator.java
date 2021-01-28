package Task_05_TouristPackage;

import java.util.Comparator;

class CountryComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getCountry().compareTo(tp2.getCountry());
    }
}

class LocalityComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getLocality().compareTo(tp2.getLocality());
    }
}

class TypeComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getType().compareTo(tp2.getType());
    }
}

class TransportComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getTransport().compareTo(tp2.getTransport());
    }
}

class NutritionComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getNutrition().compareTo(tp2.getNutrition());
    }
}

class NumberDaysComparator implements Comparator<TouristPackage> {
    @Override
    public int compare(TouristPackage tp1, TouristPackage tp2) {
        return tp1.getNumberDays() - tp2.getNumberDays();
    }
}
