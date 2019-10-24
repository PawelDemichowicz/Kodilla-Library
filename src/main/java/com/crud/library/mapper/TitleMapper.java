package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto){
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYearPublished(),
                titleDto.getBooks());
    }

    public TitleDto mapToTitleDto(final Title title){
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYearPublished(),
                title.getBooks());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titles){
         return titles.stream()
                .map(t -> new TitleDto(t.getId(),t.getTitle(),t.getAuthor(),t.getYearPublished(),t.getBooks()))
                .collect(Collectors.toList());
    }
}
