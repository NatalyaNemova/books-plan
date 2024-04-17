package com.wracce.onlinedairy.service;

import com.wracce.onlinedairy.enity.Priority;
import com.wracce.onlinedairy.enity.Style;
import com.wracce.onlinedairy.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StyleService {

    private final StyleRepository styleRepository;

    public List<Style> findAll() {
        return styleRepository.findAll();
    }
}
