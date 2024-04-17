package com.wracce.onlinedairy.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table()
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 40, columnDefinition = "text")
    private String name;


    @OneToMany(mappedBy = "style", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

}
