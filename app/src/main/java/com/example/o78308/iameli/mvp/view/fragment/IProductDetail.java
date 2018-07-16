package com.example.o78308.iameli.mvp.view.fragment;

import com.example.o78308.iameli.core.mvp.IContract;
import com.example.o78308.iameli.networking.model.ExtendProducDetail;

public interface IProductDetail extends IContract.FragmentView {

    void progress(Boolean b);

    void setExtendDetail(ExtendProducDetail extendDetail);
}
