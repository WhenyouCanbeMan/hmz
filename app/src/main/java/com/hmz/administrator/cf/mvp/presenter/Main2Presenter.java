package com.hmz.administrator.cf.mvp.presenter;


import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.base.BasePresenter;
import com.hmz.administrator.cf.bean.NewsBean;
import com.hmz.administrator.cf.mvp.contract.Main2Contract;
import com.hmz.administrator.cf.mvp.model.Main2Model;
import com.hmz.administrator.cf.mvp.view.Main2View;

public class Main2Presenter extends BasePresenter<Main2View> implements Main2Contract.P
{
    Main2Model logInM;//Model层

    public Main2Presenter() {
        logInM = new Main2Model();
    }

    @Override
    public void getSuccess() {
        logInM.getSuccess(new BaseCallBack<NewsBean>() {
                @Override
            public void onSuccess(NewsBean data) {
                    mView.getTrafficSuccess(data);
            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
