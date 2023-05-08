package com.pra.ems.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Email should not be null")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid Email")
    private String email;
    
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password is mandatory")
    private String password;
    
    @NotBlank(message = "Choose gender")
    @NotNull(message = "Gender should not be null")
    private String gender;
    
    @NotNull(message = "Role should not be null")
    @NotBlank(message = "Role is mandatory")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_event",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;
}
