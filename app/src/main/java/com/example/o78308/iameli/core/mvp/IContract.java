package com.example.o78308.iameli.core.mvp;

import android.app.Activity;

public interface IContract {

    interface View {
        void toastShow(String message, int length);

        void logProsscress(String message);
    }

    interface Presenter {

    }

    interface FragmentView {
        void logProsscress(String message);
    }

    interface FragmentPresenter {

    }
}
