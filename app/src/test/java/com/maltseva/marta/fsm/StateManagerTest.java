package com.maltseva.marta.fsm;

import com.maltseva.marta.fsm.ui.MainActivity;
import com.maltseva.marta.fsm.ui.StateController;


import org.junit.Test;

import java.util.ArrayList;

import static com.maltseva.marta.fsm.State.ALARM_ARMED_ALL_LOCKED;
import static com.maltseva.marta.fsm.State.ALARM_DISARMED_ALL_LOCKED;
import static com.maltseva.marta.fsm.State.ALARM_DISARMED_ALL_UNLOCKED;
import static com.maltseva.marta.fsm.State.ALARM_DISARMED_DRIVER_UNLOCKED;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StateManagerTest {

    @Test
    public void checkResultWhenStartStateAlarmDisarmedAllUnlocked() throws Exception {
        MainActivity activity = mock(MainActivity.class);
        StateManager manager = new StateManager(ALARM_DISARMED_ALL_UNLOCKED, new StateController(activity), new ArrayList<Action>() {
            {
                add(new Action(StateManager.LOCK, ALARM_DISARMED_ALL_UNLOCKED.getValue(), State.ALARM_DISARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.LOCKX2, State.ALARM_DISARMED_ALL_LOCKED.getValue(), State.ALARM_ARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCK, State.ALARM_ARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCK, State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue(), ALARM_DISARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCKx2, State.ALARM_DISARMED_ALL_LOCKED.getValue(), ALARM_DISARMED_ALL_UNLOCKED.getValue()));
            }
        });

        manager.setEvent(StateManager.LOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_LOCKED);

        manager.setEvent(StateManager.LOCKX2);

        verify(activity, times(1)).setState(ALARM_ARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_ARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_DRIVER_UNLOCKED);

        manager.setEvent(StateManager.LOCK);

        verify(activity, times(2)).setState(ALARM_DISARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCKx2);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_UNLOCKED);

    }

    @Test
    public void checkResultWhenStartStateAlarmDisarmedAllLocked() throws Exception {
        MainActivity activity = mock(MainActivity.class);
        StateManager manager = new StateManager(ALARM_DISARMED_ALL_LOCKED, new StateController(activity), new ArrayList<Action>() {
            {
                add(new Action(StateManager.UNLOCK, ALARM_DISARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCKX2, State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue(), State.ALARM_ARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCKx2, State.ALARM_ARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCK, State.ALARM_DISARMED_ALL_UNLOCKED.getValue(), ALARM_DISARMED_ALL_LOCKED.getValue()));
            }
        });

        manager.setEvent(StateManager.UNLOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_DRIVER_UNLOCKED);

        manager.setEvent(StateManager.LOCKX2);

        verify(activity, times(1)).setState(ALARM_ARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_ARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCKx2);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_UNLOCKED);

        manager.setEvent(StateManager.LOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_LOCKED);
    }

    @Test
    public void checkResultWhenStartStateAlarmArmedAllLocked() throws Exception {
        MainActivity activity = mock(MainActivity.class);
        StateManager manager = new StateManager(ALARM_ARMED_ALL_LOCKED, new StateController(activity), new ArrayList<Action>() {
            {
                add(new Action(StateManager.UNLOCK, ALARM_ARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCK, State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue(), State.ALARM_DISARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCKx2, State.ALARM_DISARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCKX2, State.ALARM_DISARMED_ALL_UNLOCKED.getValue(), ALARM_ARMED_ALL_LOCKED.getValue()));
            }
        });

        manager.setEvent(StateManager.UNLOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_DRIVER_UNLOCKED);

        manager.setEvent(StateManager.LOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCKx2);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_UNLOCKED);

        manager.setEvent(StateManager.LOCKX2);

        verify(activity, times(1)).setState(ALARM_ARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_ARMED_ALL_LOCKED);
    }

    @Test
    public void checkResultWhenStartStateAlarmDisarmedDriverUnlocked() throws Exception {
        MainActivity activity = mock(MainActivity.class);
        StateManager manager = new StateManager(ALARM_DISARMED_DRIVER_UNLOCKED, new StateController(activity), new ArrayList<Action>() {
            {
                add(new Action(StateManager.LOCKX2, ALARM_DISARMED_DRIVER_UNLOCKED.getValue(), State.ALARM_ARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCKx2, State.ALARM_ARMED_ALL_LOCKED.getValue(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue()));
                add(new Action(StateManager.LOCK, State.ALARM_DISARMED_ALL_UNLOCKED.getValue(), State.ALARM_DISARMED_ALL_LOCKED.getValue()));
                add(new Action(StateManager.UNLOCK, State.ALARM_DISARMED_ALL_LOCKED.getValue(), ALARM_DISARMED_DRIVER_UNLOCKED.getValue()));
            }
        });

        manager.setEvent(StateManager.LOCKX2);

        verify(activity, times(1)).setState(ALARM_ARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_ARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCKx2);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_UNLOCKED);

        manager.setEvent(StateManager.LOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_ALL_LOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_ALL_LOCKED);

        manager.setEvent(StateManager.UNLOCK);

        verify(activity, times(1)).setState(ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(StateSaver.getInstance().getCurrentState(), ALARM_DISARMED_DRIVER_UNLOCKED);
    }
}