package com.example.languagelearningapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.languagelearningapp.models.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView quizQuestion;
    private RadioGroup radioGroup;
    private Button submitButton;

    private List<Quiz> quizzes;
    private int currentQuizIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizQuestion = findViewById(R.id.tv_quiz_question);
        radioGroup = findViewById(R.id.rg_answers);
        submitButton = findViewById(R.id.btn_submit);

        // Sample quizzes
        quizzes = new ArrayList<>();
        quizzes.add(new Quiz("What is the capital of France?", List.of("London", "Berlin", "Paris", "Madrid"), "Paris"));
        quizzes.add(new Quiz("What is the largest planet in our solar system?", List.of("Earth", "Saturn", "Jupiter", "Uranus"), "Jupiter"));

        displayQuiz();

        submitButton.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton radioButton = findViewById(selectedId);
            String answer = radioButton.getText().toString();

            if (answer.equals(quizzes.get(currentQuizIndex).getAnswer())) {
                score++;
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrect. The correct answer is " + quizzes.get(currentQuizIndex).getAnswer(), Toast.LENGTH_SHORT).show();
            }

            currentQuizIndex++;
            if (currentQuizIndex < quizzes.size()) {
                displayQuiz();
            } else {
                // Display final score
                Toast.makeText(this, "Quiz finished! Your score is " + score + "/" + quizzes.size(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void displayQuiz() {
        Quiz quiz = quizzes.get(currentQuizIndex);
        quizQuestion.setText(quiz.getQuestion());

        // Clear previous radio buttons
        radioGroup.removeAllViews();

        // Add radio buttons dynamically
        for (String option : quiz.getOptions()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioGroup.addView(radioButton);
        }
    }
}