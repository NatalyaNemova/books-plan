package com.wracce.onlinedairy.controller;

import com.wracce.onlinedairy.dto.NoteDTO;
import com.wracce.onlinedairy.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class NoteController {
    private final NoteService noteService;


    @PostMapping
    public NoteDTO create(@RequestBody NoteDTO noteDTO) {
        return NoteDTO.toDTO(noteService.create(NoteDTO.toEntity(noteDTO)));
    }

    @PutMapping
    public NoteDTO update(@RequestBody NoteDTO noteDTO) {
        return NoteDTO.toDTO(noteService.update(NoteDTO.toEntity(noteDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
