package com.maltseva.marta.fsm;

import java.util.List;

/**
 * Created by Марта on 21.02.2018.
 */

public class StateManager {
    public static final String LOCK = "lock";
    public static final String UNLOCK = "unlock";
    public static final String LOCKX2 = "lockx2";
    public static final String UNLOCKx2 = "unlockx2";
    private StateChangedListener stateListeners;
    private List<Action> actions;
    private State currentState;

    public StateManager(State lock, StateChangedListener view, List<Action> actions) {
        StateSaver.getInstance().setCurrentState(lock);
        this.stateListeners = view;
        this.actions = actions;
    }

    public void setEvent(String event) {
        State endState = getEndState(event);
        setCurrentState(endState);
        stateListeners.updateState(endState);
    }

    private State getEndState(String event) {
        if (actions != null) {
            for (Action action : actions) {
                if (action.getActionType().equals(event)) {
                    if (compareStartState(action.getStartState())) {
                        State endState = getStateFromValue(action.getEndState());
                        StateSaver.getInstance().setCurrentState(endState);
                        return endState;
                    }
                }
            }
        }
        return null;
    }

    private State getStateFromValue(String value) {
        if (State.ALARM_ARMED_ALL_LOCKED.getValue().equals(value)) {
            return State.ALARM_ARMED_ALL_LOCKED;
        } else if (State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue().equals(value)) {
            return State.ALARM_DISARMED_DRIVER_UNLOCKED;
        } else if (State.ALARM_DISARMED_ALL_LOCKED.getValue().equals(value)) {
            return State.ALARM_DISARMED_ALL_LOCKED;
        } else if (State.ALARM_DISARMED_ALL_UNLOCKED.getValue().equals(value)) {
            return State.ALARM_DISARMED_ALL_UNLOCKED;
        }
        return null;
    }

    private boolean compareStartState(String startState) {
        return StateSaver.getInstance().getCurrentState().getValue().equals(startState);
    }


    public void setCurrentState(State currentState) {
        StateSaver.getInstance().setCurrentState(currentState);
    }
}
