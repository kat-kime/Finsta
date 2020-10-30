package com.katexcellence.finsta.models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
    // Ensure that your subclass has a public default constructor

    public static final String KEY_USER = "user";
    public static final String KEY_CAPTION = "caption";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_PROFILE_PIC = "profilepic";

    public Post() {
        // Empty constructor
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public String getUsername() {
        return getUser().getUsername();
    }

    public String getCaption() {
        return getString(KEY_CAPTION);
    }

    public void setCaption(String caption) {
        put(KEY_CAPTION, caption);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile file) {
        put(KEY_IMAGE, file);
    }

    // Grab the direct file of the user's profile image
    public ParseFile getProfilePic() {
        ParseFile profile = getUser().getParseFile(KEY_PROFILE_PIC);
        return profile;
    }



}
