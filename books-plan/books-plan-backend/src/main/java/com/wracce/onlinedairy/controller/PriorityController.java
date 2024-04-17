package com.wracce.onlinedairy.controller;

import com.wracce.onlinedairy.dto.PriorityDTO;
import com.wracce.onlinedairy.dto.StyleDTO;
import com.wracce.onlinedairy.enity.Priority;
import com.wracce.onlinedairy.service.PriorityService;
import com.wracce.onlinedairy.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/priorities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class PriorityController {
    private final PriorityService priorityService;

    @GetMapping
    public List<PriorityDTO> findAll() {
        return priorityService.findAll().stream().map(PriorityDTO::toDTO).toList();
    }
}
