package org.codecop.dependencies.tirepressuremonitoringsystem;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AlarmTest {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }
}
