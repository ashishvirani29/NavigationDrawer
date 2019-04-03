package com.veera.supervisor;

public interface callbackListener<P, A,S,M> {
    void onClickCallBack(P p, A a, S s, M m);
}
