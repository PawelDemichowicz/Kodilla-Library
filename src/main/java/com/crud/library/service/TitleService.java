package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {

    @Autowired
    TitleRepository titleRepository;

    public void saveTitle(final Title title){
        titleRepository.save(title);
    }
}
