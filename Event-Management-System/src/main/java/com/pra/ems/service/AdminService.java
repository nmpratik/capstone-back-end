package com.pra.ems.service;

import java.util.List;

import com.pra.ems.dto.EventListDto;
import com.pra.ems.dto.NewEventDto;
import com.pra.ems.dto.TicketDto;
import com.pra.ems.dto.UpdateEventDto;

public interface AdminService {
    Integer createNewEvent(NewEventDto dto);

    List<EventListDto> getAllEvents();

    Integer deleteEvent(Long id);

    Integer updateEvent(UpdateEventDto dto);

    NewEventDto getEvent(Long id);

    Integer createTicket(Long id,TicketDto dto);
}
