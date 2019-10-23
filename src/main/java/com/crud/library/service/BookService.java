package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Title;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final String STATUS = "Available";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TitleRepository titleRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(final Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookStatus(Long id, String status){
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        book.setStatus(status);

        return bookRepository.save(book);
    }

    public void deleteBook(final Long id) throws BookNotFoundException {
        bookRepository.deleteById(id);
    }

    public int countBookAvailableToRent(final String title) {
        Title bookTitle = titleRepository.findByTitleLike(title).orElse(null);
        int count = 0;
        if (bookTitle != null) {
            for (Book book : bookTitle.getBooks()) {
                if (book.getStatus().equals(STATUS)) {
                    count++;
                }
            }
        }
        return count;
    }

}
