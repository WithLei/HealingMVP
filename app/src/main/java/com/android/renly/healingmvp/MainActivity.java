package com.android.renly.healingmvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.water)
    LinearLayout water;
    @BindView(R.id.waterman)
    LinearLayout waterman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.water, R.id.waterman})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.water:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.waterman:
                break;
        }
    }
}
