package com.org.shubham.exceptions;

public class ResourceAlreadyExistException extends RuntimeException{
    String resourceName;
    String fieldName;
    String fieldValue;

    public ResourceAlreadyExistException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s  with  %s as   %s already exists",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
