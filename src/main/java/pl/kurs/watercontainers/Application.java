package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;

public class Application {
    public static void main(String[] args) {
        //należy stworzyć następujące operacje:
        //- void dolanieWody(ile) - ale w zbiorniku nie moze byc wiecej wody niz wynosi pojemnosc
        //- void odlanieWody(ile) - ale nie możesz odlać więcej niż masz
        //- void przelanieWody(skad, ile) - przelewa wode ze zbiornika skąd do naszego (pod warunkiem, że przelew jest możliwy)
        //stworz metody ktore pozwalaja:
        //- znalezc zbiornik w ktorym jest najwiecej wody
        //- znalezc zbiornik ktory jest najbardziej zapelniony
        //- znalezc wszystkie puste zbiorniki.

        WaterContainer beczka = WaterContainer.create("beczka", 150, 100);
        WaterContainer mauzer1 = WaterContainer.create("mauzer", 1000, 900);
        WaterContainer konewka1 = WaterContainer.create("konewka", 5, 1);

       // beczka.addWater(80);
        mauzer1.pourWater(konewka1, 1);
    }
}
