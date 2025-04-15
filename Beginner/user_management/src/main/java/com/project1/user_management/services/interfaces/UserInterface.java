package com.project1.user_management.services.interfaces;

import com.project1.user_management.models.dtos.ResponseDTO;
import com.project1.user_management.models.dtos.UserDto;

public interface UserInterface {
    public ResponseDTO<?> addUser(UserDto user);
    public ResponseDTO<?> updatePassword(Long userId, UserDto user);
    public ResponseDTO<?> deleteUser(Long userId);
    public ResponseDTO<?> getUsers();
}
