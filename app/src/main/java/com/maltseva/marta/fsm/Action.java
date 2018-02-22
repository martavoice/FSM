package com.maltseva.marta.fsm;

/**
 * Created by Марта on 22.02.2018.
 */

public class Action {

    private String actionType;
    private String startState;
    private String endState;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public String getEndState() {
        return endState;
    }

    public void setEndState(String endState) {
        this.endState = endState;
    }


}
