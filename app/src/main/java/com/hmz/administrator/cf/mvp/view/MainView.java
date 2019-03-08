package com.hmz.administrator.cf.mvp.view;


import com.hmz.administrator.cf.base.BaseView;
import com.hmz.administrator.cf.bean.serinfo;

import java.util.List;

public interface MainView extends BaseView
{
    void getAllUserInfo(List<serinfo> list);
}
