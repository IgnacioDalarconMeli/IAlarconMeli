package com.example.o78308.iameli.mvp.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.o78308.iameli.R;
import com.example.o78308.iameli.core.CommonActivity;
import com.example.o78308.iameli.mvp.presenter.activity.ISplashScreenPresenter;
import com.example.o78308.iameli.mvp.presenter.activity.SplashScreenPresenter;

public class SplashScreenActivity extends CommonActivity<ISplashScreenPresenter> implements ISplashScreenView {

    private ImageView ivSplasIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setPresenter(new SplashScreenPresenter(this));
        init();
    }

    private void init() {
        ivSplasIcon = findViewById(R.id.iv_splash_icon);
        ivSplasIcon.setImageResource(R.drawable.mercado_logo);
        presenter.splashRunable();
    }

    @Override
    public void goActivity(){
        Intent intent = new Intent(this, MainSearchActivity.class);
        startActivity(intent);
        SplashScreenActivity.this.finish();
    }

}
