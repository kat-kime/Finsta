package com.katexcellence.finsta.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.katexcellence.finsta.R;
import com.katexcellence.finsta.models.Post;
import com.parse.ParseFile;
import com.parse.ui.widget.ParseImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user_post, parent, false);

        return new ViewHolder(view);
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

    // Clean all elements of the recycler

    public void clear() {
        posts.clear();
        notifyDataSetChanged();

    }


// Add a list of items -- change to type used

    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivUserProfile;
        public ImageView ivImage;
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

            ParseFile image = post.getImage();

            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }


            ParseFile profilePic = post.getProfilePic();

            if (profilePic != null) {
                Glide.with(context).load(post.getProfilePic().getUrl()).into(ivUserProfile);
            }

        }
    }


    }
