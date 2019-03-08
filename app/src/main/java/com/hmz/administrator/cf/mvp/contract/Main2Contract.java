package com.hmz.administrator.cf.mvp.contract;



import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.bean.NewsBean;

public interface Main2Contract {
    interface M {
        //void getSuccess(BaseCallBack<List<bean.ResultBean.DataBean>> baseCallBack);
       void getSuccess(BaseCallBack<NewsBean> baseCallBack);

    }

    interface P {
        void getSuccess();

    }
}
