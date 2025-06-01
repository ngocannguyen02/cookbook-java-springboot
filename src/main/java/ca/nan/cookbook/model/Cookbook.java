package ca.nan.cookbook.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cookbooks") // Optional: Specify table name explicitly
public class Cookbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String[] ingredients;
    private String[] instructions;

    // No-argument constructor
    public Cookbook() {
    }

    // All-argument constructor (optional, for convenience)
    public Cookbook(String title, String author, String[] ingredients, String[] instructions) { 
        this.title = title;
        this.author = author;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }

    public void setInstructions(String[] instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cookbook)) return false;
        Cookbook cookbook = (Cookbook) o;
        return Objects.equals(id, cookbook.id) &&
               Objects.equals(title, cookbook.title) &&
               Objects.equals(author, cookbook.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
    @Override
    public String toString() {
        return "Cookbook{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", ingredients=" + String.join(", ", ingredients) +
               ", instructions=" + String.join(", ", instructions) +
               '}';
    }
}
