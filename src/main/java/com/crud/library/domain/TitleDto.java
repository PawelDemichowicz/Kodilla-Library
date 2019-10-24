package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {

    private Long id;
    private String title;
    private String author;
    private int yearPublished;
    private List<Book> books;
}
