package com.project2.event_management.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO <T>{
    private Boolean success;
    private MessageDto message;
    private T data;

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}