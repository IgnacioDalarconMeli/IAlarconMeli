package com.example.o78308.iameli.mvp.view.activity;

import com.example.o78308.iameli.core.mvp.IContract;
import com.example.o78308.iameli.networking.model.Detail;
import com.example.o78308.iameli.networking.model.Result;

import java.util.ArrayList;

public interface IMainSearchView extends IContract.View {

    void progress(Boolean b);

    void doFragmentTransaction(ArrayList<Result> trendProducList);

    void doDetailTransaction(Detail productDetail);
}
