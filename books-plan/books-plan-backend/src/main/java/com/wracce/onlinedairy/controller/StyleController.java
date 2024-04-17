package com.wracce.onlinedairy.controller;

import com.wracce.onlinedairy.dto.StyleDTO;
import com.wracce.onlinedairy.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/styles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class StyleController {
    private final StyleService styleService;

    @GetMapping
    public List<StyleDTO> findAll() {
        return styleService.findAll().stream().map(StyleDTO::toDTO).toList();
    }
}
