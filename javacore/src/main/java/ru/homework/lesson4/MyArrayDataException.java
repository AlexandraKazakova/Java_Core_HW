package ru.homework.lesson4;

public class MyArrayDataException extends MyException{
    int i;
    int j;
    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
