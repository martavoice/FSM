package com.maltseva.marta.fsm;

import com.maltseva.marta.fsm.State;

/**
 * Created by Марта on 21.02.2018.
 */

public interface StateChangedListener {
    void updateState(State position);
}
