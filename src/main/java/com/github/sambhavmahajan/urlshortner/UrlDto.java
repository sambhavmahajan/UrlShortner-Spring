package com.github.sambhavmahajan.urlshortner;

import java.util.UUID;

public class UrlDto {
    public String url = null;
    public String getText() {
        if(url == null) return "";
        return "Shortened Url: " + url;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
