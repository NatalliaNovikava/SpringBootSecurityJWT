package com.example.spring.boot.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tasks")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    protected Item() {}

    public Item(String description) {
        super();
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", description='" + description + '\'' + '}';
    }
}
