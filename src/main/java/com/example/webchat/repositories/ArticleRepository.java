package com.example.webchat.repositories;


import com.example.webchat.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Articles, Long> {
    List<Articles> findByTitle(String title);
}
