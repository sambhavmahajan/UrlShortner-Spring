package com.github.sambhavmahajan.urlshortner;

import com.github.sambhavmahajan.urlshortner.entities.Url;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {
    private final UrlRepo repo;

    public UrlService(UrlRepo repo) {
        this.repo = repo;
    }
    public void save(Url url) {
        repo.save(url);
    }
    @Cacheable(value = "urls", key = "#lnk")
    public Optional<Url> findByLnk(String lnk) {
        return repo.findUrlByLnk(lnk);
    }
}