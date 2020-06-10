package com.example.sit305_assessmenttwo;

public class youtubeConfig {
    private static final String API_KEY="AIzaSyBux4dcZ9JzyYS4GeOxvuRoR7fPYeb_zpU";

    public youtubeConfig() {
    }

    //This is to protect the API Key from being taken form users
    public static String getApiKey() {
        return API_KEY;
    }
}
