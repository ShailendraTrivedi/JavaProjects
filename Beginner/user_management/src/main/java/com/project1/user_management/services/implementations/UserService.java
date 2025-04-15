package com.project1.user_management.services.implementations;

import com.project1.user_management.models.dtos.ResponseDTO;
import com.project1.user_management.models.dtos.UserDto;
import com.project1.user_management.models.entities.UserEntity;
import com.project1.user_management.services.interfaces.UserInterface;
import com.project1.user_management.utils.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserInterface {
    private final HashMap<Long, UserEntity> userEntityHashMap = new HashMap<>();

    @Override
    public ResponseDTO<?> addUser(UserDto user){
        Long newUserId = (long) (userEntityHashMap.size()+1);
        UserEntity newUser = UserEntity.builder().userId(newUserId).username(user.getUsername()).userPassword(user.getUserPassword()).build();
        userEntityHashMap.put(newUser.getUserId(), newUser);
        return ResponseDTO.builder().success(true).message(Messages.User.ADDED_SUCCESS).data(null).build();
    }

    @Override
    public ResponseDTO<?> updatePassword(Long userId, UserDto user){
        UserEntity existingUser = userEntityHashMap.get(userId);
        if(existingUser == null){
            return ResponseDTO.builder().success(false).message(String.format(Messages.User.NOT_FOUND, userId)).data(null).build();
        }

        existingUser.setUserPassword(user.getUserPassword());
        userEntityHashMap.put(userId, existingUser);

        return ResponseDTO.builder().success(true).message(Messages.User.PASSWORD_UPDATED).data(existingUser).build();
    }

    @Override
    public ResponseDTO<?> deleteUser(Long userId){
        UserEntity existingUser = userEntityHashMap.get(userId);
        if(existingUser == null){
            return ResponseDTO.builder().success(false).message(String.format(Messages.User.NOT_FOUND, userId)).data(null).build();
        }

        userEntityHashMap.remove(userId);
        return ResponseDTO.builder().success(true).message(Messages.User.DELETE_SUCCESS).data(existingUser).build();
    }

    @Override
    public ResponseDTO<?> getUsers(){
        List<UserDto> userEntityList = new ArrayList<>();
        for(Map.Entry<Long, UserEntity> userEntityEntity: userEntityHashMap.entrySet()){
            UserEntity user = userEntityEntity.getValue();
            UserDto newUser = UserDto.builder().userId(user.getUserId()).username(user.getUsername()).build();
            userEntityList.add(newUser);
        }
        return ResponseDTO.builder().success(true).message(Messages.User.FETCH_SUCCESS).data(userEntityList).build();
    }
}
