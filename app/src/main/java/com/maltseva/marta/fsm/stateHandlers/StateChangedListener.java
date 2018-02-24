package com.maltseva.marta.fsm.stateHandlers;

import com.maltseva.marta.fsm.model.State;

/**
 * Created by Марта on 21.02.2018.
 */

public interface StateChangedListener {
    void updateState(State position);
}
