package com.example.o78308.iameli.mvp.view.activity;

import android.app.SearchManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.o78308.iameli.R;
import com.example.o78308.iameli.core.CommonActivity;
import com.example.o78308.iameli.mvp.presenter.activity.IMainSearchPresenter;
import com.example.o78308.iameli.mvp.presenter.activity.MainSearchPresenter;
import com.example.o78308.iameli.mvp.view.fragment.ProductDetailFragment;
import com.example.o78308.iameli.mvp.view.fragment.RvProductFragment;
import com.example.o78308.iameli.networking.model.Detail;
import com.example.o78308.iameli.networking.model.Result;

import java.util.ArrayList;

public class MainSearchActivity extends CommonActivity<IMainSearchPresenter> implements IMainSearchView, RvProductFragment.DetailOrderSelected {

    private FrameLayout frameLayoutContainer;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    public static final String TAG_RECYCLER_LIST = "RecyclerListView";
    public static final String TAG_DETAIL_PRODUCT = "detailProduct";
    ProgressBar progressBar;
    ArrayList<Result> mResultArrayList;
    private boolean doubleTapToExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);
        setPresenter(new MainSearchPresenter(this));
        init();
    }

    private void init() {
        frameLayoutContainer = findViewById(R.id.fragment_container);
        progressBar = findViewById(R.id.progressBar);
        toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appbar_layout);
        setSupportActionBar(toolbar);
        presenter.getTrendProduct();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu_search, menu);
        initSearchView(menu);
        return true;
    }

    private void initSearchView(Menu menu) {
        final MenuItem searchItem = menu.findItem(R.id.menu_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(Html.fromHtml("<font color = #000000>" + getResources().getString(R.string.search_hint) + "</font"));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.equals(""))
                    presenter.getSearchProduct(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
    }

    @Override
    public void progress(Boolean b) {
        progressBar.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
        progressBar.setIndeterminate(b);
    }

    @Override
    public void doFragmentTransaction(ArrayList<Result> trendProducList) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RvProductFragment rvProductFragment = RvProductFragment.newInstance(trendProducList);
        fragmentTransaction.replace(R.id.fragment_container, rvProductFragment, TAG_RECYCLER_LIST);
        fragmentTransaction.commit();
    }

    @Override
    public void doDetailTransaction(Detail productDetail) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ProductDetailFragment productDetailFragment = ProductDetailFragment.newInstance(productDetail);
        fragmentTransaction.replace(R.id.fragment_container, productDetailFragment, TAG_DETAIL_PRODUCT).addToBackStack(null);
        appBarLayout.setVisibility(View.GONE);
        fragmentTransaction.commit();
    }

    @Override
    public void rowSelected(String id) {
        presenter.getDetailProduct(id);
    }

    @Override
    public void onBackPressed() {
        appBarLayout.setVisibility(View.VISIBLE);
        super.onBackPressed();
    }

}
