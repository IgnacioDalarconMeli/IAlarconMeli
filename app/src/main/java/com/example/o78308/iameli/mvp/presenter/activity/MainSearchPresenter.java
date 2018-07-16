package com.example.o78308.iameli.mvp.presenter.activity;

import com.example.o78308.iameli.core.Util.BaseService;
import com.example.o78308.iameli.mvp.view.activity.IMainSearchView;
import com.example.o78308.iameli.networking.ProductCall;
import com.example.o78308.iameli.networking.model.Detail;
import com.example.o78308.iameli.networking.model.ProductListCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainSearchPresenter implements IMainSearchPresenter {

    private IMainSearchView iMainSearchView;
    private static final String ACCESS_TOKEN = "APP_USR-5445075213699237-071113-debe2e3d617ea9f3d852f9d08155113f-264253639";
    private String q = "gaming mouse";

    public MainSearchPresenter(IMainSearchView iMainSearchView) {
        this.iMainSearchView = iMainSearchView;
    }

    @Override
    public void getTrendProduct() {
        iMainSearchView.progress(true);
        BaseService.getInstance().getService(ProductCall.class).getItems(q, ACCESS_TOKEN).enqueue(new Callback<ProductListCallback>() {
            @Override
            public void onResponse(Call<ProductListCallback> call, Response<ProductListCallback> response) {
                if (response.isSuccessful())
                    iMainSearchView.doFragmentTransaction(response.body().getResults());

                iMainSearchView.progress(false);
            }

            @Override
            public void onFailure(Call<ProductListCallback> call, Throwable t) {
                iMainSearchView.progress(false);

            }
        });
    }

    @Override
    public void getDetailProduct(String productId) {
        iMainSearchView.progress(true);
        BaseService.getInstance().getService(ProductCall.class).getDetail(productId).enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(Call<Detail> call, Response<Detail> response) {
                if(response.isSuccessful())
                    iMainSearchView.doDetailTransaction(response.body());

                iMainSearchView.progress(false);
            }

            @Override
            public void onFailure(Call<Detail> call, Throwable t) {
                iMainSearchView.progress(false);
            }
        });
    }

    @Override
    public void getSearchProduct(String product) {
        iMainSearchView.progress(true);
        BaseService.getInstance().getService(ProductCall.class).getItems(product, ACCESS_TOKEN).enqueue(new Callback<ProductListCallback>() {
            @Override
            public void onResponse(Call<ProductListCallback> call, Response<ProductListCallback> response) {
                if (response.isSuccessful())
                    iMainSearchView.doFragmentTransaction(response.body().getResults());

                iMainSearchView.progress(false);
            }

            @Override
            public void onFailure(Call<ProductListCallback> call, Throwable t) {
                iMainSearchView.progress(false);

            }
        });
    }


}
