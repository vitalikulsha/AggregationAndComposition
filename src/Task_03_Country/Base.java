package Task_03_Country;

class Base {
    //Города
    //Брестская область
    static City brest = new City("Брест", 146.12, 340000, true, false);
    static City pinsk = new City("Пинск", 47.36, 126000, false, false);
    static City baranovichi = new City("Барановичи", 84.96, 175000, false, false);
    //Витебская область
    static City vitebsk = new City("Витебск", 134.6, 365000, true, false);
    static City braslav = new City("Браслав", 2.28, 10000, false, false);
    static City lepel = new City("Лепель", 17.2, 18000, false, false);
    //Гомельская область
    static City gomel = new City("Гомель", 139.77, 510000, true, false);
    static City mozyr = new City("Мозырь", 44.18, 111000, false, false);
    static City svetlogorsk = new City("Светлогорск", 25.86, 65000, false, false);
    //Гродненская область
    static City grodno = new City("Гродно", 142.11, 357000, true, false);
    static City lida = new City("Лида", 45.79, 103000, false, false);
    static City shchuchin = new City("Щучин", 15.45, 16000, false, false);
    //Минская область
    static City minsk = new City("Минск", 348.84, 2000000, true, true);
    static City smolevichi = new City("Смолевичи", 16.45, 17000, false, false);
    static City borisov = new City("Борисов", 46.0, 130000, false, false);
    static City logoisk = new City("Логойск", 15.13, 15000, false, false);
    //Могилевская область
    static City mogilev = new City("Могилев", 118.5, 357000, true, false);
    static City bobruisk = new City("Бобруск", 96.4, 212000, false, false);
    static City osipovichi = new City("Осиповичи", 20.32, 30000, false, false);
    //Районы
    //Брестская область
    static District brestDistr = new District("Брестский район", 1544.11, 383000, brest);
    static District pinskDistr = new District("Пинский район", 3252.77, 172000, pinsk);
    static District baranovichiDistr = new District("Барановичский район", 2171.88, 205000, baranovichi);
    //Витебская область
    static District vitebskDistr = new District("Витебский район", 2737, 402000, vitebsk);
    static District braslavDistr = new District("Браславский район", 2270.07, 35000, braslav);
    static District lepelDistr = new District("Лепельский район", 1822.22, 51000, lepel);
    //Гомельская область
    static District gomelDistr = new District("Гомельский район", 1951.4, 578000, gomel);
    static District mozyrDiste = new District("Мозырьский район", 1603.47, 133000, mozyr);
    static District svetlogorskDistr = new District("Светлогорский район", 1899.91, 83000, svetlogorsk);
    //Гродненская область
    static District grodnoDistr = new District("Гродненский район", 2594.05, 407000, grodno);
    static District lidaDistr = new District("Лидский район", 1566.74, 132000, lida);
    static District shchuchinDaistr = new District("Щучинский район", 1911.54, 40000, shchuchin);
    //Минская область
    static District minskDistr = new District("Минский район", 2251.5, 2215000, minsk);
    static District smolevichiDistr = new District("Смолевичский район", 1394.14, 46000, smolevichi);
    static District logoiskDistr = new District("Логойский район", 2365.02, 35000, logoisk);
    static District borisovDistr = new District("Борисовский район", 2987.63, 180000, borisov);
    //Могилевская область
    static District mogilevDistr = new District("Могилевский район", 1895.4, 397000, mogilev);
    static District bobruiskDistr = new District("Бобруйский район", 1599.05, 228000, bobruisk);
    static District osipovichiDistr = new District("Осиповичский район", 1947.21, 48000, osipovichi);
    //Области
    static Region brestRegion = new Region("Брестская область", brestDistr, baranovichiDistr, pinskDistr);
    static Region vitebskRegion = new Region("Витебская область", vitebskDistr, brestDistr, lepelDistr);
    static Region gomelRegion = new Region("Гомельская область", gomelDistr, mozyrDiste, svetlogorskDistr);
    static Region grodnoRegion = new Region("Гродненская область", grodnoDistr, lidaDistr, shchuchinDaistr);
    static Region minskRegion = new Region("Минская область", minskDistr, smolevichiDistr, borisovDistr, logoiskDistr);
    static Region mogilevRegion = new Region("Могилевская область", mogilevDistr, bobruiskDistr, osipovichiDistr);
    static Region[] regions = {brestRegion, vitebskRegion, gomelRegion, grodnoRegion, minskRegion, mogilevRegion};
}
