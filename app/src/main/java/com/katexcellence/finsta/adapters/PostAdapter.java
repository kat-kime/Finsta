package com.katexcellence.finsta.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.katexcellence.finsta.R;
import com.katexcellence.finsta.models.Post;
import com.parse.ui.widget.ParseImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate custom layout
        View postView = inflater.inflate(R.layout.item_user_post, parent, false);

        return new ViewHolder(postView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Post post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ParseImageView ivUserProfile;
        public ParseImageView ivImage;
        public TextView tvUsername;
        public TextView tvCaption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivUserProfile = (ParseImageView) itemView.findViewById(R.id.ivUserProfile);
            ivImage = (ParseImageView) itemView.findViewById(R.id.ivImage);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsername);
            tvCaption = (TextView) itemView.findViewById(R.id.tvCaption);
        }

        public void bind(final Post post) {

            tvUsername.setText(post.getUsername());
            tvCaption.setText(post.getCaption());
            ivUserProfile.setParseFile(post.getProfilePic());
            ivUserProfile.loadInBackground();
            ivImage.setParseFile(post.getImage());
            ivImage.loadInBackground();


        }
    }


    }
