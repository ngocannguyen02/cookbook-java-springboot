package ca.nan.cookbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.nan.cookbook.model.Cookbook;
import ca.nan.cookbook.service.CookbookService;

@RestController
@RequestMapping("/api/cookbooks")
public class CookbookController {

    @Autowired
    private CookbookService cookbookService;

    @GetMapping
    public List<Cookbook> getAllCookbooks() {
        return cookbookService.getAllCookbooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cookbook> getCookbookById(@PathVariable Long id) {
        Optional<Cookbook> cookbook = cookbookService.getCookbookById(id);
        return cookbook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cookbook createCookbook(@RequestBody Cookbook cookbook) {
        return cookbookService.createCookbook(cookbook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCookbook(@PathVariable Long id) {
        cookbookService.deleteCookbook(id);
        return ResponseEntity.noContent().build();
    }
}