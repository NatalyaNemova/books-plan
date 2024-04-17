package com.wracce.onlinedairy.controller;

import com.wracce.onlinedairy.dto.BookDTO;
import com.wracce.onlinedairy.dto.BookDTO;
import com.wracce.onlinedairy.dto.StyleDTO;
import com.wracce.onlinedairy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll().stream().map(BookDTO::toDTO).toList();
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO bookDTO) {
        return BookDTO.toDTO(bookService.create(BookDTO.toEntity(bookDTO)));
    }

    @PutMapping
    public BookDTO update(@RequestBody BookDTO bookDTO) {
        return BookDTO.toDTO(bookService.update(BookDTO.toEntity(bookDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
