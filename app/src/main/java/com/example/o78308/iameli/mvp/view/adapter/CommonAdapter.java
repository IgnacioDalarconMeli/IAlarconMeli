package com.example.o78308.iameli.mvp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.o78308.iameli.core.mvp.IContract;
import com.example.o78308.iameli.mvp.view.adapter.holder.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonAdapter <T extends CommonViewHolder, J> extends RecyclerView.Adapter<T> implements ICommonAdapter<T, J> {

    private View view;
    private List<J> _collection = new ArrayList<J>();
    private int rId;

    public CommonAdapter(List<J> collection, int rId) {
        this._collection = collection;
        this.rId = rId;
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.view = LayoutInflater.from(parent.getContext()).inflate(rId, parent, false);
        return this.getView(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
        holder.bind(this.getElement(position));
    }

    @Override
    public int getItemCount() {
        return _collection.size();
    }

    @Override
    public abstract T getView(View view, int viewType);

    @Override
    public J getElement(int i) {
        return this._collection.get(i);
    }

    @Override
    public List<J> getCollection() {
        return _collection;
    }
}
