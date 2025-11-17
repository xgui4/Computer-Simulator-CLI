package net.xgui4.Hardware.ComputerType;

import net.xgui4.Hardware.Component.Motherboard;
import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.PowerComponent;
import net.xgui4.Software.OperatingSystem.OperatingSystem;

/**
 * Cette classe abstraite représente un ordinateur portable (laptop)
 */
public class Laptop extends Computer {

    /**
     * Le contructeur d'un ordinateur portable
     *
     * @param powerComponent  : une batterie (l'interface powerComponent)
     * */
    public Laptop(String name, OperatingSystem system, Motherboard motherboard, PowerComponent powerComponent) {
        super(name, system, motherboard, powerComponent);
    }

    /**
     * Cette méthode abstraite permet de démarrer l'ordinateur
     */
    @Override
    public void powerOn() {
        setPowerOn();
        super.getOS().boot();
    }

    /**
     * Cette méthode abstraite permet d'éteindre l'ordinateur
     */
    @Override
    public void powerOff() {
        setPowerOff();
    }

    /**
     * Cette méthode permet de fermer le système d'exploitation et l'ordinateur correctement
     */
    @Override
    public void shutdown() {
        powerOff();
        super.getOS().shutdown();
    }

    @Override
    public void getInfo(Battery battery) {
        System.out.println(battery.getSummary());
    }
}
