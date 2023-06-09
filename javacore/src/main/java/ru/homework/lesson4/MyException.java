package ru.homework.lesson4;

public abstract class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
