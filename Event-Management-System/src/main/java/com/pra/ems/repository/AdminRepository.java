package com.pra.ems.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pra.ems.domain.Event;
import java.util.List;

public interface AdminRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation(String location);

}