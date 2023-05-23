package homework.lesson1.sample;

import homework.lesson1.regular.Decorator;
import homework.lesson1.regular.OtherClass;

/**
 * javac -sourcepath ./java -d out java/homework/lesson1/sample/Main.java
 * 
 * java -classpath ./out homework.lesson1.sample.Main
 */

public class Main {
    public static void main(String[] args) {
        int result = OtherClass.add(4, 2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.div(4, 2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.mul(4, 2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.sub(4, 2);
        System.out.println(Decorator.decorator(result));
    }
}
