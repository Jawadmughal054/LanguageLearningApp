package com.example.languagelearningapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.languagelearningapp.models.UserProfile;

public class ProfileActivity extends AppCompatActivity {
    private TextView profileProgress;
    private TextView profileAchievements;

    private UserProfile userProfile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileProgress = findViewById(R.id.tv_profile_progress);
        profileAchievements = findViewById(R.id.tv_profile_achievements);

        userProfile = new UserProfile(this);

        displayProfile();
    }

    private void displayProfile() {
        profileProgress.setText("Progress: " + userProfile.getProgress());
        profileAchievements.setText("Achievements: " + userProfile.getAchievements());
    }
}