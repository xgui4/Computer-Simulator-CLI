package net.xgui4.Hardware.ComputerType;

import net.xgui4.Hardware.Component.Motherboard;
import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.PowerComponent;
import net.xgui4.Hardware.PowerState;
import net.xgui4.Software.OperatingSystem.OperatingSystem;

/**
 * Cette classe abstraite représente un ordinateur
 */
public abstract class Computer {
    /**
     * le nom de l'ordinateur
     */
    private String name;
    /**
     * la carte mère et ces composants
     */
    private Motherboard motherboard;
    /**
     * L'état d'alimentation de l'ordinateur (ON ou OFF)
     */
    private PowerState powerState;

    /**
     * L'unité d'alimentation de l'ordinateur
     */
    private PowerComponent powerComponent;

    /**
     * Le système d'exploitation de l'ordinateur
     */
    private OperatingSystem system;

    /**
     * Le constructeur d'un ordinateur
     * @param name le nom de l'ordinateur
     * @param system - le système d'exploitation de l'ordinateur
     * @param motherboard la carte mère et ces composants
     */
    public Computer(String name, OperatingSystem system, Motherboard motherboard, PowerComponent powerComponent) {
        this.name = name;
        this.system = system;
        this.motherboard = motherboard;
        this.powerComponent = powerComponent;
        powerState = PowerState.OFF;
    }

    /**
     * Cette méthode permet de démarrer l'ordinateur
     */
    public void setPowerOn() {
        powerState = PowerState.ON;
    }

    /**
     * Cette méthode permet d'éteindre l'ordinateur
     */
    public void setPowerOff() {
        powerState = PowerState.OFF;
    }

    /**
     * Démarrer l'ordinateur
     */
    public void boot() {
        powerOn();
    }

    /**
     * Recevoir l'info sur la battery (si disponible)
     * @param battery - une battery
     */
    public abstract void getInfo(Battery battery);

    /**
     * Cette méthode abstraite permet de démarrer l'ordinateur
     */
    public abstract void powerOn();

    /**
     * Cette méthode abstraite permet d'éteindre l'ordinateur
     */
    public abstract void powerOff();

    /**
     * Cette méthode abstraite permet de fermer le système d'exploitation et l'ordinateur correctement
     */
    public abstract void shutdown();

    /**
     * Le getter de l'état d'alimentation de l'ordinateur
     * @return l'état de l'ordinateur (Enum PowerState)
     */
    public PowerState getState() {
        return powerState;
    }

    /**
     * Le getter de l'unité d'alimentation
     * @return la battery si l'ordinateur possède une batterie (interface Battery)
     */
    public PowerComponent getPowerComponent() {
        return powerComponent;
    }


    protected OperatingSystem getOS() {
        return system;
    }
}
