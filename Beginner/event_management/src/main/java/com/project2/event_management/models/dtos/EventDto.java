package com.project2.event_management.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
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
