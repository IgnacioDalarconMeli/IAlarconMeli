package com.example.o78308.iameli.networking;

import com.example.o78308.iameli.networking.model.Detail;
import com.example.o78308.iameli.networking.model.ExtendProducDetail;
import com.example.o78308.iameli.networking.model.Picture;
import com.example.o78308.iameli.networking.model.ProductListCallback;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductCall {

    @GET("sites/MLU/search")
    Call<ProductListCallback> getItems(@Query("q") String item, @Query("access_key") String token);

    @GET("pictures/{picture}")
    Call<Picture> getPicture(@Path("picture") String path);

    @GET("items/{itemId}")
    Call<Detail> getDetail(@Path("itemId") String productId);

    @GET("items/{itemId}/description")
    Call<ExtendProducDetail> getDetailExtend(@Path("itemId") String productId);
}
