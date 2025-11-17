package net.xgui4.Hardware.ComputerType;

import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.LithiumBattery;
import net.xgui4.Hardware.PowerState;
import net.xgui4.Software.Firmware.Firmware;
import net.xgui4.Software.Firmware.UEFI;
import net.xgui4.Software.OperatingSystem.OperatingSystem;
import net.xgui4.Software.OperatingSystem.Windows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopTest {

    private final static String DUMMY_BATTERY_MANUFACTURER = "Dummy Battery Manufacturer";
    private final static String DUMMY_BATTERY_MODEL = "Dummy Battery Model";
    private final static String DUMMY_BATTERY_NAME = "Dummy Battery Name";
    private final static int DUMMY_BATTERY_CAPACITY = 5;
    private final static int DUMMY_BATTERY_CAPACITY_THRESHOLD = 5;

    private Battery dummyBattery;

    private final static String DUMMY_FIRMWARE_MANUFACTURER = "Dummy Firmware Manufacturer";
    private final static String DUMMY_FIRMWARE_NAME = "Dummy Firmware Name";

    private Firmware dummyFirmware;

    private final static String DUMMY_OPERATING_SYSTEM_NAME = "Dummy Operating System Name";

    private OperatingSystem dummyOperatingSystem;

    private Computer netBook;

    @BeforeEach
    void setUp() {
        dummyBattery = new LithiumBattery(DUMMY_BATTERY_MANUFACTURER, DUMMY_BATTERY_MODEL, DUMMY_BATTERY_NAME, DUMMY_BATTERY_CAPACITY, DUMMY_BATTERY_CAPACITY_THRESHOLD);
        dummyFirmware = new UEFI(DUMMY_FIRMWARE_NAME, DUMMY_FIRMWARE_MANUFACTURER);
        dummyOperatingSystem = new Windows(DUMMY_OPERATING_SYSTEM_NAME);
        netBook = new Laptop(dummyBattery, dummyFirmware, dummyOperatingSystem);
    }

    @Test
    void setPowerOn() {
        // act
        netBook.setPowerOn();
        PowerState output = netBook.getState();

        // assert
        assertInstanceOf(PowerState.class, output);
        assertEquals(PowerState.ON, output);
    }

    @Test
    void setPowerOff() {
        // arrange
        netBook.setPowerOn();

        // act
        netBook.setPowerOff();
        PowerState output = netBook.getState();

        // assert
        assertInstanceOf(PowerState.class, output);
        assertEquals(PowerState.OFF, output);
    }

    @Test
    void getBattery() {
        // act
        Battery output = netBook.getBattery();

        // assert
        assertEquals(dummyBattery, output);
    }

    @Test
    void powerOn() {
        // act
        netBook.powerOn();
        PowerState output = netBook.getState();

        // assert
        assertInstanceOf(PowerState.class, output);
        assertEquals(PowerState.ON, output);
    }

    @Test
    void powerOff() {
        // act
        netBook.powerOff();
        PowerState output = netBook.getState();

        // assert
        assertInstanceOf(PowerState.class, output);
        assertEquals(PowerState.OFF, output);
    }

    @Test
    void shutdown() {
        // act
        netBook.shutdown();
        PowerState output = netBook.getState();

        // assert
        assertInstanceOf(PowerState.class, output);
        assertEquals(PowerState.OFF, output);
    }
}