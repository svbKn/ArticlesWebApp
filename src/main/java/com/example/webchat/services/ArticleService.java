package com.example.webchat.services;

import com.example.webchat.models.Article;
import com.example.webchat.models.User;
import com.example.webchat.repositories.ArticleRepository;
import com.example.webchat.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ArticleRepository productRepository;
    private final UserRepository userRepository;

    public List<Article> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }


public void saveProduct(Principal principal, Article product) throws IOException {
    product.setUser(getUserByPrincipal(principal));
    log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());
    productRepository.save(product);
}
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    public void deleteProduct(User user, Long id) {
        Article product = productRepository.findById(id)
                .orElse(null);
        if (product != null) {
            if (product.getUser().getId().equals(user.getId())) {
                productRepository.delete(product);
                log.info("Product with id = {} was deleted", id);
            } else {
                log.error("User: {} haven't this product with id = {}", user.getEmail(), id);
            }
        } else {
            log.error("Product with id = {} is not found", id);
        }    }

    public Article getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
