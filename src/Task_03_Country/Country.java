package Task_03_Country;

import java.util.Arrays;

/*
Параметры: название, столица, области.
Методы: вычисление площади, вычисление населения, вывод в консоль: столицы,
количества областей, площади, областные центры
 */
public class Country {
    private String name;
    private City capital;
    private Region[] region;

    public Country() {
    }

    public Country(String name, City capital, Region... region) {
        this.name = name;
        this.capital = capital;
        this.region = region;
    }

    public double areaCountry() {
        double area = 0;
        for (Region reg : region) {
            area += reg.areaRegion();
        }
        return area;
    }

    public int numberPopulationCountry() {
        int numPopulation = 0;
        for (Region reg : region) {
            numPopulation += reg.numberPopulationRegion();
        }
        return numPopulation;
    }

    //вывод в консоль столицу государства
    public void printCapital() {
        System.out.println("Столица '" + name + "' - город " + capital.getName() + '.');
    }

    //вывод в консоль количества областей государства
    public void printNumberRegions() {
        System.out.println("Количество областей в '" + name + "' - " + region.length + '.');
    }

    //вывод в консоль площади государства
    public void printAreaCountry() {
        System.out.println("Площадь '" + name + "' - " + areaCountry() + " кв.км.");
    }

    //вывод в консоль название областных центров
    public void printRegionCenter() {
        System.out.println("Областные центры '" + name + "':");
        for (Region reg : region) {
            System.out.println(reg.getCityCenter().getName());
        }
    }

    //Добавление новой области
    public Region[] addRegion(Region... regionAdd) {
        Region[] regionTemp = Arrays.copyOf(this.region, this.region.length + regionAdd.length);
        System.arraycopy(regionAdd, 0, regionTemp, this.region.length, regionAdd.length);
        return this.region = regionTemp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Region[] getRegion() {
        return region;
    }

    public void setRegion(Region... region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": столица - " + capital.getName() +
                ", площадь - " + areaCountry() +
                " кв. км., население - " + numberPopulationCountry() + " чел.";
    }
}
