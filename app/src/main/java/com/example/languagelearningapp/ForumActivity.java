package com.example.languagelearningapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {
    private ListView forumPosts;

    private List<String> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        forumPosts = findViewById(R.id.lv_forum_posts);

        // Sample forum posts
        posts = new ArrayList<>();
        posts.add("Hello, everyone!");
        posts.add("How do I learn a new language?");
        posts.add("What's the best way to practice speaking?");

        // Create an adapter for the ListView
        ForumAdapter adapter = new ForumAdapter(this, posts);
        forumPosts.setAdapter(adapter);
    }
}