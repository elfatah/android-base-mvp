package net.derohimat.samplebasemvp.view.fragment.detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;
import net.derohimat.samplebasemvp.widget.BaseImageView;
import net.derohimat.samplebasemvp.R;
import net.derohimat.samplebasemvp.data.remote.model.forecast.List;
import net.derohimat.samplebasemvp.view.activity.main.MainActivity;

import butterknife.BindView;


/**
 * Created by deni rohimat on 17/02/15.
 */
public class DetailRecyclerAdapter extends BaseRecyclerAdapter<List, DetailRecyclerAdapter.DetailHolder> {

    public DetailRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.details_row;
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }

    public static class DetailHolder extends BaseItemViewHolder<List> {

        @BindView(R.id.row_textView_forecast)
        TextView row_textView_forecast;

        @BindView(R.id.row_imageView_forecast)
        BaseImageView row_imageView_forecast;

        public DetailHolder(Context context, View itemView, BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                            BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
            super(itemView, itemClickListener, longItemClickListener);
            this.mContext = context;
        }

        @Override
        public void bind(List mForecast) {

            row_imageView_forecast.setImageResource(MainActivity.getIcon(mForecast.getWeather().get(0).getId()));

            row_textView_forecast.setText(String.format("%s %s %s", mForecast.getDtTxt(), mForecast.getMain().getTempMin(), mForecast.getMain().getTempMax()));
        }
    }

}
