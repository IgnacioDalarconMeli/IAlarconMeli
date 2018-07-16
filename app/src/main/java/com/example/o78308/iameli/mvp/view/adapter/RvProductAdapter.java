package com.example.o78308.iameli.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.o78308.iameli.R;
import com.example.o78308.iameli.mvp.view.adapter.holder.CommonViewHolder;
import com.example.o78308.iameli.mvp.view.adapter.holder.RvProductHolder;
import com.example.o78308.iameli.networking.model.Result;

import java.util.List;

public class RvProductAdapter extends CommonAdapter<RvProductHolder, Result> implements View.OnClickListener {

    private View.OnClickListener listener;

    public RvProductAdapter(List<Result> collection) {
        super(collection, R.layout.rv_product_cell);
    }

    @Override
    public RvProductHolder getView(View view, int viewType) {
        return new RvProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
