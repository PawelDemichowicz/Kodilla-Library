package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {

    private Long id;
    private Book book;
    private Reader reader;
    private LocalDate rentDate;
    private LocalDate returnDate;

}
