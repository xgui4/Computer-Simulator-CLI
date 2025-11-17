package net.xgui4.View;

import net.xgui4.Exception.WrongComputerTypeException;
import net.xgui4.Hardware.Component.Motherboard;
import net.xgui4.Hardware.Component.Power.LithiumBattery;
import net.xgui4.Hardware.Component.Power.PSU;
import net.xgui4.Hardware.Component.Power.PowerComponent;
import net.xgui4.Hardware.ComputerType.*;
import net.xgui4.Player;
import net.xgui4.Software.Firmware.UEFI;
import net.xgui4.Software.OperatingSystem.OperatingSystem;
import net.xgui4.Software.OperatingSystem.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class PlayButtonActionView implements ActionListener {
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ComputerFactory computerFactory = new ComputerFactory();

        String username = chooseUsername();

        ComputerType computerType = chooseComputer();

        Player player = new Player(username);

        Computer computer = buildComputer(computerType, computerFactory, player);

        player.chooseComputer(computer);

        player.play();

        player.analyse();

        player.quit();
    }

    private static String chooseUsername() {
        return JOptionPane.showInputDialog("Choose a Username");
    }

    private static ComputerType chooseComputer() {
        String input = JOptionPane.showInputDialog("Choose a Computer Type : Laptop or Desktop");

        if (input.equals("Laptop")) {
            return ComputerType.LAPTOP;
        }
        if (input.equals("Desktop")){
            return ComputerType.DESKTOP;
        }  
        else {
            JDialog dialog = new JDialog();
            dialog.add(new TextField("Invalid computer type, pls try again."));
            return chooseComputer();
        }
    }

    private static Computer buildComputer(ComputerType computerType, ComputerFactory computerFactory, Player player) {
        if (computerType == ComputerType.LAPTOP) {
            Motherboard laptopMotherboard = new Motherboard(new UEFI("Default Laptop UEFI", "OEM"));
            PowerComponent lithiumIonBattery = new LithiumBattery("OEM", "Basic Laptop Battery", "Basic Laptop Battery", 100, 10);
            OperatingSystem defaultSystem =  new Windows("Windows OEM Edition");
            return computerFactory.createComputer(computerType, lithiumIonBattery, "Default Laptop", laptopMotherboard, defaultSystem);
        }
        else if (computerType == ComputerType.DESKTOP) {
            Motherboard basicMotherboard = new Motherboard(new UEFI("Default Desktop UEFI", player.getUsername()));
            PowerComponent basicPSU = new PSU("Default PSU" , "Default PSU", "Default", 10);
            OperatingSystem defaultSystem =  new Windows("Windows Home Edition");
            return computerFactory.createComputer(computerType, basicPSU, "Default Laptop", basicMotherboard, defaultSystem);
        }
        throw new WrongComputerTypeException("Cannot build computer. Computer type " + computerType + " is invalid.");
    }
}
