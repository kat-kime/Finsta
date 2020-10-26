package com.katexcellence.finsta;

import com.katexcellence.finsta.models.Post;
import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;
import android.util.Log;

public class ParseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("659oNQ3EdLUw34r7dpMJRS9RE2jIb3WEZ5nJodcc")
                .clientKey("zQUwAvC5DC7iVQDMjfhKUR88gTbWVYtofFGGnKtO")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
