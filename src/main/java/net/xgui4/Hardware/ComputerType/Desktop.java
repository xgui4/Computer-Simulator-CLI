package net.xgui4.Hardware.ComputerType;

import net.xgui4.Hardware.Component.Motherboard;
import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.PowerComponent;
import net.xgui4.Software.OperatingSystem.OperatingSystem;

public class Desktop extends Computer{
    /**
     * Le constructeur d'un ordinateur
     *
     * @param name        le nom de l'ordinateur
     * @param system      - le système d'exploitation de l'ordinateur
     * @param motherboard la carte mère et ces composants
     */
    public Desktop(String name, OperatingSystem system, Motherboard motherboard, PowerComponent powerComponent) {
        super(name, system, motherboard, powerComponent);
    }

    /**
     * @param battery
     */
    @Override
    public void getInfo(Battery battery) {

    }

    /**
     * Cette méthode abstraite permet de démarrer l'ordinateur
     */
    @Override
    public void powerOn() {
        super.setPowerOn();
    }

    /**
     * Cette méthode abstraite permet d'éteindre l'ordinateur
     */
    @Override
    public void powerOff() {
        super.setPowerOff();
    }

    /**
     * Cette méthode abstraite permet de fermer le système d'exploitation et l'ordinateur correctement
     */
    @Override
    public void shutdown() {
        setPowerOff();
    }
}
