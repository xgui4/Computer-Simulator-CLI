package net.xgui4.Hardware.ComputerType;

import net.xgui4.Hardware.Component.Motherboard;
import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.PowerComponent;
import net.xgui4.Software.OperatingSystem.OperatingSystem;

public class ComputerFactory {
    public Computer createComputer(ComputerType type, PowerComponent powerComponent, String name, Motherboard motherboard, OperatingSystem system) {
        return switch (type) {
            case LAPTOP -> new Laptop(name, system, motherboard, powerComponent);

            case DESKTOP -> new Desktop(name, system, motherboard, powerComponent);
        };
    }
}