package com.fatih.app.core.exception;

public class NotFoundException extends AppServiceException{
    public NotFoundException() {
        super("Entity not found");
    }
}
