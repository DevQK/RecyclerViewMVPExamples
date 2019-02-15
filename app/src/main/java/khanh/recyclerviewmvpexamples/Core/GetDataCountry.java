package khanh.recyclerviewmvpexamples.Core;

import android.content.Context;

import java.util.List;

import khanh.recyclerviewmvpexamples.Model.CountryRss;

public interface GetDataCountry {
    interface Views{
        void onGetDataSuccess(String msg, List<CountryRss> list);
        void onGetDataError(String msg);
    }
    interface Presenters{
        void getDataFromURL(Context ct, String url);
    }
    interface RetrofitsClient{
        void initRetrofitCall(Context ct, String url);
    }
    interface onGetDataList{
        void onSuccess(String msg, List<CountryRss> list);
        void onError(String msg);
    }
}
