package com.hmz.administrator.cf.mvp.model;


import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.bean.NewsBean;
import com.hmz.administrator.cf.utils.callback.JsonCallback;
import com.hmz.administrator.cf.config.Api;
import com.hmz.administrator.cf.mvp.contract.Main2Contract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

public class Main2Model implements Main2Contract.M {

    @Override
    public void getSuccess(final BaseCallBack<NewsBean> baseCallBack) {
        OkGo.<NewsBean>get(Api.getUrl().webServer)
                .execute(new JsonCallback<NewsBean>() {
                    @Override
                    public void onSuccess(Response<NewsBean> response) {
                        baseCallBack.onSuccess(response.body());
                    }
                });
    }

   /* @Override
    public void getSuccess(final BaseCallBack<List<bean.ResultBean.DataBean>> baseCallBack) {
        OkGo.<List<bean.ResultBean.DataBean>>get(Api.getUrl().webServer)
                .execute(new JsonCallback<List<bean.ResultBean.DataBean>>() {
                    @Override
                    public void onSuccess(Response<List<bean.ResultBean.DataBean>> response) {
                        baseCallBack.success(response.body());
                    }
                });
    }*/
}
