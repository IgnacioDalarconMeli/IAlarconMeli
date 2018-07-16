package com.example.o78308.iameli.mvp.presenter.fragment;

import com.example.o78308.iameli.mvp.view.fragment.IRvProduct;

public class RvProductPresenter implements IRvProductPresenter {

    private IRvProduct recyclerView;

    public RvProductPresenter(IRvProduct recyclerView) {
        this.recyclerView = recyclerView;
    }
}
