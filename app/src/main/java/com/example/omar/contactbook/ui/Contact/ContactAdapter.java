package com.example.omar.contactbook.ui.Contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omar.contactbook.R;
import com.example.omar.contactbook.data.Models.Category;
import com.example.omar.contactbook.data.Models.Contact;
import com.example.omar.contactbook.ui.Category.CategoryAdapter;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.RecyclerViewHolder> {

    List<Contact> contacts;
    Context context;

    public ContactAdapter(Context mContext, List<Contact> mContacts){
        this.context = mContext;
        this.contacts = mContacts;
    }

    @NonNull
    @Override
    public ContactAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_item_contact,viewGroup,false);
        ContactAdapter.RecyclerViewHolder recyclerViewHolder=new ContactAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.textViewContactName.setText(contacts.get(i).getContactName());
        recyclerViewHolder.textViewContactNumber.setText(contacts.get(i).getContactNumber());
        if (contacts.get(i).getGenderId() == 3){
            recyclerViewHolder.imageViewContactGenderAvatar.setImageResource(R.drawable.icon_female_user);
        }else {
            recyclerViewHolder.imageViewContactGenderAvatar.setImageResource(R.drawable.icon_male_user);
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textViewContactName, textViewContactNumber;
        ImageView imageViewContactGenderAvatar;
        public RecyclerViewHolder(View view){
            super(view);
            textViewContactName = view.findViewById(R.id.text_view_contact_name);
            textViewContactNumber = view.findViewById(R.id.text_view_contact_number);
            imageViewContactGenderAvatar = view.findViewById(R.id.image_view_user_gender_avatar);
        }
    }
}
