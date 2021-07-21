package com.example.moviestreamingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviestreamingapp.MovieDetail;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.models.AllCategory;
import com.example.moviestreamingapp.models.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    Context context;
    List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_recycler_row_item,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);

        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        //Buraya biz serverdən şəkil gətirəcəyik glide kitabxanasının köməyi ilə
        Glide.with(context).load(categoryItemList.get(position).getImageUrl()).into(holder.itemImage);

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetail.class);
                intent.putExtra("movieID",categoryItemList.get(position).getId());
                intent.putExtra("movieName",categoryItemList.get(position).getMovieName());
                intent.putExtra("movieImageURL",categoryItemList.get(position).getImageUrl());
                intent.putExtra("movieFileURL",categoryItemList.get(position).getFileUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;

      public ItemViewHolder(@NonNull View itemView) {
          super(itemView);

          itemImage = itemView.findViewById(R.id.item_image);
      }
  }
}
