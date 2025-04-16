package com.project2.event_management.utils.constants;

import com.project2.event_management.models.dtos.MessageDto;

public class Messages {

    public static class Event {
        public static final MessageDto FETCH_SUCCESS = new MessageDto("Events fetched successfully", "E001");
        public static final MessageDto CREATE_SUCCESS = new MessageDto("Event created successfully", "E002");
        public static final MessageDto NOT_FOUND = new MessageDto("No event found with Event ID: %d", "E003");
        public static final MessageDto UPDATE_SUCCESS = new MessageDto("Event updated successfully", "E004");
        public static final MessageDto DELETE_SUCCESS = new MessageDto("Event deleted successfully", "E005");
    }
}
