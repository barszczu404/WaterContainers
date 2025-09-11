package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainerOperation;
import pl.kurs.watercontainers.models.WaterContainer;

import java.util.ArrayList;
import java.util.List;

public class WaterContainerService {

    //stworz metody ktore pozwalaja:
    //- znalezc zbiornik w ktorym jest najwiecej wody
    //- znalezc zbiornik ktory jest najbardziej zapelniony
    //- znalezc wszystkie puste zbiorniki.

    public static WaterContainer findContainerWithTheBiggestWaterAmount(List<WaterContainer> list){
        if (list == null) {
          return null;
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
        if (list == null){
            return null;
        }
        WaterContainer mostFilledContainer = list.get(0);
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).getFillingRatio() > mostFilledContainer.getFillingRatio()){
                mostFilledContainer = list.get(i);
            }
        }
        return mostFilledContainer;
    }

    public static List<WaterContainer> findEmptyContainers(List<WaterContainer> list){
        if (list == null){
            return null;
        }
        List<WaterContainer> emtpyContainersList = new ArrayList<>();

        for (WaterContainer waterContainer : list){
            if (waterContainer.getWaterLevel() == 0){
                emtpyContainersList.add(waterContainer);
            }
        }
        return emtpyContainersList;
    }

    //Należy zaimplementować taką funkcjonalność oraz dodatkowo stworzyć metody które:
    //- pozwalają znaleźć zbiornik na którym było najwiecej operacji zakonczonych niepowodzeniem

    public static WaterContainer getContainerWithMostUnsuccessfulOperations(List<WaterContainer> list) {
        if (list == null){
            return null;
        }
        WaterContainer worstContainer = null;
        int counter = 0;
        for (int i = 0; i < list.size(); i++){
            int unsuccessfulOperations = 0;
            for (WaterContainerOperation waterContainerOperation : list.get(i).getOperations()){
                if (!waterContainerOperation.isOperationSucceeded()){
                    unsuccessfulOperations++;
                }
            }
            if (unsuccessfulOperations > counter) {
                counter = unsuccessfulOperations;
                worstContainer = list.get(i);
            }

        }
        return worstContainer;
    }

    //- pozwalają znaleźć zbiornik w którym było najwięcej operacji danego typu (typ podajemy jako argument metody)
    public static WaterContainer getContainerWithMostSpecificOperationType(List<WaterContainer> list, WaterContainerOperation.OperationType operationType){
        if (list == null){
            return null;
        }
        int counter = 0;
        WaterContainer containerWithMostOperationChosenType = null;
        for (int i = 0; i < list.size(); i++){
            int chosenTypeOperationCounter = 0;
            for (WaterContainerOperation waterContainerOperation : list.get(i).getOperations()){
                if (waterContainerOperation.getOperationType() == operationType) {
                    chosenTypeOperationCounter++;
                }
            }
            if (chosenTypeOperationCounter > counter){
                counter = chosenTypeOperationCounter;
                containerWithMostOperationChosenType = list.get(i);
            }
        }
        return containerWithMostOperationChosenType;
    }
}
