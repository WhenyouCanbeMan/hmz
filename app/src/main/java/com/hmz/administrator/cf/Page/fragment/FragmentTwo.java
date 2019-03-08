package com.hmz.administrator.cf.Page.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.hmz.administrator.cf.Page.MainActivity_City_One;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.utils.weather.MainActivity2;
import com.hmz.administrator.cf.utils.weather.gson.Weather;
import com.hmz.administrator.cf.utils.weather.util.Utility;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentTwo extends Fragment {
    public LocationClient mLocationClient;
    private TextView positionText;
    private View view;
    private Unbinder unbinder;

    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentTwo() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.two_fragment, null);
            unbinder = ButterKnife.bind(this, view);
            initBanner();
            initView();
            TextView textView23=view.findViewById(R.id.textView23);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String weatherString = prefs.getString("weather", null);
            Weather weather = Utility.handleWeatherResponse(weatherString);
            /*textView23.setText(weather.now.temperature+ "°C");*/
            textView23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), MainActivity2.class));
                }
            });
        }
        return view;
    }
    public void initBanner() {
        TextView dingwei = view.findViewById(R.id.dingwei);
        dingwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity_City_One.class));
            }
        });
    }

    public void initView() {
        mLocationClient = new LocationClient(getContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        positionText = view.findViewById(R.id.container2);
        requestLocation();
    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }
    public void initLocation()
    {
        LocationClientOption option=new LocationClientOption();
        /*option.setScanSpan(5000);*/
        option.setIsNeedAddress(true);
        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mLocationClient.setLocOption(option);
    }
    /*public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(getContext(), "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(getContext(), "发生未知错误", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }*/

    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location)
        {
            Log.i("EWGFE","EWSFEWF");
            StringBuilder currentPosition=new StringBuilder();
            /*currentPosition.append("纬度：").append(location.getLatitude()).append("\n");
            currentPosition.append("经线：").append(location.getLongitude()).append("\n");
            currentPosition.append("国家：").append(location.getCountry()).append("\n");
            currentPosition.append("省：").append(location.getProvince()).append("\n");*/

            currentPosition.append(location.getCity()).append("\n");
            /*currentPosition.append("区：").append(location.getDistrict()).append("\n");
            currentPosition.append("街道：").append(location.getStreet()).append("\n");
            currentPosition.append("定位方式：");*/
            Log.i("dxcvds",currentPosition.toString());
            o(currentPosition.toString());
        }
        public void o(String a)
        {
            positionText.setText(a);
        }
    }
}
