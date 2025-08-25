package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterContainerService {

    //stworz metody ktore pozwalaja:
    //- znalezc zbiornik w ktorym jest najwiecej wody
    //- znalezc zbiornik ktory jest najbardziej zapelniony
    //- znalezc wszystkie puste zbiorniki.

    public static WaterContainer findContainerWithTheBiggestWaterAmount(List<WaterContainer> list){
        if (list == null) {
            list = Collections.emptyList();
        }
        WaterContainer wc = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).getWaterLevel() > wc.getWaterLevel()){
              wc = list.get(i);
            }
        }
        return wc;
    }

    public static WaterContainer findMostFilledContainer(List<WaterContainer> list){
        WaterContainer mostFilledContainer = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).getFillingRatio() > mostFilledContainer.getFillingRatio()){
                mostFilledContainer = list.get(i);
            }
        }
        return mostFilledContainer;
    }

    public static List<WaterContainer> findEmptyContainers(List<WaterContainer> list){
        List<WaterContainer> emtpyContainersList = Collections.emptyList();
        for (WaterContainer waterContainer : list){
            if (waterContainer.getWaterLevel() == 0){
                emtpyContainersList.add(waterContainer);
            }
        }
        return emtpyContainersList;
    }

}
