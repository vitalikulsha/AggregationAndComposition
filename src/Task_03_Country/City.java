package Task_03_Country;

/*
Параметры класса: название, площадь, население, столица, областной центр
 */
public class City {
    private String name;
    private double areaCity;
    private int populationCity;
    private boolean isRegionalCenter;
    private boolean isCapital;

    public City(String name, double areaCity, int populationCity, boolean isRegionalCenter, boolean isCapital) {
        this.name = name;
        this.areaCity = areaCity;
        this.populationCity = populationCity;
        this.isRegionalCenter = isRegionalCenter;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(double areaCity) {
        this.areaCity = areaCity;
    }

    public int getPopulationCity() {
        return populationCity;
    }

    public void setPopulationCity(int populationCity) {
        this.populationCity = populationCity;
    }

    public boolean getIsRegionalCenter() {
        return isRegionalCenter;
    }

    public void setRegionalCenter(boolean regionalCenter) {
        isRegionalCenter = regionalCenter;
    }

    public boolean getIsCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": площадь - " + areaCity + " кв. км." +
                ", население - " + populationCity + " чел.";
    }
}
