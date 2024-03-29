package com.crud.library.controller;

import com.crud.library.domain.RentDto;
import com.crud.library.mapper.RentMapper;
import com.crud.library.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class RentController {

    @Autowired
    RentService service;

    @Autowired
    RentMapper mapper;

    @RequestMapping(method = RequestMethod.POST, value = "/rents", consumes = APPLICATION_JSON_VALUE)
    public void rentBook(@RequestParam Long bookId, @RequestParam Long readerId){
        service.rentBook(bookId,readerId);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/rents")
    public RentDto returnBook(@RequestParam Long bookId, @RequestParam Long readerId){
        return mapper.mapToRentDto(service.returnBook(bookId,readerId));
    }
}
