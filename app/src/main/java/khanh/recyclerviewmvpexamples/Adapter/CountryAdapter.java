package khanh.recyclerviewmvpexamples.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import khanh.recyclerviewmvpexamples.Model.CountryRss;
import khanh.recyclerviewmvpexamples.R;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewsHolder> {
    private Context ct;
    private List<CountryRss> dt;

    public CountryAdapter(Context ct, List<CountryRss> dt) {
        this.ct = ct;
        this.dt = dt;
    }

    @Override
    public MyViewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.card_item, parent, false);
        return new MyViewsHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewsHolder holder, int position) {
        holder.tvName.setText(dt.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dt.size();
    }

    public class MyViewsHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public MyViewsHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_country_name);
        }
    }
}
