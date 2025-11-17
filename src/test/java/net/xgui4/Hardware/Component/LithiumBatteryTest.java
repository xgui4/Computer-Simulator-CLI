package net.xgui4.Hardware.Component;

import net.xgui4.Hardware.Component.Power.Battery;
import net.xgui4.Hardware.Component.Power.LithiumBattery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LithiumBatteryTest {
    private final static String BATTERY_MANUFACTURER = "Battery Manufacturer";
    private final static String BATTERY_MODEL = "Battery Model";
    private final static String BATTERY_NAME = "Battery Name";
    private final static int BATTERY_CAPACITY = 5;
    private final static int BATTERY_CAPACITY_THRESHOLD = 5;

    private Battery lithiumBattery;

    @BeforeEach
    void setUp() {
        lithiumBattery = new LithiumBattery(BATTERY_MANUFACTURER, BATTERY_MODEL, BATTERY_NAME, BATTERY_CAPACITY, BATTERY_CAPACITY_THRESHOLD);
    }

    @Test
    void getCapacity() {
        // act
        int output = lithiumBattery.getCapacity();

        // assert
        assertEquals(output, BATTERY_CAPACITY);
    }

    @Test
    void getModel() {
        // act
        String output = lithiumBattery.getModel();

        // assert
        assertEquals(output, BATTERY_MODEL);
    }

    @Test
    void getName() {
        // act
        String output = lithiumBattery.getModel();

        // assert
        assertEquals(output, BATTERY_MODEL);
    }

    @Test
    void getManufacturer() {
    }

    @Test
    void getSummary() {
    }

    @Test
    void degradeHealth() {
    }

    @Test
    void testGetSummary() {
    }

    @Test
    void inflate() {
    }

    @Test
    void getLithiumBatteryStatus() {
    }

    @Test
    void testToString() {
    }
}