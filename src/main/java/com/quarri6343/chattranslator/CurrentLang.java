package com.quarri6343.chattranslator;

public enum CurrentLang {
    JA("&source=en&target=ja"),
    CN("&source=ja&target=zh"),
    EN("&source=ja&target=en"),
    FI("&source=ja&target=fi");

    public final String url;

    CurrentLang(String url) {
        this.url = url;
    }
}
