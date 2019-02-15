package khanh.recyclerviewmvpexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import khanh.recyclerviewmvpexamples.Adapter.CountryAdapter;
import khanh.recyclerviewmvpexamples.Core.GetDataCountry;
import khanh.recyclerviewmvpexamples.Core.Presenter;
import khanh.recyclerviewmvpexamples.Model.CountryRss;

public class MainActivity extends AppCompatActivity implements GetDataCountry.Views {

    private Presenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CountryAdapter adap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        presenter = new Presenter(this);
        presenter.getDataFromURL(this, "");
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String msg, List<CountryRss> list) {
        adap = new CountryAdapter(this, list);
        recyclerView.setAdapter(adap);
    }

    @Override
    public void onGetDataError(String msg) {
        Log.d("xxxxxxx", msg);
    }
}
