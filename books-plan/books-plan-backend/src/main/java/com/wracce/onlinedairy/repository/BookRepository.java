package com.wracce.onlinedairy.repository;

import com.wracce.onlinedairy.enity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}