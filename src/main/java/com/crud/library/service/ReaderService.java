package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    public void saveReader(Reader reader){
        readerRepository.save(reader);
    }
}
