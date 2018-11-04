package com.android.renly.healingmvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        btnLogin.setClickable(true);
        btnLogin.setEnabled(true);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
