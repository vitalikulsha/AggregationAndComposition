package Task_03_Country;

/*
Параметры класса: название, площадь, население
 */
public class City {
    private String name;
    private double areaCity;
    private int populationCity;
    private District district;

    public City() {
    }

    public City(String name, double areaCity, int populationCity) {
        this.name = name;
        this.areaCity = areaCity;
        this.populationCity = populationCity;
    }

    public City(String name, double areaCity, int populationCity, District district) {
        this.name = name;
        this.areaCity = areaCity;
        this.populationCity = populationCity;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }


    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": площадь - " + areaCity + " кв. км." +
                ", население - " + populationCity + " чел." +
                ", '" + district.getName() + '\'';
    }
}
