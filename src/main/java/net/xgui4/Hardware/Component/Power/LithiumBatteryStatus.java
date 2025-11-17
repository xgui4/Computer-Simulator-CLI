package net.xgui4.Hardware.Component.Power;

/**
 * Cette classe représente le status des batteries de lithium
 */
public class LithiumBatteryStatus {
    private final BatteryStatus batteryStatus;

    /**
     * Le constructeur de status des batteries de lithium
     * @param batteryStatus -> L'enum BatterieStatus
     */
    public LithiumBatteryStatus(BatteryStatus batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    /**
     * Recevoir le message lié au status
     * @return le message lié au status
     */
    public String getMessage() {
        switch (batteryStatus) {
            case NEW -> {
                return "The battery is new";
            }
            case GOOD -> {
                return "The battery health is good";
            }
            case BAD -> {
                return "Warning : the battery is bad";
            }
            case INFLATED -> {
                return "Danger : the battery is inflated";
            }
            default -> {
                return "Le status de la Batterie est inconnue";
            }
        }
    }
}
