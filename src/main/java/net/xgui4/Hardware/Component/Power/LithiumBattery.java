package net.xgui4.Hardware.Component.Power;

/**
 * Cette classe représente une batterie en lithium
 */
public class LithiumBattery extends Battery {
    private final int capacityThreshold;
    private LithiumBatteryStatus lithiumBatteryStatus;

    /**
     * Le constructeur de batterie en lithium
     *
     * @param manufacturer      : le manufacturier
     * @param model             : le modèle
     * @param name              : le nom
     * @param capacity          : la capacité
     * @param capacityThreshold : la limite avant que la batterie devienne mauvaise
     */
    public LithiumBattery(String manufacturer, String model, String name, int capacity, int capacityThreshold) {
        super(manufacturer, model, name, capacity);
        lithiumBatteryStatus = new LithiumBatteryStatus(BatteryStatus.NEW);
        this.capacityThreshold = capacityThreshold;
    }

    /**
     * cette méthode permet de faire dégrader la batterie
     */
    @Override
    public void degradeHealth() {
        super.setCapacity(getCapacity() - 10);
        if (getCapacity() < capacityThreshold) {
            lithiumBatteryStatus = new LithiumBatteryStatus(BatteryStatus.BAD);
        }
    }

    /**
     * Génère les détailles lisible de la batterie.
     *
     * @return les détailles de la batterie
     */
    @Override
    public String getSummary() {
        return "Manufacturer : " + super.getManufacturer() + "\n" +
                "Model : " + super.getModel() + "\n" +
                "Name : " + super.getName() + "\n" +
                "Capacity : " + super.getCapacity() + "\n" +
                "Status : " + this.getLithiumBatteryStatus().getMessage();
    }

    /**
     * Cette méthode permet de rendre la batterie en spicy pillow
     */
    public void inflate() {
        lithiumBatteryStatus = new LithiumBatteryStatus(BatteryStatus.INFLATED);
    }

    /**
     * le getter du status de la batterie
     *
     * @return le status de la batterie en LithiumBatteryStatus
     */
    public LithiumBatteryStatus getLithiumBatteryStatus() {
        return lithiumBatteryStatus;
    }

    /**
     * Cette méthode est pour utilisation de débogage uniquement.
     *
     * @return Toutes les détailles de la batteries.
     */
    @Override
    public String toString() {
        return "LithiumBattery : " + "'" + super.toString() +
                "lithiumBatteryStatus=" + "'" + lithiumBatteryStatus + "'" + "," +
                "capacityThreshold=" + capacityThreshold;
    }
}
