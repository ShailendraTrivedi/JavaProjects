package com.project2.event_management.models.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventEntity {
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String eventVenue;

    @Override
    public String toString() {
        return "EventEntity{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                '}';
    }
}
