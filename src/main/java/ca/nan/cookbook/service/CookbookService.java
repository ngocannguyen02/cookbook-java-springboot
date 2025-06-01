package ca.nan.cookbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.nan.cookbook.model.Cookbook;
import ca.nan.cookbook.repository.CookbookRepository;

@Service
public class CookbookService {

    private final CookbookRepository cookbookRepository;

    @Autowired
    public CookbookService(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    public List<Cookbook> getAllCookbooks() {
        return cookbookRepository.findAll();
    }

    public Optional<Cookbook> getCookbookById(Long id) {
        return cookbookRepository.findById(id);
    }

    public Cookbook createCookbook(Cookbook cookbook) {
        return cookbookRepository.save(cookbook);
    }

    public void deleteCookbook(Long id) {
        if (cookbookRepository.existsById(id)) {
            cookbookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cookbook not found with id: " + id);
        }
    }
}