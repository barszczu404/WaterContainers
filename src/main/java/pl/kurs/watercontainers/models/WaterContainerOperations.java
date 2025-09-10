package pl.kurs.watercontainers.models;

import java.sql.Timestamp;

public enum WaterContainerOperations {

    ADD("add"),
    SUBTRACT("subtract");

    private final String name;

    WaterContainerOperations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}