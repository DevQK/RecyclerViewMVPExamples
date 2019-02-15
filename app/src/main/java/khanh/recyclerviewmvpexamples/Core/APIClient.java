package khanh.recyclerviewmvpexamples.Core;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import khanh.recyclerviewmvpexamples.Model.API.APISevercis;
import khanh.recyclerviewmvpexamples.Model.Country;
import khanh.recyclerviewmvpexamples.Model.CountryRss;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient implements GetDataCountry.RetrofitsClient{
    private GetDataCountry.onGetDataList onGetDataList;
    private List<CountryRss> allCountryress = new ArrayList<>();
    private List<String> allCountt = new ArrayList<>();
    private static final String URL = "https://uaevisa-online.org";

    public APIClient(GetDataCountry.onGetDataList onGetDataList) {
        this.onGetDataList = onGetDataList;
    }

    @Override
    public void initRetrofitCall(Context ct, String url) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        APISevercis api = retrofit.create(APISevercis.class);
        Call<Country> call = api.getDataCountry();
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                Country jsonResponse = response.body();
                allCountryress = jsonResponse.getCountry();
                for(int i=0;i<allCountryress.size();i++){
                    allCountt.add(allCountryress.get(i).getName());
                }
                Log.d("Data", "Refreshed");
                onGetDataList.onSuccess("List Size: " + allCountt.size(), allCountryress);
            }

            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                Log.v("Error",t.getMessage());
                onGetDataList.onError(t.getMessage());
            }
        });
    }
}
