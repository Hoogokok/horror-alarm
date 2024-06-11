package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "theaters")
@Entity
@Getter
public class Theaters {

    @Id
    private Long id;
    private String name;

    public Theaters() {
    }

    public Theaters(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
