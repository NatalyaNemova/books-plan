package com.wracce.onlinedairy.dto;

import com.wracce.onlinedairy.enity.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;

    private String header;

    private String author;

    private NoteDTO note;

    private StyleDTO style;

    private PriorityDTO priority;

    private ColorDTO color;

    public static Book toEntity(BookDTO dto) {
        Book dr = new Book();
        dr.setId(dto.getId());
        dr.setHeader(dto.getHeader());
        dr.setAuthor(dto.getAuthor());
        dr.setNote(NoteDTO.toEntity(dto.getNote()));
        dr.setStyle(StyleDTO.toEntity(dto.getStyle()));
        dr.setPriority(PriorityDTO.toEntity(dto.getPriority()));
        dr.setColor(ColorDTO.toEntity(dto.getColor()));

        return dr;
    }

    public static BookDTO toDTO(Book entity) {
        BookDTO dr = new BookDTO();
        dr.setId(entity.getId());
        dr.setHeader(entity.getHeader());
        dr.setAuthor(entity.getAuthor());
        dr.setNote(NoteDTO.toDTO(entity.getNote()));
        dr.setStyle(StyleDTO.toDTO(entity.getStyle()));
        dr.setPriority(PriorityDTO.toDTO(entity.getPriority()));
        dr.setColor(ColorDTO.toDTO(entity.getColor()));

        return dr;

    }

}
