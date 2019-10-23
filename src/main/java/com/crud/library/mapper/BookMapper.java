package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getTitle(),
                bookDto.getStatus());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getStatus());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> book) {
        return book.stream()
                .map(t -> new BookDto(t.getId(), t.getTitle(), t.getStatus()))
                .collect(Collectors.toList());
    }
}
