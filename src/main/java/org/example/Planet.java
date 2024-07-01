package org.example;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private String id;
    @Pattern(regexp = "[A-Z0-9]{1,10}")

    @Column(nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}