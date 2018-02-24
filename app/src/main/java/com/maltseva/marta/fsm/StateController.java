package com.maltseva.marta.fsm;

import com.maltseva.marta.fsm.model.State;
import com.maltseva.marta.fsm.ui.MainActivity;

public class StateController implements StateChangedListener {
    private final MainActivity activity;

    public StateController(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void updateState(State position) {
        switch (position) {
            case ALARM_DISARMED_ALL_UNLOCKED:
                activity.setState(State.ALARM_DISARMED_ALL_UNLOCKED);
                break;
            case ALARM_DISARMED_ALL_LOCKED:
                activity.setState(State.ALARM_DISARMED_ALL_LOCKED);
                break;
            case ALARM_DISARMED_DRIVER_UNLOCKED:
                activity.setState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
                break;
            case ALARM_ARMED_ALL_LOCKED:
                activity.setState(State.ALARM_ARMED_ALL_LOCKED);
                break;
        }
    }
}
