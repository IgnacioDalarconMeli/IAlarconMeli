package com.example.o78308.iameli.mvp.view.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.o78308.iameli.R;
import com.example.o78308.iameli.core.Util.BaseService;
import com.example.o78308.iameli.core.Util.GlideApp;
import com.example.o78308.iameli.networking.ProductCall;
import com.example.o78308.iameli.networking.model.Picture;
import com.example.o78308.iameli.networking.model.Result;
import com.example.o78308.iameli.networking.model.Variations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvProductHolder extends CommonViewHolder<Result> {

    private ImageView thumbnail;
    private TextView producttitle;
    private TextView productPrice;

    public RvProductHolder(View itemView) {
        super(itemView);
        productPrice = itemView.findViewById(R.id.tv_price);
        producttitle = itemView.findViewById(R.id.tv_title);
        thumbnail = itemView.findViewById(R.id.iv_thumnail);
    }

    @Override
    public void bind(final Result result) {
        productPrice.setText("$ " + result.getPrice().toString());
        producttitle.setText(result.getTitle() + " ");
        GlideApp.with(itemView)
                .load(result.getThumbnail())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .onlyRetrieveFromCache(true).into(thumbnail);
        callForBetterPictures(result.getThumbnail().toString());

    }

    public void callForBetterPictures(String urlPath) {

        String[] parts = urlPath.split("/");
        String jpgPart = parts[parts.length - 1];
        String[] rawId = jpgPart.split("-");
        String pictureId = rawId[0] + "-" + rawId[1];

        BaseService.getInstance().getService(ProductCall.class).getPicture(pictureId).enqueue(new Callback<Picture>() {
            @Override
            public void onResponse(Call<Picture> call, Response<Picture> response) {
                if (response.isSuccessful()) {
                    for (Variations index : response.body().getVariationsArrayList()) {
                        if (index.getSize().equals("250x250")) {
                            try {
                                GlideApp.with(itemView).load(index.getUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(thumbnail);
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Picture> call, Throwable t) {

            }
        });
    }


}
