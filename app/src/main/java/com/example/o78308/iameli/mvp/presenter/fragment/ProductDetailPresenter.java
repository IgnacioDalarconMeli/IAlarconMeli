package com.example.o78308.iameli.mvp.presenter.fragment;

import com.example.o78308.iameli.core.Util.BaseService;
import com.example.o78308.iameli.mvp.view.fragment.IProductDetail;
import com.example.o78308.iameli.networking.ProductCall;
import com.example.o78308.iameli.networking.model.ExtendProducDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailPresenter implements IProductDetailPresenter {

    private IProductDetail iProductDetail;

    public ProductDetailPresenter(IProductDetail iProductDetail) {
        this.iProductDetail = iProductDetail;
    }

    @Override
    public void getDetailExpand(String productId) {
        iProductDetail.progress(true);
        BaseService.getInstance().getService(ProductCall.class).getDetailExtend(productId).enqueue(new Callback<ExtendProducDetail>() {
            @Override
            public void onResponse(Call<ExtendProducDetail> call, Response<ExtendProducDetail> response) {
                if (response.isSuccessful())
                    iProductDetail.setExtendDetail(response.body());

                iProductDetail.progress(false);
            }

            @Override
            public void onFailure(Call<ExtendProducDetail> call, Throwable t) {
                iProductDetail.progress(false);
            }
        });

    }
}
