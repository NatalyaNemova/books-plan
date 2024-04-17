package com.wracce.onlinedairy.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String header;

    private String author;


    @ManyToOne
    @JoinColumn(name = "style_id")
    private Style style;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToOne()
    @JoinColumn(name = "note_id")
    private Note note;

}
