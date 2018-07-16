package com.example.o78308.iameli.mvp.presenter.activity;

import android.os.Handler;

import com.example.o78308.iameli.mvp.view.activity.ISplashScreenView;

public class SplashScreenPresenter implements ISplashScreenPresenter {

    private ISplashScreenView iSplashScreenView;
    private static final Integer TIMELAP = 2000;

    public SplashScreenPresenter(ISplashScreenView iSplashScreenView) {
        this.iSplashScreenView = iSplashScreenView;
    }

    @Override
    public void splashRunable() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iSplashScreenView.goActivity();
            }
        }, TIMELAP);
    }
}
