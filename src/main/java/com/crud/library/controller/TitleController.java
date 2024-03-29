package com.crud.library.controller;

import com.crud.library.domain.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class TitleController {

    @Autowired
    TitleService service;

    @Autowired
    TitleMapper mapper;

    @GetMapping(value = "/titles")
    public List<TitleDto> getTitles(){
        return mapper.mapToTitleDtoList(service.getTitles());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/titles",consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto){
        service.saveTitle(mapper.mapToTitle(titleDto));
    }
}
