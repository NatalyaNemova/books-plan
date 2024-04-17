package com.wracce.onlinedairy.service;

import com.wracce.onlinedairy.enity.Priority;
import com.wracce.onlinedairy.enity.Style;
import com.wracce.onlinedairy.repository.PriorityRepository;
import com.wracce.onlinedairy.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public List<Priority> findAll() {
        return priorityRepository.findAll();
    }
}
