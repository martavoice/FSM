package com.maltseva.marta.fsm;

/**
 * Created by Марта on 22.02.2018.
 */
public enum State {

    ALARM_DISARMED_ALL_UNLOCKED("AlarmDisarmed AllUnlocked"), ALARM_DISARMED_ALL_LOCKED("AlarmDisarmed AllLocked"),
    ALARM_DISARMED_DRIVER_UNLOCKED("AlarmDisarmed DriverUnlocked"), ALARM_ARMED_ALL_LOCKED("AlarmArmed AllLocked");
    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
