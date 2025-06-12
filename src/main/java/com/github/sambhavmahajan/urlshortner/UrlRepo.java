package com.github.sambhavmahajan.urlshortner;

import com.github.sambhavmahajan.urlshortner.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<Url, Long> {
    Optional<Url> findUrlByLnk(String lnk);
}
