package org.codecop.dependencies.tirepressuremonitoringsystem;

public class TirePressureMonitoringAlarm_ {
    
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    /*
     * The Sensor is real hardware and we cannot control it in testing.
     * What to do?
     */
    private TirePressureSensor sensor = new TirePressureSensor();
    private boolean alarmOn = false;

    public void check() {
        
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || 
            HighPressureThreshold < psiPressureValue) {
                alarmOn = true;
        }
        
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
