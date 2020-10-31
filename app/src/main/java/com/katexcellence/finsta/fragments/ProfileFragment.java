package com.katexcellence.finsta.fragments;

import android.util.Log;

import com.katexcellence.finsta.models.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends HomeFragment{

    @Override
    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED);

        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts");
                }

                for (Post post : posts) {
                    Log.i(TAG, "Post: " + post.getCaption() + "  From: " + post.getUser().getUsername() + "\nUsername again: " + post.getProfilePic());

                }

                postList.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
