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
@Table
//проритет
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 150, columnDefinition = "text")
    private String desc;

    @OneToMany(mappedBy = "priority", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

}
