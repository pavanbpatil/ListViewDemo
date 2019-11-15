package com.uft.listviewdemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uft.listviewdemo.adapter.CountryDataListAdapter;
import com.uft.listviewdemo.dto.CountryData;
import com.uft.listviewdemo.model.FetchListPresenterImpl;
import com.uft.listviewdemo.presenter.FetchListPresenter;
import com.uft.listviewdemo.view.FetchListView;

/**
 * Created by pavan on 15/11/2019.
 */
public class MainActivity extends AppCompatActivity implements FetchListView {

    private FetchListPresenter fetchListPresenter;
    private LinearLayoutManager mLayoutManager;
    private CountryDataListAdapter countryDataListAdapter;
    private RecyclerView rvCountryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        fetchListPresenter = new FetchListPresenterImpl(this, MainActivity.this);
        //Call presenter method to retrieve data from server
        fetchListPresenter.fetchCountryData();

    }

    private void initView() {
        rvCountryData = findViewById(R.id.rvCountryData);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvCountryData.setLayoutManager(mLayoutManager);
        //rvCountryData.setItemAnimator(new DefaultItemAnimator());
    }

    private void setView(CountryData countryData) {
        getSupportActionBar().setTitle(countryData.getTitle());
    }


    @Override
    public void fetchDataSuccess(CountryData countryData) {
        //Retrives data from presenter using callback method if success happens
        countryDataListAdapter = new CountryDataListAdapter(this, countryData.getRows());
        rvCountryData.setAdapter(countryDataListAdapter);
        setView(countryData);
    }

    @Override
    public void fetchDataFailure(String message) {
        //Retrives data from presenter using callback method if failure happens
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                fetchListPresenter.fetchCountryData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
