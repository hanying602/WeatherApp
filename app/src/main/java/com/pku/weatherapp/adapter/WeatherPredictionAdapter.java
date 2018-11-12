package com.pku.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pku.weatherapp.R;
import com.pku.weatherapp.bean.TodayWeather;

import java.util.List;

public class WeatherPredictionAdapter extends PagerAdapter{

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<TodayWeather> mWeatherList;

    public WeatherPredictionAdapter(Context context, List<TodayWeather> weatherList) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mWeatherList = weatherList;
    }

    @Override
    public int getCount() {
        return mWeatherList.size() == 0 ? 0 : mWeatherList.size() % 3 + 1 ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_prediction_weather, container, false);

//        ImageView imageView = (ImageView) itemView.findViewById(R.id.nav_header_profile_pic);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        Glide.with(mContext).load(mResources[position]).into(imageView);
        container.addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
