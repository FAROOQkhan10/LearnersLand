package com.farooqkhan.learnersland.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farooqkhan.learnersland.Model.categoryVideoModel;
import com.farooqkhan.learnersland.R;
import com.farooqkhan.learnersland.Video;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class categoryVideoAdapter extends RecyclerView.Adapter<categoryVideoAdapter.viewHolder> {
    ArrayList<categoryVideoModel> list;
    Context context;
    public categoryVideoAdapter(ArrayList<categoryVideoModel>list,Context context) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_video_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
             categoryVideoModel model = list.get(position);
             holder.textView.setText(model.getCategoryVideoName());
             Picasso.get()
                     .load(model.getCategoryVideoImg())
                     .into(holder.imageView);
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(context,Video.class);
                     intent.putExtra("catId",model.getCategoryVideoId());
                     intent.putExtra("categoryVideoUrl",model.getCategoryVideoUrl());
                     context.startActivity(intent);
                 }
             });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_view);
            textView=itemView.findViewById(R.id.text1);
        }
    }

}
