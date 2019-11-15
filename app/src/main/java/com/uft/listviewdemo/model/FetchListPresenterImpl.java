package com.uft.listviewdemo.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.uft.listviewdemo.R;
import com.uft.listviewdemo.constants.Constant;
import com.uft.listviewdemo.constants.Utilities;
import com.uft.listviewdemo.dto.CountryData;
import com.uft.listviewdemo.presenter.FetchListPresenter;
import com.uft.listviewdemo.remote.RetrofitClient;
import com.uft.listviewdemo.remote.RetrofitInterfaces;
import com.uft.listviewdemo.view.FetchListView;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by pavan on 15/11/2019.
 */
public class FetchListPresenterImpl implements FetchListPresenter,retrofit2.Callback<ResponseBody>{
    private FetchListView fetchListView;
    private Context context;

    public FetchListPresenterImpl(Context context, FetchListView fetchListView)
    {
        this.fetchListView=fetchListView;
        this.context=context;
    }

    @Override
    public void fetchCountryData() {
        Utilities.showLoader(context);
        RetrofitClient
                .getClient(Constant.NetworkConstants.BASE_URL)
                .create(RetrofitInterfaces.GetCountryData.class)
                .post()
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            Utilities.hideLoader();
            JSONObject jsonObject = new JSONObject(response.body().string());
            CountryData countryData = new Gson().fromJson(jsonObject.toString(), CountryData.class);
            if (!countryData.getRows().isEmpty()) {
                fetchListView.fetchDataSuccess(countryData);
            } else {
                fetchListView.fetchDataFailure(Constant.AppConstants.NO_DATA_IN_API);
            }
        } catch (Exception e) {
            fetchListView.fetchDataFailure(Constant.AppConstants.SOMETHING_ERROR);
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        fetchListView.fetchDataFailure(Constant.AppConstants.API_ERROR);
    }


}
