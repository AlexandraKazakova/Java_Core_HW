package ru.homework.lesson3;

public class HourlyBaseEmployee extends BaseEmployee {

    public HourlyBaseEmployee(String name, String surname, int age, double salary){
        super.name = name;
        super.surname = surname;
        super.age = age;
        super.salary = salary;
    }

    @Override
    public double averageMonthlySalary() {
        return 20.8 * 8 * salary;
    }

    @Override
    public String toString() {
        return  "Name = " + name +
                ", Surname = " + surname +
                ", Age = " + age +
                ", HourlyRate = " + salary +
                ", AverageMonthlySalary = " + averageMonthlySalary();
    }
}
