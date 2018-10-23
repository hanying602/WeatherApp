package com.pku.weatherapp.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pku.weatherapp.R;
import com.pku.weatherapp.bean.City;

import java.util.List;

public class CityListAdapter extends BaseAdapter {

    private Context context;
    private List<City> dataList;

    public CityListAdapter(Context context, List<City> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater myInflater = LayoutInflater.from(context);
        Holder holder = new Holder();
        convertView = myInflater.inflate(R.layout.item_city_listview, null);
        holder.cityName = convertView.findViewById(R.id.item_list_city_name);
        holder.cityCode = convertView.findViewById(R.id.item_list_city_code);

        holder.cityName.setText(dataList.get(position).getCity());
        holder.cityCode.setText(dataList.get(position).getNumber());


        return convertView;
    }

    private class Holder {

        TextView cityName;
        TextView cityCode;
    }

}
