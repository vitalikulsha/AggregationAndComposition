package Task_03_Country;

import java.util.Arrays;

/*
Параметры: название, районный центр, площадь, население, районные города
 */
public class District {
    private String name;
    private City cityCenter;
    private double area;
    private int population;
    private Region region;
    private City[] city;

    public District() {
    }

    public District(String name, City cityCenter, double area, int population) {
        this.name = name;
        this.cityCenter = cityCenter;
        this.area = area;
        this.population = population;
        this.city = new City[]{cityCenter};
    }

    public District(String name, City cityCenter, double area, int population, Region region) {
        this.name = name;
        this.cityCenter = cityCenter;
        this.area = area;
        this.population = population;
        this.region = region;
        this.city = new City[]{cityCenter};
    }

    public District(String name, City cityCenter, double area, int population, Region region, City... city) {
        this.name = name;
        this.cityCenter = cityCenter;
        this.area = area;
        this.population = population;
        this.region = region;
        City[] cityTemp = Arrays.copyOf(city, city.length + 1);
        cityTemp[cityTemp.length - 1] = cityCenter;
        this.city = cityTemp;
    }

    public City[] addCity(City... cityAdd) {
        City[] cityTemp = Arrays.copyOf(this.city, this.city.length + cityAdd.length);
        System.arraycopy(cityAdd, 0, cityTemp, this.city.length, cityAdd.length);
        return this.city = cityTemp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCityCenter() {
        return cityCenter;
    }

    public void setCityCenter(City cityCenter) {
        this.cityCenter = cityCenter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public City[] getCity() {
        return city;
    }

    public void setCity(City... city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": районный центр - '" + cityCenter.getName() +
                "', площадь - " + area +
                ", население - " + population + " чел.";
    }
}
