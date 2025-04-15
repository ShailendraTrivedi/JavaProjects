package com.project1.user_management.models.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    private Long userId;
    private String username;
    private String userPassword;

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }


}
