package com.example.languagelearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartLesson = findViewById(R.id.btn_start_lesson);
        Button btnStartQuiz = findViewById(R.id.btn_start_quiz);
        Button btnProfile = findViewById(R.id.btn_profile);
        Button btnForum = findViewById(R.id.btn_forum);

        btnStartLesson.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LessonActivity.class);
            startActivity(intent);
        });

        btnStartQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        btnForum.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForumActivity.class);
            startActivity(intent);
        });
    }
}