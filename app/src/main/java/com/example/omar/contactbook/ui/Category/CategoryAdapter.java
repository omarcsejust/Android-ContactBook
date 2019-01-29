package com.example.omar.contactbook.ui.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;
import com.example.omar.contactbook.ui.CategorySetting.CategorySettingAdapter;
import com.example.omar.contactbook.ui.Contact.ContactActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecyclerViewHolder> {

    List<Category> categories;
    Context context;

    public CategoryAdapter(Context mContext, List<Category> mCategories){
        this.categories = mCategories;
        this.context = mContext;
    }

    @Override
    public CategoryAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_item_category,viewGroup,false);
        CategoryAdapter.RecyclerViewHolder recyclerViewHolder=new CategoryAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, final int position) {
        recyclerViewHolder.textViewGroupName.setText(categories.get(position).getCatName());
        recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ContactActivity.class);
                intent.putExtra("GROUP_ID",categories.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewGroupName;
        public RecyclerViewHolder(View view){
            super(view);
            textViewGroupName=view.findViewById(R.id.tv_group_name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
