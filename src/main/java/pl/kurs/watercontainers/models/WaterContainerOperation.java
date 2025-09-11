package pl.kurs.watercontainers.models;

import java.sql.Timestamp;
import java.time.Instant;

public class WaterContainerOperation {

    public enum OperationType {ADD, SUBTRACT;}

    //dla każdej operacji pamiętamy: datę i czas jej wykonania, jej nazwę, zbiornik na którym była ona wykonana oraz ilość wody jaka była brana
    // pod uwagę, oraz to czy operacja się powiodła czy nie.

    private final Timestamp timestamp;
    private final OperationType operationType;
    private final WaterContainer waterContainer;
    private final double waterAmount;
    private final boolean isOperationSucceeded;

    public WaterContainerOperation(OperationType operationType, WaterContainer waterContainer, double waterAmount, boolean isOperationSucceeded) {
        this.timestamp = Timestamp.from(Instant.now());
        this.operationType = operationType;
        this.waterContainer = waterContainer;
        this.waterAmount = waterAmount;
        this.isOperationSucceeded = isOperationSucceeded;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
    }


    public double getWaterAmount() {
        return waterAmount;
    }


    public boolean isOperationSucceeded() {
        return isOperationSucceeded;
    }


    @Override
    public String toString() {
        return "OperationsLogWrapper{" +
                "timestamp=" + timestamp +
                ", operationName='" + operationType + '\'' +
                ", waterContainer=" + waterContainer.getName() +
                ", waterTriedToPour=" + waterAmount +
                ", isOperationSucceeded=" + (isOperationSucceeded ? "powiodła się" : "nie powiodła się") +
                '}';
    }
}
