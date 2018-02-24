package com.maltseva.marta.fsm.stateHandlers;

import com.maltseva.marta.fsm.model.State;

/**
 * Created by Марта on 21.02.2018.
 */

public class StateSaver {


    private static StateSaver instance;
    private State state;

    public static StateSaver getInstance() {
        if (instance == null) {
            instance = new StateSaver();
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
