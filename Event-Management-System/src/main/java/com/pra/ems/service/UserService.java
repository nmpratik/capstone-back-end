package com.pra.ems.service;

import java.util.List;

import com.pra.ems.dto.EventListDto;
import com.pra.ems.dto.TicketDto;
import com.pra.ems.dto.UserEventDto;

public interface UserService {
    Integer bookEvent(Long userId,Long eventId);

    List<UserEventDto> getAllEvents(Long userId);

    List<EventListDto> getEventsByLocation(String location);

    UserEventDto getEvent(Long userId,Long eventId);

    List<TicketDto>getAllTicketsEventId(Long eventId);
}
