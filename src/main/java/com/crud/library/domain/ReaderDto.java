package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {

    private Long id;
    private String name;
    private String lastName;
    private String dateCreateAccount;
}
