package com.maltseva.marta.fsm;

public class Action {

    public Action(String actionType, String startState, String endState) {
        this.actionType = actionType;
        this.startState = startState;
        this.endState = endState;
    }

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
