package net.xgui4.Hardware.Component.Power;

public class PSU implements PowerComponent {
    private final String manufacturer;
    private final String model;
    private final String name;
    private int capacity;
    private final int healthCap ;
    public final static int NORMAL_USAGE_DAMAGE = 10;
    private PowerSupplyHealthStatus powerSupplyHeathStatus;

    public PSU(String manufacturer, String model, String name, int healthCap) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.healthCap = healthCap;
        powerSupplyHeathStatus = PowerSupplyHealthStatus.NEW;
    }

    /**
     * le getter de la capacité
     *
     * @return la capacité
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * Le getter de l'attribut modèle
     *
     * @return la string du model
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Le getter de l'attribut name
     *
     * @return le nom
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Le getter de l'attribut manufacturer
     *
     * @return le manufacturier
     */
    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Génère les détailles lisible de l'unité d'alimentation.
     *
     * @return les détailles de la batterie
     */
    @Override
    public String getSummary() {
        return "Manufacturer : " + getManufacturer() + "\n" +
                "Model : " + getModel() + "\n" +
                "Name : " + getName() + "\n" +
                "Capacity : " + getCapacity() + "\n";
    }

    /**
     * Réduit la santé de  l'unité d'alimentation.
     */
    @Override
    public void degradeHealth() {
        this.capacity =- NORMAL_USAGE_DAMAGE;
        powerSupplyHeathStatus = PowerSupplyHealthStatus.GOOD;
        if (capacity == healthCap) {
            powerSupplyHeathStatus = PowerSupplyHealthStatus.BAD;
        }
    }
}
