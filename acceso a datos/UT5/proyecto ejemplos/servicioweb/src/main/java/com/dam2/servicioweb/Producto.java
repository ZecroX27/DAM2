package com.dam2.servicioweb;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity(name = "productos")
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private float price;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Producto() {
    }

    public Producto(String name, String description, String category, float price, LocalDateTime creationDate) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Producto(Long id, String name, String description, String category, float price, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                '}';
    }
}
