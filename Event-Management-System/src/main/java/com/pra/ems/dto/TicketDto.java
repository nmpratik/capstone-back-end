package com.pra.ems.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {

    @NotNull(message = "Must enter price")
    @Min(value = 0, message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Ticket type can\'t be null")
    @NotBlank(message = "Must enter ticket type")
    private String type;
}
