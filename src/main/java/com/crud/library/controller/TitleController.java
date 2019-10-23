package com.crud.library.controller;

import com.crud.library.domain.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class TitleController {

    @Autowired
    TitleService service;

    @Autowired
    TitleMapper mapper;

    @RequestMapping(method = RequestMethod.POST, value = "/titles",consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto){
        service.saveTitle(mapper.mapToTitle(titleDto));
    }
}
