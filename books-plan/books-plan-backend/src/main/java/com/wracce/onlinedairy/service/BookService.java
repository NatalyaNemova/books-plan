package com.wracce.onlinedairy.service;

import com.wracce.onlinedairy.enity.Book;
import com.wracce.onlinedairy.enity.Note;
import com.wracce.onlinedairy.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final NoteService noteService;


    public Book update(Book rec) {
        noteService.setContent(rec.getNote().getId(),rec.getNote().getContent());
        return bookRepository.save(rec);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    public Book create(Book rec) {
        Note n = new Note();
        n.setContent(rec.getNote().getContent());
        rec.setNote(noteService.create(n));
        return  bookRepository.save(rec);
    }

    public List<Book> findAll() {
        return  bookRepository.findAll();
    }

}
