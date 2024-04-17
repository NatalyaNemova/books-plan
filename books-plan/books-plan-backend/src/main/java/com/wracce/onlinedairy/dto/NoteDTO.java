package com.wracce.onlinedairy.dto;

import com.wracce.onlinedairy.enity.Book;
import com.wracce.onlinedairy.enity.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long id;

    private String content;


    public static Note toEntity(NoteDTO dto) {
        return new Note(
                dto.getId(),
                dto.getContent(),
                new Book());
    }

    public static NoteDTO toDTO(Note entity) {
        return new NoteDTO(
                entity.getId(),
                entity.getContent()
                );
    }

}
