package khanh.recyclerviewmvpexamples.Core;

import android.content.Context;

import java.util.List;

import khanh.recyclerviewmvpexamples.Model.CountryRss;

public class Presenter implements GetDataCountry.Presenters, GetDataCountry.onGetDataList{

    private GetDataCountry.Views mGetDataCountryViews;
    private APIClient apiClient;

    public Presenter(GetDataCountry.Views mGetDataCountryViews) {
        this.mGetDataCountryViews = mGetDataCountryViews;
        apiClient = new APIClient(this);
    }

    @Override
    public void getDataFromURL(Context ct, String url) {
        apiClient.initRetrofitCall(ct, url);
    }

    @Override
    public void onSuccess(String msg, List<CountryRss> list) {
        mGetDataCountryViews.onGetDataSuccess(msg, list);
    }

    @Override
    public void onError(String msg) {
        mGetDataCountryViews.onGetDataError(msg);
    }
}
