package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Rent;
import com.crud.library.exception.BookNotAvailableException;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.exception.ReaderNotFoundException;
import com.crud.library.exception.RentNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.ReaderRepository;
import com.crud.library.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentService {

    private static final String AVAILABLE = "Available";
    private static final String RENTED = "Rented";

    @Autowired
    RentRepository rentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReaderRepository readerRepository;


    public void rentBook(final Long bookId, final Long readerId) {
        Book book = bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
        Reader reader = readerRepository.findById(readerId).orElseThrow(ReaderNotFoundException::new);

        if (book.getStatus().equals(AVAILABLE)) {
            Rent rent = new Rent();
            rent.setBook(book);
            rent.setReader(reader);
            rent.setRentDate(LocalDate.now());
            rent.setReturnDate(null);

            book.setStatus(RENTED);
            rentRepository.save(rent);

        }else {
            throw new BookNotAvailableException();
        }
    }

    public Rent returnBook(final Long bookId, final Long readerId){
        Rent rent = rentRepository.findByBook_IdAndReader_Id(bookId,readerId).orElseThrow(RentNotFoundException::new);
        rent.setReturnDate(LocalDate.now());

        Book book = rent.getBook();
        book.setStatus(AVAILABLE);

        bookRepository.save(book);
        return rentRepository.save(rent);
    }
}
