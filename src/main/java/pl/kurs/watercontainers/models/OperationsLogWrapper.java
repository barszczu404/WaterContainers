package pl.kurs.watercontainers.models;

import java.sql.Timestamp;
import java.time.Instant;

public class OperationsLogWrapper {

    //dla każdej operacji pamiętamy: datę i czas jej wykonania, jej nazwę, zbiornik na którym była ona wykonana oraz ilość wody jaka była brana
    // pod uwagę, oraz to czy operacja się powiodła czy nie.

    private Timestamp timestamp;
    private WaterContainerOperations operationName;
    private WaterContainer waterContainer;
    private double waterTriedToPour;
    private boolean isOperationSucceeded;

    public OperationsLogWrapper(WaterContainerOperations waterContainerOperations) {
        this.timestamp = Timestamp.from(Instant.now());
        this.operationName = WaterContainerOperations.valueOf(waterContainerOperations.toString());
        this.waterContainer = waterContainer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public WaterContainerOperations getOperationName() {
        return operationName;
    }

    public void setOperationName(WaterContainerOperations operationName) {
        this.operationName = operationName;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
    }

    public void setWaterContainer(WaterContainer waterContainer) {
        this.waterContainer = waterContainer;
    }

    public double getWaterTriedToPour() {
        return waterTriedToPour;
    }

    public void setWaterTriedToPour(double waterTriedToPour) {
        this.waterTriedToPour = waterTriedToPour;
    }

    public boolean isOperationSucceeded() {
        return isOperationSucceeded;
    }

    public void setOperationSucceeded(boolean operationSucceeded) {
        isOperationSucceeded = operationSucceeded;
    }

    @Override
    public String toString() {
        return "OperationsLogWrapper{" +
                "timestamp=" + timestamp +
                ", operationName='" + operationName + '\'' +
                ", waterContainer=" + waterContainer.getName() +
                ", waterTriedToPour=" + waterTriedToPour +
                ", isOperationSucceeded=" + (isOperationSucceeded ? "powiodła się" : "nie powiodła się") +
                '}';
    }
}
