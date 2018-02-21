package com.maltseva.marta.fsm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    @BindView(R.id.lock)
    Button mLock;
    @BindView(R.id.unlock)
    Button mUnLock;
    @BindView(R.id.lockx2)
    Button mLockx2;
    @BindView(R.id.unlockx2)
    Button mUnlockx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.lock, R.id.lockx2, R.id.unlock, R.id.unlockx2})
    void btnClicks(View view) {
        switch (view.getId()) {
            case R.id.lock:
                break;
            case R.id.unlock:
                break;
            case R.id.lockx2:
                break;
            case R.id.unlockx2:
                break;
        }
    }
}
