package com.crud.library.mapper;

import com.crud.library.domain.Rent;
import com.crud.library.domain.RentDto;
import org.springframework.stereotype.Component;

@Component
public class RentMapper {

    public Rent mapToRent(RentDto rentDto){
        return new Rent(
                rentDto.getId(),
                rentDto.getBook(),
                rentDto.getReader(),
                rentDto.getRentDate(),
                rentDto.getReturnDate());
    }

    public RentDto mapToRentDto(Rent rent){
        return new RentDto(
                rent.getId(),
                rent.getBook(),
                rent.getReader(),
                rent.getRentDate(),
                rent.getReturnDate());
    }
}
