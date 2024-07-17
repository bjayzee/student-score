package com.studentscore.exception;

public class StudentException extends RuntimeException{
    public StudentException(){
        super();
    }
    public StudentException(String message) {
        super(message);
    }
}
