package com.crud.library.repositories;

import com.crud.library.domain.Book;
import com.crud.library.domain.Title;
import com.crud.library.exception.BookNotFoundException;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.TitleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTestSuite {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TitleRepository titleRepository;

    @Test
    public void testBookSave(){
        //Given
        Title title = new Title("test title", "test author", 1994);
        Book book = new Book(title, "Available");

        //When
        bookRepository.save(book);
        int result = bookRepository.findAll().size();

        //Then
        assertEquals(1,result);

        //CleanUp
        bookRepository.deleteAll();
    }

    @Test
    public void testBookGet(){
        //Given
        Title title = new Title("test title", "test author", 1994);
        Book book = new Book(title, "Available");

        //When
        bookRepository.save(book);
        long id = book.getId();
        Book result = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        //Then
        assertEquals(result.getId(),book.getId());
        assertEquals(result.getStatus(),book.getStatus());
        assertEquals(result.getTitle().getTitle(),book.getTitle().getTitle());
        assertEquals(result.getTitle().getAuthor(),book.getTitle().getAuthor());
        assertEquals(result.getTitle().getYearPublished(),book.getTitle().getYearPublished());

        //CleanUp
        bookRepository.deleteAll();
    }

}
