package com.hmz.administrator.cf.config;

public class Api {

    private static Api api;
//数据不匹配
    public static Api getUrl() {
        if (api == null) {
            api = new Api();
        }
        return api;
    }
    /*
    *
    * 错峰旅游错峰
    *
    * */
    public static String webServers="http://172.16.253.83/api/sThree/index.php/front/scenic/list";
    public static String webServera="http://v.juhe.cn/toutiao/index?type=top&key=a1a755458cc22f129942b34904feb820";


//为确保数据安全，ip接口为动态刷新
    public static String web="http://192.168.0.112:8080/demo/UserServlet";
    /*
    *
    * 新闻API借口
    *
    * */
    // http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5
    //a1a755458cc22f129942b34904feb820
    public String webServer="http://v.juhe.cn/toutiao/index?type=top&key=a1a755458cc22f129942b34904feb820";

}
