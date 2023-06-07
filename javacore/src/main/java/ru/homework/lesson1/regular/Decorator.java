package ru.homework.lesson1.regular;

/**
 * Меняет внешний вид вывода результата.
 */

public class Decorator {

    /**
     *
     * @param a int
     * @return String
     */

    public static String decorator(int a) {
        return String.format("Here is your number: %d", a);
    }
}
