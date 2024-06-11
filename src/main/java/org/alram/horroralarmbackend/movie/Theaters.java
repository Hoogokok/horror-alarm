package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Table(name = "theaters")
@Entity
@Getter
public class Theaters {

    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "theatersId")
    private final List<MovieTheaters> movieTheaters = new ArrayList<>();

    public Theaters() {
    }

    public Theaters(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
