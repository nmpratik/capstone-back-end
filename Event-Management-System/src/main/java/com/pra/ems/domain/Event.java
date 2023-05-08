package com.pra.ems.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    // @NotBlank(message = "time is mandatory")
    // @NotNull(message = "time should not be null")
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime time;

    @ManyToMany(mappedBy = "events")
    private List<User> users;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
