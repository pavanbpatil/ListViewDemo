package com.uft.listviewdemo.view;

import com.uft.listviewdemo.dto.CountryData;
/**
 * Created by pavan on 15/11/2019.
 */
public interface FetchListView {
    void fetchDataSuccess(CountryData countryData);
    void fetchDataFailure(String message);
}
