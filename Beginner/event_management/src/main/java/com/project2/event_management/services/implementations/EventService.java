package com.project2.event_management.services.implementations;

import com.project2.event_management.models.dtos.EventDto;
import com.project2.event_management.models.dtos.MessageDto;
import com.project2.event_management.models.dtos.ResponseDTO;
import com.project2.event_management.models.entities.EventEntity;
import com.project2.event_management.services.interfaces.EventInterface;
import com.project2.event_management.utils.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService implements EventInterface {

    private final Map<Long, EventEntity> eventEntityMap = new HashMap<>();

    @Override
    public ResponseDTO<?> getAllEvents() {
        List<EventDto> events = new ArrayList<>();

        for (EventEntity entity : eventEntityMap.values()) {
            events.add(EventDto.builder()
                    .eventId(entity.getEventId())
                    .eventName(entity.getEventName())
                    .eventDescription(entity.getEventDescription())
                    .eventDate(entity.getEventDate())
                    .eventVenue(entity.getEventVenue())
                    .build());
        }

        return ResponseDTO.builder()
                .success(true)
                .message(Messages.Event.FETCH_SUCCESS)
                .data(events)
                .build();
    }

    @Override
    public ResponseDTO<?> addEvent(EventDto eventDto) {
        long newId = eventEntityMap.size() + 1L;

        EventEntity event = EventEntity.builder()
                .eventId(newId)
                .eventName(eventDto.getEventName())
                .eventDescription(eventDto.getEventDescription())
                .eventDate(String.valueOf(new Date()))
                .eventVenue(eventDto.getEventVenue())
                .build();

        eventEntityMap.put(newId, event);

        return ResponseDTO.builder()
                .success(true)
                .message(Messages.Event.CREATE_SUCCESS)
                .data(event)
                .build();
    }

    @Override
    public ResponseDTO<?> updateEvent(Long eventId, EventDto updatedData) {
        EventEntity existing = eventEntityMap.get(eventId);

        if (existing == null) {
            return ResponseDTO.builder()
                    .success(false)
                    .message(new MessageDto(String.format(Messages.Event.NOT_FOUND.getMsg(), eventId), Messages.Event.NOT_FOUND.getCode()))
                    .data(null)
                    .build();
        }

        existing.setEventName(updatedData.getEventName());
        existing.setEventDescription(updatedData.getEventDescription());
        existing.setEventVenue(updatedData.getEventVenue());
        existing.setEventDate(updatedData.getEventDate());

        return ResponseDTO.builder()
                .success(true)
                .message(Messages.Event.UPDATE_SUCCESS)
                .data(existing)
                .build();
    }

    @Override
    public ResponseDTO<?> deleteEvent(Long eventId) {
        EventEntity event = eventEntityMap.remove(eventId);

        if (event == null) {
            return ResponseDTO.builder()
                    .success(false)
                    .message(new MessageDto(String.format(Messages.Event.NOT_FOUND.getMsg(), eventId), Messages.Event.NOT_FOUND.getCode()))
                    .data(null)
                    .build();
        }

        return ResponseDTO.builder()
                .success(true)
                .message(Messages.Event.DELETE_SUCCESS)
                .data(event)
                .build();
    }
}
