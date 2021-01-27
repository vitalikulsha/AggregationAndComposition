package Task_03_Country;

/*
Параметры: название, список районов
Методы: вычисление площади, вычисление населения
 */

public class Region {
    private String name;
    private District[] districts;

    public Region(String name, District... districts) {
        this.name = name;
        this.districts = districts;
    }

    //вычисление площади области
    public double areaRegion() {
        double area = 0;
        for (District distr : districts) {
            area += distr.getArea();
        }
        return area;
    }

    //вычисление количества населения
    public int numberPopulationRegion() {
        int numPopulation = 0;
        for (District distr : districts) {
            numPopulation += distr.getPopulation();
        }
        return numPopulation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District... districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return '\'' + name + '\'' +
                ": площадь - " + areaRegion() +
                " кв. км., наcеление - " + numberPopulationRegion() + " чел.";
    }
}
