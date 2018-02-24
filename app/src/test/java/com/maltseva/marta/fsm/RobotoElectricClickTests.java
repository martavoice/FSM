package com.maltseva.marta.fsm;

import android.widget.Button;
import android.widget.TextView;

import com.maltseva.marta.fsm.model.State;
import com.maltseva.marta.fsm.stateHandlers.StateSaver;
import com.maltseva.marta.fsm.ui.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марта on 22.02.2018.
 */
@RunWith(RobolectricTestRunner.class)
public class RobotoElectricClickTests {

    @Test
    public void clickingLockButtonWithStartStateAlarmDisarmedAllUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockButtonWithStartStateAlarmDisarmedAllUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockx2ButtonWithStartStateAlarmDisarmedAllUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockx2ButtonWithStartStateAlarmDisarmedAllUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockButtonWithStartStateAlarmDisarmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockButtonWithStartStateAlarmDisarmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockx2ButtonWithStartStateAlarmDisarmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockx2ButtonWithStartStateAlarmDisarmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockButtonWithStartStateAlarmDisarmedDriverUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockButtonWithStartStateAlarmDisarmedDriverUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockx2ButtonWithStartStateAlarmDisarmedDriverUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockx2ButtonWithStartStateAlarmDisarmedDriverUnlocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockButtonWithStartStateAlarmArmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockButtonWithStartStateAlarmArmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockx2ButtonWithStartStateAlarmArmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockx2ButtonWithStartStateAlarmArmedAllLocked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @Test
    public void checkSwitchingFewStates() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button lock = (Button) activity.findViewById(R.id.lock);
        Button unlock = (Button) activity.findViewById(R.id.unlock);
        Button lockx2 = (Button) activity.findViewById(R.id.lockx2);
        Button unlockx2 = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateSaver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        lock.performClick();
        unlock.performClick();
        lockx2.performClick();
        unlockx2.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());


    }




}
