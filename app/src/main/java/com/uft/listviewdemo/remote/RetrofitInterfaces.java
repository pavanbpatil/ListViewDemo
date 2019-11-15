package com.uft.listviewdemo.remote;

import com.uft.listviewdemo.constants.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pavan on 15/11/2019.
 */

public class RetrofitInterfaces {

    public interface GetCountryData {
        @GET(Constant.NetworkConstants.COUNTRY_DATA_API)
        Call<ResponseBody> post();
    }
}



