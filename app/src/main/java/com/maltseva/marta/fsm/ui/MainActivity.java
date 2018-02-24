package com.maltseva.marta.fsm.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maltseva.marta.fsm.R;
import com.maltseva.marta.fsm.model.State;
import com.maltseva.marta.fsm.stateHandlers.StateChangedListener;
import com.maltseva.marta.fsm.stateHandlers.StateController;
import com.maltseva.marta.fsm.stateHandlers.StateManager;
import com.maltseva.marta.fsm.utils.JsonUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.maltseva.marta.fsm.model.State.ALARM_DISARMED_ALL_UNLOCKED;

public class MainActivity extends AppCompatActivity {
    private static final String FMS_DESCRIPTION_JSON = "fsm_description.json";

    @BindView(R.id.indicator)
    ImageView mIndicator;
    @BindView(R.id.state)
    TextView mState;


    private StateManager stateManager;

    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mIndicator.setImageResource(R.drawable.red_indicator);
        mState.setText(ALARM_DISARMED_ALL_UNLOCKED.getValue());
        StateChangedListener listener = new StateController(this);
        stateManager = new StateManager(ALARM_DISARMED_ALL_UNLOCKED, listener, new JsonUtils().getActionsFromJson(this, FMS_DESCRIPTION_JSON));
    }

    @OnClick({R.id.lock, R.id.lockx2, R.id.unlock, R.id.unlockx2})
    void btnClicks(View view) {
        dispatchEvent(view);
    }

    private void dispatchEvent(View view) {
        switch (view.getId()) {
            case R.id.lock:
                stateManager.setEvent(StateManager.LOCK);
                break;
            case R.id.lockx2:
                stateManager.setEvent(StateManager.LOCKX2);
                break;
            case R.id.unlock:
                stateManager.setEvent(StateManager.UNLOCK);
                break;
            case R.id.unlockx2:
                stateManager.setEvent(StateManager.UNLOCKx2);
        }
    }

    public void setState(State state) {
        mIndicator.setImageResource(state.getIndicatorOn() ? R.drawable.green_indicator : R.drawable.red_indicator);
        mState.setText(state.getValue());
    }
}
