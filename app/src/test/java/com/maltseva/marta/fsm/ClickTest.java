package com.maltseva.marta.fsm;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Марта on 22.02.2018.
 */
@RunWith(RobolectricTestRunner.class)
public class ClickTest {

    @Test
    public void clickingLockButton_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockButton_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlock);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @Test
    public void clickingLockx2Button_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.lockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_ARMED_ALL_LOCKED.getValue());
    }

    @Test
    public void clickingUnLockx2Button_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button button = (Button) activity.findViewById(R.id.unlockx2);
        TextView results = (TextView) activity.findViewById(R.id.state);
        StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        button.performClick();
        assertEquals(results.getText().toString(), State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

}
