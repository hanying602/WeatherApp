package com.pku.weatherapp.miniweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.pku.weatherapp.R;
import com.pku.weatherapp.adapter.CityListAdapter;
import com.pku.weatherapp.app.MyApplication;
import com.pku.weatherapp.bean.City;

import java.util.ArrayList;
import java.util.List;

public class SelectCity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBackBtn;
    private ListView mList;
    private List<City> cityList, filterDataList;
    private CityListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        initViews();
    }

    private void initViews(){

        cityList = new ArrayList<>();
        filterDataList = new ArrayList<>();

        mBackBtn = findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        mList = findViewById(R.id.title_list);
        MyApplication myApplication = (MyApplication) getApplication();
        cityList = myApplication.getCityList();
        filterDataList.addAll(cityList);
        myAdapter = new CityListAdapter(SelectCity.this, cityList);
        mList.setAdapter(myAdapter);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                City city = filterDataList.get(position);
                Intent i = new Intent();
                i.putExtra("cityCode", city.getNumber());
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                Intent i = new Intent();
                i.putExtra("cityCode", "101160101");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }

    }
}
