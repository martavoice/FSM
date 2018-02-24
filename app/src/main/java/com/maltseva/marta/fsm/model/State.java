package com.maltseva.marta.fsm.model;

/**
 * Created by Марта on 22.02.2018.
 */
public enum State {

    ALARM_DISARMED_ALL_UNLOCKED("AlarmDisarmed AllUnlocked", true), ALARM_DISARMED_ALL_LOCKED("AlarmDisarmed AllLocked", true),
    ALARM_DISARMED_DRIVER_UNLOCKED("AlarmDisarmed DriverUnlocked", true), ALARM_ARMED_ALL_LOCKED("AlarmArmed AllLocked", false);
    private final String value;

    public Boolean getIndicatorOn() {
        return isIndicatorOn;
    }

    private Boolean isIndicatorOn;

    State(String value, Boolean isIndicatorOn) {
        this.value = value;
        this.isIndicatorOn = isIndicatorOn;
    }

    public String getValue() {
        return value;
    }
}
