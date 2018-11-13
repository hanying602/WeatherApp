package com.pku.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pku.weatherapp.R;
import com.pku.weatherapp.bean.TodayWeather;

import java.util.List;

public class WeatherPredictionAdapter extends PagerAdapter {

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
        return mWeatherList.size() == 0 ? 0 : mWeatherList.size() / 3 + 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_prediction_weather, container, false);

        int dataCount = mWeatherList.size();

        if (dataCount - 1 >= position * 3) {
            TextView weekTv1 = itemView.findViewById(R.id.prediction_week_title1);
            weekTv1.setText(mWeatherList.get(position * 3).getDate());
            TextView temperatureTv1 = itemView.findViewById(R.id.prediction_temperature1);
            temperatureTv1.setText(mWeatherList.get(position * 3).getHigh() + "~" + mWeatherList.get(position * 3).getLow());
            TextView climateTv1 = itemView.findViewById(R.id.prediction_weather1);
            climateTv1.setText(mWeatherList.get(position * 3).getType());
            TextView windTv1 = itemView.findViewById(R.id.prediction_wind1);
            windTv1.setText("風力:" + mWeatherList.get(position * 3).getFengli());
            ImageView typeImg1 = itemView.findViewById(R.id.prediction_weather_image1);
            updateWeatherImage(typeImg1, mWeatherList.get(position * 3).getType());
        }
        if (dataCount - 1 >= position * 3 + 1) {
            TextView weekTv2 = itemView.findViewById(R.id.prediction_week_title2);
            weekTv2.setText(mWeatherList.get(position * 3 + 1).getDate());
            TextView temperatureTv2 = itemView.findViewById(R.id.prediction_temperature2);
            temperatureTv2.setText(mWeatherList.get(position * 3 + 1).getHigh() + "~" + mWeatherList.get(position * 3 + 1).getLow());
            TextView climateTv2 = itemView.findViewById(R.id.prediction_weather2);
            climateTv2.setText(mWeatherList.get(position * 3 + 1).getType());
            TextView windTv2 = itemView.findViewById(R.id.prediction_wind2);
            windTv2.setText("風力:" + mWeatherList.get(position * 3 + 1).getFengli());
            ImageView typeImg2 = itemView.findViewById(R.id.prediction_weather_image2);
            updateWeatherImage(typeImg2, mWeatherList.get(position * 3 + 1).getType());
        }
        if (dataCount - 1 >= position * 3 + 2) {
            TextView weekTv3 = itemView.findViewById(R.id.prediction_week_title3);
            weekTv3.setText(mWeatherList.get(position * 3 + 2).getDate());
            TextView temperatureTv3 = itemView.findViewById(R.id.prediction_temperature3);
            temperatureTv3.setText(mWeatherList.get(position * 3 + 2).getHigh() + "~" + mWeatherList.get(position * 3 + 2).getLow());
            TextView climateTv3 = itemView.findViewById(R.id.prediction_weather3);
            climateTv3.setText(mWeatherList.get(position * 3 + 2).getType());
            TextView windTv3 = itemView.findViewById(R.id.prediction_wind3);
            windTv3.setText("風力:" + mWeatherList.get(position * 3 + 2).getFengli());
            ImageView typeImg3 = itemView.findViewById(R.id.prediction_weather_image3);
            updateWeatherImage(typeImg3, mWeatherList.get(position * 3 + 2).getType());
        }


        container.addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    void updateWeatherImage(ImageView weatherImg,  String weatherStr) {
        if (weatherStr != null) {
            switch (weatherStr) {
                case "暴雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_baoxue);
                    break;
                case "暴雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_baoyu);
                    break;
                case "大暴雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_dabaoyu);
                    break;
                case "大雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_daxue);
                    break;
                case "大雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_dayu);
                    break;
                case "多云":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_duoyun);
                    break;
                case "雷阵雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_leizhenyu);
                    break;
                case "雷阵雨冰雹":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_leizhenyubingbao);
                    break;
                case "晴":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_qing);
                    break;
                case "沙尘暴":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_shachenbao);
                    break;
                case "特大暴雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_tedabaoyu);
                    break;
                case "雾":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_wu);
                    break;
                case "小雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_xiaoxue);
                    break;
                case "小雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_xiaoyu);
                    break;
                case "阴":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_yin);
                    break;
                case "雨加雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_yujiaxue);
                    break;
                case "阵雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_zhenxue);
                    break;
                case "阵雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_zhenyu);
                    break;
                case "中雪":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_zhongxue);
                    break;
                case "中雨":
                    weatherImg.setImageResource(R.drawable.biz_plugin_weather_zhongyu);
                    break;
            }
        }
    }

}
