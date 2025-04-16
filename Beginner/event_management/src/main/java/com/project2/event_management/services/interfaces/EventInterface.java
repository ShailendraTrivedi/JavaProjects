package com.project2.event_management.services.interfaces;

import com.project2.event_management.models.dtos.EventDto;
import com.project2.event_management.models.dtos.ResponseDTO;

public interface EventInterface {
    public ResponseDTO<?> getAllEvents();
    public ResponseDTO<?> addEvent(EventDto event);
    public ResponseDTO<?> updateEvent(Long eventId, EventDto event);
    public ResponseDTO<?> deleteEvent(Long eventId);

}
