package com.project3.file_storage.utils.handlers;

public class ResponseHandler {
    @FunctionalInterface
    private interface SupplierWithException<T>{
        T get() throws Exception;
    }
}
