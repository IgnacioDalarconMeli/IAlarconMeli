package com.example.o78308.iameli.mvp.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.o78308.iameli.R;
import com.example.o78308.iameli.core.CommonFragment;
import com.example.o78308.iameli.mvp.presenter.fragment.IRvProductPresenter;
import com.example.o78308.iameli.mvp.presenter.fragment.RvProductPresenter;
import com.example.o78308.iameli.mvp.view.adapter.RvProductAdapter;
import com.example.o78308.iameli.networking.model.Result;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RvProductFragment extends CommonFragment<IRvProductPresenter> implements IRvProduct {

    private RecyclerView mRecyler;
    private ArrayList<Result> mArrayListResult;
    private RvProductAdapter mAdapter;
    private DetailOrderSelected detailOrderSelected;

    public RvProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayListResult = getArguments().getParcelableArrayList("trendArrayList");
    }

    public static RvProductFragment newInstance(ArrayList<Result> resultArrayList) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("trendArrayList", resultArrayList);
        RvProductFragment fragment = new RvProductFragment();
        fragment.setPresenter(new RvProductPresenter(fragment));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        mRecyler = view.findViewById(R.id.recycler_container);
        mAdapter = new RvProductAdapter(mArrayListResult);
        ListenerDetailOrderSelected listenerDetailOrderSelected = new ListenerDetailOrderSelected();
        mAdapter.setListener(listenerDetailOrderSelected);
        mRecyler.setHasFixedSize(false);
        mRecyler.setItemViewCacheSize(49);
        mRecyler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyler.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailOrderSelected = (DetailOrderSelected) context;
    }

    public interface DetailOrderSelected {
        void rowSelected(String id);
    }

    private class ListenerDetailOrderSelected implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int position = mRecyler.getChildAdapterPosition(view);
            Result pruduct = mArrayListResult.get(position);
            detailOrderSelected.rowSelected(pruduct.getId());
        }
    }

}
