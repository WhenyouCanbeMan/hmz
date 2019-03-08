package com.hmz.administrator.cf.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView{
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
