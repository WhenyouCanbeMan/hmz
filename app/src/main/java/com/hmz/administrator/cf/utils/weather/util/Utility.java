package com.hmz.administrator.cf.utils.weather.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hmz.administrator.cf.utils.weather.db.City;
import com.hmz.administrator.cf.utils.weather.db.County;
import com.hmz.administrator.cf.utils.weather.db.Province;
import com.hmz.administrator.cf.utils.weather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static  boolean handleProvinceResponse(String response) throws JSONException {
        if(!TextUtils.isEmpty(response))
        {
            JSONArray allProvinces=new JSONArray(response);
            for(int i=0;i<allProvinces.length();i++)
            {
                JSONObject provinceObject=allProvinces.getJSONObject(i);
                Province province=new Province();
                province.setProvinceName(provinceObject.getString("name"));
                province.setProvinceCode(provinceObject.getInt("id"));
                province.save();
            }
            return true;
        }
        return false;
    }
    public static boolean handleCityResponse(String response,int provinceId) throws JSONException {
        if(!TextUtils.isEmpty(response))
        {
            JSONArray allCity=new JSONArray(response);
            for(int i=0;i<allCity.length();i++)
            {
                JSONObject cityObject=allCity.getJSONObject(i);
                City city=new City();
                city.setCityName(cityObject.getString("name"));
                city.setCityCode(cityObject.getInt("id"));
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        }
        return false;
    }
    public static boolean handleCountyResponse(String response,int cityId) throws JSONException {
        if(!TextUtils.isEmpty(response))
        {
            JSONArray allCounties=new JSONArray(response);
            for(int i=0;i<allCounties.length();i++)
            {
                JSONObject countyObject=allCounties.getJSONObject(i);
                County county=new County();
                county.setCountyName(countyObject.getString("name"));
                county.setWeatherId(countyObject.getString("weather_id"));
                county.setCityId(cityId);
                county.save();
            }
            return true;
        }
        return false;
    }
    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}
