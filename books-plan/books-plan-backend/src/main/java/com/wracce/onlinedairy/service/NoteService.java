package com.wracce.onlinedairy.service;

import com.wracce.onlinedairy.enity.Note;
import com.wracce.onlinedairy.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public void delete(long id) {
        noteRepository.deleteById(id);
    }

    public Note setContent(Long id, String content) {
        Note n = noteRepository.findById(id).orElseThrow();
        n.setContent(content);
        noteRepository.save(n);
        return n;
    }
}
