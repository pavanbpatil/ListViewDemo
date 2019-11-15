package com.uft.listviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uft.listviewdemo.R;
import com.uft.listviewdemo.dto.Rows;

import java.util.List;

public class CountryDataListAdapter extends RecyclerView.Adapter<CountryDataListAdapter.ViewHolder> {

    private List<Rows> rowData;
    private LayoutInflater mInflater;
    private Context context;

    // data is passed into the constructor
    public CountryDataListAdapter(Context context, List<Rows> rowData) {
        this.mInflater = LayoutInflater.from(context);
        this.rowData = rowData;
        this.context = context;
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

            if (rowData.get(position).getTitle() != null)
                holder.tvTitle.setText(rowData.get(position).getTitle());
            else
                holder.tvTitle.setText(R.string.na);

            if (rowData.get(position).getDescription() != null)
                holder.tvDescription.setText(rowData.get(position).getDescription());
            else
                holder.tvDescription.setText(R.string.na);

            if (rowData.get(position).getImageHref() != null) {
                Glide.with(context).
                        load(rowData.get(position).getImageHref())
                        .apply(new RequestOptions().placeholder(R.drawable.image_placeholder))
                        .into(holder.ivPhoto);
            } else {
                holder.ivPhoto.setImageDrawable(context.getResources().getDrawable(R.drawable.image_placeholder));
            }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return rowData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle, tvDescription;
        ImageView ivPhoto;
        RelativeLayout rlRoot;

        ViewHolder(View itemView) {
            super(itemView);
            rlRoot = itemView.findViewById(R.id.rlRoot);
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