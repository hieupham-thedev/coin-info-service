package com.example.coininfoservice.config;

public class AppConfig {

    private String coinApiUrl;
    private String apiKey;

    public String getCoinApiUrl() {
        return coinApiUrl;
    }

    public AppConfig setCoinApiUrl(String coinApiUrl) {
        this.coinApiUrl = coinApiUrl;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public AppConfig setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }
}
