package com.spring.blog.ricette.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ricette")
public class Recipe {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String title;
    @NotBlank(message = "Insert ingredients")
    private String ingredients;
    @NotBlank(message = "Add photo")
    private String urlImg;
    @NotBlank(message = "Estimate time preperation")
    private int preperationTime;
    @Max(10)
    @Min(1)
    @NotNull
    private int portion;
    @Column(length = 350)
    @NotBlank(message = "Insert Description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getPreperationTime() {
        return preperationTime;
    }

    public void setPreperationTime(int preperationTime) {
        this.preperationTime = preperationTime;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
