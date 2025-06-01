package ca.nan.cookbook.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.nan.cookbook.model.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {
}