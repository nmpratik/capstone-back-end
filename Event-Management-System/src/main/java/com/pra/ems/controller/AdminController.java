package com.pra.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pra.ems.dto.EventListDto;
import com.pra.ems.dto.NewEventDto;
import com.pra.ems.dto.TicketDto;
import com.pra.ems.dto.UpdateEventDto;
import com.pra.ems.service.AdminService;
import com.pra.ems.util.AppResponse;

import lombok.AllArgsConstructor;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    
    private final AdminService adminService;
    
    @PostMapping(value = "/newevent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> newEvent(@Valid @RequestBody NewEventDto dto) {
        Integer createNewEvent = adminService.createNewEvent(dto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .msg("new event created successfully.")
                .bd(createNewEvent)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventListDto>> findAll() {
        return ResponseEntity.ok().body(adminService.getAllEvents());
    }

    @GetMapping(value = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<AppResponse<NewEventDto>> findEventById(@PathVariable Long id) {

        NewEventDto dto = adminService.getEvent(id);

         AppResponse<NewEventDto> response = AppResponse.<NewEventDto>builder()
                                                        .msg("Event Details")
                                                        .bd(dto)
                                                        .build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteInvoice(@PathVariable Long id) {

        final Integer sts = adminService.deleteEvent(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
            .msg(id+" ID Event Deleted Successfully")
            .bd(sts)
            .build();

        return ResponseEntity.status(200).body(response);
    }

    @PutMapping(value = "/updateevent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateNewInvoice(@Valid @RequestBody UpdateEventDto dto) {

        final Integer sts = adminService.updateEvent(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .msg("Event Updated Successfully")
                                                    .bd(sts)
                                                    .build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/events/{eventId}/tickets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createTicketForEvent(@Valid @PathVariable Long eventId, @RequestBody TicketDto ticketDto) {
        Integer setTicket = adminService.createTicket(eventId,ticketDto);
        AppResponse<Integer> response = AppResponse.<Integer>builder()
                .msg("ticket created.")
                .bd(setTicket)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}