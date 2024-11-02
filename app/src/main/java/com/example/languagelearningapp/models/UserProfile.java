package com.example.languagelearningapp.models;

import android.content.Context;
import android.content.SharedPreferences;

public class UserProfile {
    private static final String PREFS_NAME = "User ProfilePrefs";
    private static final String KEY_PROGRESS = "progress";
    private static final String KEY_ACHIEVEMENTS = "achievements";

    private final SharedPreferences sharedPreferences;

    public UserProfile(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public int getProgress() {
        return sharedPreferences.getInt(KEY_PROGRESS, 0);
    }

    public String getAchievements() {
        return sharedPreferences.getString(KEY_ACHIEVEMENTS, "No achievements yet");
    }

    public void incrementProgress() {
        int progress = getProgress() + 1;
        sharedPreferences.edit().putInt(KEY_PROGRESS, progress).apply();
    }

    public void addAchievement(String achievement) {
        String achievements = getAchievements();
        achievements += achievement + "; "; // Append new achievement
        sharedPreferences.edit().putString(KEY_ACHIEVEMENTS, achievements).apply();
    }
}