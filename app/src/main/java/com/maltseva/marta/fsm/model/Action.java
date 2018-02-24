package com.maltseva.marta.fsm.model;

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

    public String getStartState() {
        return startState;
    }

    public String getEndState() {
        return endState;
    }


}
