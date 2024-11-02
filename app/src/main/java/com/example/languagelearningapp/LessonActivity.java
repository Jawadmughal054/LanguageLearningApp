package com.example.languagelearningapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.languagelearningapp.models.Lesson;
import com.example.languagelearningapp.models.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class LessonActivity extends AppCompatActivity {
    private TextView lessonTitle;
    private TextView lessonContent;
    private Button nextButton;

    private List<Lesson> lessons;
    private int currentLessonIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        lessonTitle = findViewById(R.id.tv_lesson_title);
        lessonContent = findViewById(R.id.tv_lesson_content);
        nextButton = findViewById(R.id.btn_next);

        // Sample lessons
        lessons = new ArrayList<>();
        lessons.add(new Lesson("Lesson 1", "Welcome to Lesson 1!"));
        lessons.add(new Lesson("Lesson 2", "Welcome to Lesson 2!"));

        displayLesson();

        nextButton.setOnClickListener(v -> {
            currentLessonIndex++;
            if (currentLessonIndex < lessons.size()) {
                displayLesson();
            } else {
                UserProfile UserProfile = null;
                UserProfile.incrementProgress(); // Increment progress after completing a lesson
                finish();
            }
        });
    }

    private void displayLesson() {
        Lesson lesson = lessons.get(currentLessonIndex);
        lessonTitle.setText(lesson.getTitle());
        lessonContent.setText(lesson.getContent());
    }
}