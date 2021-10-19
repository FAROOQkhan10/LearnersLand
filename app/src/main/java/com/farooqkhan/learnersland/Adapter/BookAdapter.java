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

import com.farooqkhan.learnersland.BookView;
import com.farooqkhan.learnersland.Model.BookModel;
import com.farooqkhan.learnersland.Model.categoryModel;
import com.farooqkhan.learnersland.R;
import com.farooqkhan.learnersland.VideoList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.categoryViewHolder> {
    Context context;
    ArrayList<BookModel> categoryModels;
    public BookAdapter(Context context, ArrayList<BookModel> categoryModels) {
        this.context=context;
        this.categoryModels=categoryModels;
    }
    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category,null);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        BookModel model=categoryModels.get(position);
        holder.textView.setText(model.getBookName());
        Picasso.get()
                .load(model.getImg())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookView.class);
                intent.putExtra("url",model.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_view);
            textView = itemView.findViewById(R.id.text1);
        }
    }
}
