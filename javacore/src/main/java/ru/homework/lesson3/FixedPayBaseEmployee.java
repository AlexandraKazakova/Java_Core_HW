package ru.homework.lesson3;

public class FixedPayBaseEmployee extends BaseEmployee {

    public FixedPayBaseEmployee(String name, String surname, int age, double salary){
        super.name = name;
        super.surname = surname;
        super.age = age;
        super.salary = salary;
    }

    @Override
    public double averageMonthlySalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  "Name = " + name +
                ", Surname = " + surname +
                ", Age = " + age +
                ", Salary = " + salary +
                ", AverageMonthlySalary = " + averageMonthlySalary();
    }
}
