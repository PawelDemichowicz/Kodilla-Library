package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TitleDto {

    private Long id;
    private String title;
    private String author;
    private int yearPublished;
}
