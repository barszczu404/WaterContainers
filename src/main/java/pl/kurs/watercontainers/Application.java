package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerService;

import java.util.ArrayList;
import java.util.List;

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
        WaterContainer mauzer1 = WaterContainer.create("mauzer", 1000, 400);
        WaterContainer konewka1 = WaterContainer.create("konewka", 5, 1);
        WaterContainer szklanka = WaterContainer.create("szklanka", 0.5, 0);
        WaterContainer wazon = WaterContainer.create("wazon", 0.75, 0);

       // beczka.addWater(80);
        mauzer1.pourWater(konewka1, 1);

        List<WaterContainer> list = new ArrayList<>();
        list.add(beczka);
        list.add(mauzer1);
        list.add(konewka1);
        list.add(szklanka);
        list.add(wazon);

        WaterContainer containerWithTheBiggestWaterAmount = WaterContainerService.findContainerWithTheBiggestWaterAmount(null);
        System.out.println("containerWithTheBiggestWaterAmount = " + containerWithTheBiggestWaterAmount);

        WaterContainer mostFilledContainer = WaterContainerService.findMostFilledContainer(list);
        System.out.println("mostFilledContainer = " + mostFilledContainer);

        WaterContainerService.findEmptyContainers(null);

    }
}
