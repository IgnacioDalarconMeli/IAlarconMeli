package com.example.o78308.iameli.mvp.presenter.activity;

import com.example.o78308.iameli.core.mvp.IContract;

public interface IMainSearchPresenter extends IContract.Presenter {

    void getTrendProduct();

    void getTrendProduct(String q);

    void getDetailProduct(String productId);

    void getSearchProduct(String product);
}
