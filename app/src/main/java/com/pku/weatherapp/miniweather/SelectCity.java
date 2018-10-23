package com.pku.weatherapp.miniweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pku.weatherapp.R;
import com.pku.weatherapp.adapter.CityListAdapter;
import com.pku.weatherapp.app.MyApplication;
import com.pku.weatherapp.bean.City;
import com.pku.weatherapp.customview.EditTextWrapper;

import java.util.ArrayList;
import java.util.List;

public class SelectCity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBackBtn;
    private TextView mTitleName;
    private ListView mList;
    private List<City> cityList, filterDataList;
    private CityListAdapter myAdapter;
    private EditTextWrapper editTextWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);

        initViews();
    }

    private void initViews(){

        mTitleName = findViewById(R.id.title_name);
        if(getIntent().getExtras()!=null) {
            String titleStr = "當前城市：" + getIntent().getExtras().getString("current_city","N/A");
            mTitleName.setText(titleStr);
        }

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
        editTextWrapper = findViewById(R.id.search_city);
        editTextWrapper.setTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterData(charSequence.toString());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    private void filterData(String filterStr){
        filterDataList.clear();
        if(TextUtils.isEmpty(filterStr)){
            filterDataList.addAll(cityList);
        }else {

            for(City city:cityList){
                if(city.getCity().contains(filterStr)){
                    filterDataList.add(city);
                }
            }
        }
        myAdapter.setDataList(filterDataList);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;
        }

    }
}
