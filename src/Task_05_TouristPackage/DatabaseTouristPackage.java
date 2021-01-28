package Task_05_TouristPackage;

public class DatabaseTouristPackage {
    //список туристических путевок
    private static TouristPackage tp_00 = new TouristPackage("Украина", "Львов", "экскурсия", "автобус", "без питания", 3);
    private static TouristPackage tp_01 = new TouristPackage("Украина", "Львов", "экскурсия", "автобус", "завтрак", 5);
    private static TouristPackage tp_02 = new TouristPackage("Украина", "Хмельницкий", "шопинг", "автобус", "без питания", 3);
    private static TouristPackage tp_03 = new TouristPackage("Украина", "Чернигов", "шопинг", "автобус", "без питания", 2);
    private static TouristPackage tp_04 = new TouristPackage("Украина", "Буковель", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_05 = new TouristPackage("Беларусь", "Нарочь", "лечение", "автобус", "трехразовое", 14);
    private static TouristPackage tp_06 = new TouristPackage("Беларусь", "Гродненская обл.", "экскурсия", "автобус", "без питания", 1);
    private static TouristPackage tp_07 = new TouristPackage("Беларусь", "Витебск", "экскурсия", "поезд", "завтрак", 3);
    private static TouristPackage tp_08 = new TouristPackage("Польша", "Белосток", "шопинг", "автобус", "без питания", 2);
    private static TouristPackage tp_09 = new TouristPackage("Литва", "Вильнюс", "экскурсия", "поезд", "двухразовое", 4);
    private static TouristPackage tp_10 = new TouristPackage("Латвия", "Рига", "отдых", "автобус", "трехразовое", 9);
    private static TouristPackage tp_11 = new TouristPackage("Латвия", "Юрмала", "отдых", "поезд", "завтрак", 7);
    private static TouristPackage tp_12 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_13 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 14);
    private static TouristPackage tp_14 = new TouristPackage("Турция", "Аланья", "отдых", "самолет", "все включено", 5);
    private static TouristPackage tp_15 = new TouristPackage("Турция", "Анталия", "отдых", "самолет", "все включено", 11);
    private static TouristPackage tp_16 = new TouristPackage("Турция", "Анталия", "отдых", "самолет", "завтрак", 5);
    private static TouristPackage tp_17 = new TouristPackage("Италия", "Неаполь", "круиз", "самолет", "трехразовое", 7);
    private static TouristPackage tp_18 = new TouristPackage("Италия", "Генуя", "круиз", "самолет", "трехразовое", 5);
    private static TouristPackage tp_19 = new TouristPackage("Испания", "Барселона", "экскурсия", "самолет", "завтрак", 4);
    private static TouristPackage tp_20 = new TouristPackage("Северная Корея", "Пхеньян", "экскурсия", "поезд", "трехразовое", 5);
    static TouristPackage[] tpSet = new TouristPackage[]{tp_00, tp_01, tp_02, tp_03, tp_04, tp_05, tp_06, tp_07,
            tp_08, tp_09, tp_10, tp_11, tp_12, tp_13, tp_14, tp_15, tp_16, tp_17, tp_18, tp_19, tp_20};
}
