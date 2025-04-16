package com.project2.event_management.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private String msg;
    private String code;

    @Override
    public String toString() {
        return "MessageDto{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
