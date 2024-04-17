package com.wracce.onlinedairy.dto;

import com.wracce.onlinedairy.enity.Priority;
import com.wracce.onlinedairy.enity.Style;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StyleDTO {
    private Long id;

    private String name;


    public static Style toEntity(StyleDTO dto) {
        return new Style(dto.getId(),dto.getName(),new ArrayList<>());
    }

    public static StyleDTO toDTO(Style entity) {
        return new StyleDTO(entity.getId(),entity.getName());
    }



}
