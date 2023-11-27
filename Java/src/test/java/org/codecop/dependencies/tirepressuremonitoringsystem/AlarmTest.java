package org.codecop.dependencies.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AlarmTest {

    @Test
    public void foo() {
        TirePressureMonitoringAlarm_ alarm = new TirePressureMonitoringAlarm_();
        assertFalse(alarm.isAlarmOn());
    }
}
