package com.example.o78308.iameli.mvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.o78308.iameli.R;
import com.example.o78308.iameli.core.CommonFragment;
import com.example.o78308.iameli.mvp.presenter.fragment.IProductDetailPresenter;
import com.example.o78308.iameli.mvp.presenter.fragment.ProductDetailPresenter;
import com.example.o78308.iameli.networking.model.Detail;
import com.example.o78308.iameli.networking.model.DetailPicture;
import com.example.o78308.iameli.networking.model.ExtendProducDetail;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends CommonFragment<IProductDetailPresenter> implements IProductDetail {

    private Detail detailProduct;
    TextView detailTitle, detailPrice, detailStock, detailSold, detailExtend;
    CarouselView carouselView;
    Toolbar toolbarDetail;
    FloatingActionButton fabShipping;
    ProgressBar progressBar;
    private ArrayList<DetailPicture> carouselImages = new ArrayList<>();

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public static ProductDetailFragment newInstance(Detail product) {
        Bundle args = new Bundle();
        args.putParcelable("product", product);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setPresenter(new ProductDetailPresenter(fragment));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            detailProduct = getArguments().getParcelable("product");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        carouselImages = detailProduct.getPictures();
        init(view);
        presenter.getDetailExpand(detailProduct.getId());
        return view;
    }

    private void init(View view) {
        carouselView = view.findViewById(R.id.carouselView);
        carouselView.setPageCount(carouselImages.size());
        carouselView.setImageListener(imageListener);
        toolbarDetail = view.findViewById(R.id.toolbar);
        fabShipping = view.findViewById(R.id.fab_mercado_shipping);
        detailTitle = view.findViewById(R.id.detail_title);
        detailPrice = view.findViewById(R.id.detail_price);
        detailStock = view.findViewById(R.id.detail_stock);
        detailSold = view.findViewById(R.id.detail_sold);
        detailExtend = view.findViewById(R.id.detail_extend);
        progressBar = view.findViewById(R.id.progress_bar);
        detailTitle.setText(detailProduct.getTitle());
        detailPrice.setText("$" + detailProduct.getPrice().toString());
        detailStock.setText(getResources().getString(R.string.stock) + " " + detailProduct.getAvailable_quantity());
        detailSold.setText(getResources().getString(R.string.sold) + " " + detailProduct.getSold_quantity());
        if (detailProduct.getAccepts_mercadopago())
            fabShipping.setVisibility(View.VISIBLE);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Glide.with(getContext()).load(carouselImages.get(position).getUrl()).into(imageView);
        }
    };

    @Override
    public void progress(Boolean b) {
        progressBar.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
        progressBar.setIndeterminate(b);
    }

    @Override
    public void setExtendDetail(ExtendProducDetail extendDetail) {
        detailExtend.setVisibility(View.VISIBLE);
        detailExtend.setText(Html.fromHtml(extendDetail.getPlain_text()));
    }
}
