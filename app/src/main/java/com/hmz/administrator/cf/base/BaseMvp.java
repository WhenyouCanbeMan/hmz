package com.hmz.administrator.cf.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseMvp<T extends BasePresenter> extends BaseActivity implements BaseView{

    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
