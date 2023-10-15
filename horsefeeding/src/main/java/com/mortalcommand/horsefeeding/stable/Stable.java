package com.mortalcommand.horsefeeding.stable;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stable")
public class Stable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

   /* @OneToMany(mappedBy = "stable")
    private List<Horse> horses;*/

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
}
