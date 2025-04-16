package com.project2.event_management.utils.handlers;

import com.project2.event_management.models.dtos.MessageDto;
import com.project2.event_management.models.dtos.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    @FunctionalInterface
    public interface SupplierWithException<T>{
        T get() throws Exception;
    }

    public static ResponseEntity<?> truCatchWrapper(SupplierWithException<ResponseDTO<?>> supplier){
        try {
            ResponseDTO<?> response = supplier.get();
            HttpStatus status = response.getSuccess() ? HttpStatus.OK: HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(status).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDTO.builder()
                            .success(false)
                            .message(new MessageDto(e.getMessage(), "0"))
                            .data(null)
                            .build());
        }
    }
}