package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto){
        return new Title(
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYearPublished());
    }

    public TitleDto mapToTitleDto(Title title){
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYearPublished());
    }
}