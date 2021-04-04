package com.sh.mvvmpractise;

import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.UserViewHolder> {
    private UserPojo[] userPojos;

    public User_Adapter(UserPojo[] userPojos) {
        this.userPojos = userPojos;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.user_list,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.name.setText(userPojos[position].getLogin());
        holder.id.setText(String.valueOf(userPojos[position].getId()));
        holder.userUrl.setText(userPojos[position].getUrl());

        Glide.with(holder.imageView.getContext()).load(userPojos[position].getAvatarUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return userPojos.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        TextView name,id,userUrl;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.images);
            name=itemView.findViewById(R.id.name);
            id = itemView.findViewById(R.id.name2);
            userUrl=itemView.findViewById(R.id.name3);
        }
    }
}
