package com.example.o78308.iameli.mvp.presenter.fragment;

import com.example.o78308.iameli.core.mvp.IContract;

public interface IProductDetailPresenter extends IContract.FragmentPresenter {

    void getDetailExpand(String productId);
}
