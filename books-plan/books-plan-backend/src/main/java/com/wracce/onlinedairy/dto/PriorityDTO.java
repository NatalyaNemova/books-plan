package com.wracce.onlinedairy.dto;

import com.wracce.onlinedairy.enity.Priority;
import com.wracce.onlinedairy.enity.Style;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriorityDTO {
    private Long id;


    private String desc;

    public static Priority toEntity(PriorityDTO dto) {
        return new Priority(dto.getId(),dto.getDesc(),new ArrayList<>());
    }

    public static PriorityDTO toDTO(Priority entity) {
        return new PriorityDTO(entity.getId(),entity.getDesc());
    }

}
