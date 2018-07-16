package com.example.o78308.iameli.core;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.o78308.iameli.core.mvp.IContract;

public class CommonActivity <T extends IContract.Presenter> extends AppCompatActivity implements IContract.View {


    protected T presenter;

    @Override
    public void toastShow(String message, int length) {
        Toast.makeText(this, message, length).show();
    }

    @Override
    public void logProsscress(String message) {
        Log.e(this.getClass().getSimpleName(),  " " + message);
    }

    public void setPresenter(T presenter){
        this.presenter = presenter;
    }

}
