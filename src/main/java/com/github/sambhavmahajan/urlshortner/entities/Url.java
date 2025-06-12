package com.github.sambhavmahajan.urlshortner.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Url {
    @Id
    @GeneratedValue
    private long id;
    private String lnk;
    private LocalDateTime createdOn;
    private String urlToRedirect;
    public Url() {
        lnk =  UUID.randomUUID().toString().substring(0, 5);
        createdOn = LocalDateTime.now();
    }
    public Url(String urlToRedirect) {
        this();
        this.urlToRedirect = urlToRedirect;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getLnk() {
        return lnk;
    }
    public void setLnk(String lnk) {
        this.lnk = lnk;
    }
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
    public boolean isValid() {
        return Duration.between(createdOn, LocalDateTime.now().plusDays(1)).toDays() < 1;
    }
    public String getUrlToRedirect() {
        return urlToRedirect;
    }
    public void setUrlToRedirect(String urlToRedirect) {
        this.urlToRedirect = urlToRedirect;
    }
}
