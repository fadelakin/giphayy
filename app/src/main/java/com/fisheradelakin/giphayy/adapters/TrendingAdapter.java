package com.fisheradelakin.giphayy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fisheradelakin.giphayy.Constants;
import com.fisheradelakin.giphayy.R;
import com.fisheradelakin.giphayy.model.Datum;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import java.util.List;

/**
 * Created by Fisher on 9/29/15.
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {

    private Context mContext;
    private List<Datum> mData;

    public TrendingAdapter(Context context, List<Datum> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.trending_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Datum datum = mData.get(position);
        holder.mProgressView.startAnimation();
        Glide.with(mContext).load(datum.getImages().getFixedWidthDownsampled().getUrl()).asGif().into(holder.mGif);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mGif;
        CircularProgressView mProgressView;

        public ViewHolder(View itemView) {
            super(itemView);

            mGif = (ImageView) itemView.findViewById(R.id.trending_gif);
            mProgressView = (CircularProgressView) itemView.findViewById(R.id.progress_view);
        }

        @Override
        public void onClick(View view) {
            Intent gifIntent = new Intent(Intent.ACTION_SEND);
            gifIntent.setType("text/*");
            gifIntent.putExtra(Intent.EXTRA_TEXT, mData.get(getLayoutPosition())
                    .getImages()
                    .getFixedHeight()
                    .getUrl());
            mContext.startActivity(Intent.createChooser(gifIntent, "Share with... "));
        }
    }
}
