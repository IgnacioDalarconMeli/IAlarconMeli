package com.example.o78308.iameli.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.o78308.iameli.core.mvp.IContract;

import java.util.List;

public interface ICommonAdapter<T extends RecyclerView.ViewHolder, J> {

    T getView(View parent, int viewType);
    J getElement(int i);
    List<J> getCollection();
}
