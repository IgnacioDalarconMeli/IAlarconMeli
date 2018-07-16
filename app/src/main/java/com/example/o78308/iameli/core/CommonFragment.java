package com.example.o78308.iameli.core;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.example.o78308.iameli.core.mvp.IContract;

public class CommonFragment <T extends IContract.FragmentPresenter>  extends Fragment implements IContract.FragmentView {

    protected T presenter;

    @Override
    public void logProsscress(String message) {
        Log.e(this.getClass().getSimpleName(),  " " + message);
    }

    public void setPresenter(T presenter){
        this.presenter = presenter;
    }
}
