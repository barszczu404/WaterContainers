package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

public class WaterContainer implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<WaterContainerOperation> operations = new ArrayList<>();

    private String name;
    private double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public static WaterContainer create(String name, double maxCapacity, double waterLevel) {
        if (maxCapacity <= 0) {
            throw new RuntimeException("maxCapacity musi być wieksza od 0!");
        } else if (waterLevel < 0) {
            throw new RuntimeException("waterLevel musi być wiekszy od 0");
        } else if (maxCapacity < waterLevel) {
            throw new RuntimeException("pojemność nie moze byc mniejsza niz ilosc wody!");
        } else {
            return new WaterContainer(name, maxCapacity, waterLevel);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public List<WaterContainerOperation> getOperations() {
        return Collections.unmodifiableList(operations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(maxCapacity, that.maxCapacity) == 0 && Double.compare(waterLevel, that.waterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }

    public void addWater(double value) {
        boolean isSuccess = false;
        if (value <= 0) {
            System.out.println("Wartosc powinna byc wieksza od 0");
        } else if (maxCapacity < waterLevel + value) {
            System.out.println("Za duzo wody aby ją dodać!");
        } else {
            waterLevel += value;
            isSuccess = true;

        }
        operations.add(new WaterContainerOperation(WaterContainerOperation.OperationType.ADD, this, value, isSuccess));
        //obiekt operacji ma sie tworzyc
    }

    public void subtractWater(double value) {
       boolean success = false;
        if (value <= 0) {
            System.out.println("Wartosc powinna byc wieksza od 0");
        } else if (waterLevel - value < 0) {
            System.out.println("Za duzo wody do odlania");
        } else {
            waterLevel -= value;
            success = true;
        }
        operations.add(new WaterContainerOperation(WaterContainerOperation.OperationType.SUBTRACT, this, value, success));
    }

    private boolean addIsPossible(double value) {
        return waterLevel + value <= maxCapacity;
    }

    private boolean subtractIsPossible(double value) {
        return waterLevel - value >= 0;
    }

    public void pourWater(WaterContainer sourceContainer, double value) {
        if (this.addIsPossible(value) && sourceContainer.subtractIsPossible(value)) {
            sourceContainer.subtractWater(value);
            this.addWater(value);
        } else {
            System.out.println("Niemożliwe wykonanie operacji przelania wody");
        }
    }

    public double getFillingRatio() {
        return waterLevel / maxCapacity;
    }
    //on ma wiedziec ile operacji robil, liste operacji czy sie powiodly

}
