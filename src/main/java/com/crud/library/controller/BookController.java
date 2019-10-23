package com.crud.library.controller;

import com.crud.library.domain.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    BookMapper mapper;

    @RequestMapping(method = RequestMethod.GET,value = "/books")
    public List<BookDto> getBooks(){
        return mapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/books/{id}")
    public BookDto getBook(@PathVariable Long id){
        return mapper.mapToBookDto(service.getBook(id));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/books")
    public void createBook(@RequestBody BookDto bookDto){
        service.saveBook(mapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/books/{id}")
    public BookDto updateBookStatus(@PathVariable Long id, @RequestParam String status ){
        return mapper.mapToBookDto(service.updateBookStatus(id,status));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/boards")
    public int countBooks(@RequestBody String title){
        return service.countBookAvailableToRent(title);
    }

}
