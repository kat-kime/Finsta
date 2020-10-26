package com.katexcellence.finsta.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.katexcellence.finsta.R;

public class UserPostAdapter {


    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        TextView tvUsername;
        ImageView ivUserProfile;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivUserProfile = itemView.findViewById(R.id.ivUserProfile);
            ivImage = itemView.findViewById(R.id.ivImage);

        }
    }
}
