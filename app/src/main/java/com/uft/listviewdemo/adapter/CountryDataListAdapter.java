package com.uft.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uft.listviewdemo.R;
import com.uft.listviewdemo.dto.Rows;

import java.util.List;

public class CountryDataListAdapter extends RecyclerView.Adapter<CountryDataListAdapter.ViewHolder> {

    private List<Rows> mData;
    private LayoutInflater mInflater;
    private Context context;
    // data is passed into the constructor
    public CountryDataListAdapter(Context context, List<Rows> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context =context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.country_data_list_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mData.get(position).getTitle() != null)
            holder.tvTitle.setText(mData.get(position).getTitle());
        else
            holder.tvTitle.setText(R.string.na);

        if (mData.get(position).getDescription() != null)
            holder.tvDescription.setText(mData.get(position).getDescription());
        else
            holder.tvDescription.setText(R.string.na);

        if (mData.get(position).getDescription() != null) {
            Glide.with(context).
                    load(mData.get(position).getImageHref())
                    .apply(new RequestOptions().placeholder(R.drawable.image_placeholder))
                    .into(holder.ivPhoto);
        }
        else {
            holder.ivPhoto.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_background));
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle, tvDescription;
        ImageView ivPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Add operation on click here
        }
    }

}