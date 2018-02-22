package com.maltseva.marta.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.indicator)
    ImageView mIndicator;
    @BindView(R.id.state)
    TextView mState;
    private StateChanger stateChanger;

    private StateChangedListener listener = new StateChangedListener() {
        @Override
        public void updateState(State endState) {
            switch (endState) {
                case ALARM_ARMED_ALL_LOCKED:
                    StateArchiver.getInstance().setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
                    mIndicator.setImageResource(R.drawable.red_indicator);
                    mState.setText(State.ALARM_ARMED_ALL_LOCKED.getValue());
                    break;
                case ALARM_DISARMED_ALL_LOCKED:
                    StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
                    mIndicator.setImageResource(R.drawable.green_indicator);
                    mState.setText(State.ALARM_DISARMED_ALL_LOCKED.getValue());
                    break;
                case ALARM_DISARMED_DRIVER_UNLOCKED:
                    StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
                    mIndicator.setImageResource(R.drawable.green_indicator);
                    mState.setText(State.ALARM_DISARMED_DRIVER_UNLOCKED.getValue());
                    break;
                case ALARM_DISARMED_ALL_UNLOCKED:
                    StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
                    mIndicator.setImageResource(R.drawable.green_indicator);
                    mState.setText(State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setInitialState();
        stateChanger = new StateChanger(listener);
    }

    private void setInitialState() {
        StateArchiver.getInstance().setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        mIndicator.setImageResource(R.drawable.red_indicator);
        mState.setText(State.ALARM_DISARMED_ALL_UNLOCKED.getValue());
    }

    @OnClick({R.id.lock, R.id.lockx2, R.id.unlock, R.id.unlockx2})
    void btnClicks(View view) {
        switch (view.getId()) {
            case R.id.lock:
                stateChanger.setEvent(this, StateChanger.LOCK);
                break;
            case R.id.lockx2:
                stateChanger.setEvent(this, StateChanger.LOCKX2);
                break;
            case R.id.unlock:
                stateChanger.setEvent(this, StateChanger.UNLOCK);
                break;
            case R.id.unlockx2:
                stateChanger.setEvent(this, StateChanger.UNLOCKX2);
        }
    }
}
