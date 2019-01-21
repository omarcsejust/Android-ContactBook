package com.example.omar.contactbook.ui.CategorySetting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;

import java.util.List;

public class CategorySettingAdapter extends RecyclerView.Adapter<CategorySettingAdapter.RecyclerViewHolder> {

    List<Category> categories;
    Context context;

    public CategorySettingAdapter(Context mContext, List<Category> mCategories){
        this.categories = mCategories;
        this.context = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_item_category_setting,viewGroup,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int position) {
        recyclerViewHolder.textViewGroupName.setText(categories.get(position).getCatName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewGroupName;
        public RecyclerViewHolder(View view){
            super(view);
            textViewGroupName=view.findViewById(R.id.text_view_group_name);
        }
    }
}
