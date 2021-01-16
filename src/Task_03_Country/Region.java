package Task_03_Country;

/*
Параметры: название, областной центр, районы
Методы: вычисление площади, вычисление населения
 */

import java.util.Arrays;

public class Region {
    private String name;
    private City cityCenter;
    private District[] district;
    private Country country;

    public Region() {
    }

    public Region(String name, City cityCenter, District... district) {
        this.name = name;
        this.cityCenter = cityCenter;
        this.district = district;
    }

    public Region(String name, City cityCenter, Country country, District... district) {
        this.name = name;
        this.cityCenter = cityCenter;
        this.country = country;
        this.district = district;
    }

    //вычисление площади области
    public double areaRegion() {
        double area = 0;
        for (District distr : district) {
            area += distr.getArea();
        }
        return area;
    }

    //вычисление количества населения
    public int numberPopulationRegion() {
        int numPopulation = 0;
        for (District distr : district) {
            numPopulation += distr.getPopulation();
        }
        return numPopulation;
    }

    //Добавление нового района
    public District[] addDistrict(District... districtAdd) {
        District[] districtTemp = Arrays.copyOf(this.district, this.district.length + districtAdd.length);
        System.arraycopy(districtAdd, 0, districtTemp, this.district.length, districtAdd.length);
        return this.district = districtTemp;
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

    public District[] getDistrict() {
        return district;
    }

    public void setDistrict(District... district) {
        this.district = district;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": областной центр  - '" + cityCenter.getName() +
                "', площадь - " + areaRegion() +
                " кв. км., наcеление - " + numberPopulationRegion() + " чел.";
    }
}
