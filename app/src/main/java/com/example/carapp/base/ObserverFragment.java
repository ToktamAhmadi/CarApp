package com.example.carapp.base;

import io.reactivex.disposables.CompositeDisposable;

//for fragment use rx
public abstract class ObserverFragment extends BaseFragment {

    //handle disposable if you use Single Observer RxJava
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onStart() {
        super.onStart();
        subscribe();
    }

    @Override
    public void onStop() {
        super.onStop();
        unSubscibe();
    }

    public abstract void subscribe();

    public void unSubscibe(){
        compositeDisposable.clear();
    }
}
