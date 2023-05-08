package com.pra.ems.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewEventDto {

    @NotBlank(message = "title is mandatory")
    @NotNull(message = "title should not be null")
    private String title;

    @NotBlank(message = "description is mandatory")
    @NotNull(message = "description should not be null")
    private String description;

    @Future(message = "Date should not be from past")
    private LocalDate startdate;

    @Future(message = "Date should not be from past")
    private LocalDate enddate;

    @NotBlank(message = "location is mandatory")
    @NotNull(message = "location should not be null")
    private String location;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;
}
