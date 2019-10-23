package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private Long id;
    private Title title;
    private String status;
}
