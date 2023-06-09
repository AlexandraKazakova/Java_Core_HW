package ru.homework.lesson4;

public class MyArrayDataException extends MyException{
    public MyArrayDataException(String message, int i, int j) {
        super(message + "[" + i + "," + j + "]");
    }

}
