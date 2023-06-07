package ru.homework.lesson3;

import java.util.ArrayList;


public class EmployeeArr {
    BaseEmployee[] employeeArr = {
            new HourlyBaseEmployee("Den", "Black", 30, 300),
            new FixedPayBaseEmployee("Max", "Brown", 40, 30000),
            new HourlyBaseEmployee("Mark", "Gun", 30, 350),
            new HourlyBaseEmployee("Susy", "Green", 30, 400),
            new HourlyBaseEmployee("Amanda", "Smith", 30, 220),
            new FixedPayBaseEmployee("Roy", "Smith", 40, 80000),
            new FixedPayBaseEmployee("Rose", "Ling", 40, 49000),
            new FixedPayBaseEmployee("Ben", "Been", 40, 54000),
    };

    public BaseEmployee[] getEmployeeArr() {
        return employeeArr;
    }

    public void printEmployeeArr(ArrayList<BaseEmployee> employeeArr){
        for (BaseEmployee employee: employeeArr) {
            System.out.println(employee.toString());
        }
    }
}