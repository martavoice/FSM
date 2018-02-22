package com.maltseva.marta.fsm;

/**
 * Created by Марта on 21.02.2018.
 */

public class StateArchiver {


    private static StateArchiver instance;
    private State state;

    public static StateArchiver getInstance() {
        if (instance == null) {
            instance = new StateArchiver();
        }
        return instance;
    }

    public void setCurrentState(State value) {
        this.state = value;
    }

    public State getCurrentState() {
        return state;
    }

}
