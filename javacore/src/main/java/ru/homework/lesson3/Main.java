package ru.homework.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        EmployeeArr employeeArr = new EmployeeArr();

        Comparator<BaseEmployee> comparatorBySalary = new SalaryComparator();



        ArrayList<BaseEmployee> arrayList = new ArrayList<>(Arrays.asList(employeeArr.getEmployeeArr()));

        employeeArr.printEmployeeArr(arrayList);
        System.out.println();

        arrayList.sort(comparatorBySalary);
        employeeArr.printEmployeeArr(arrayList);
        System.out.println();

        arrayList.sort(new NameComparator() {
            @Override
            public int compare(BaseEmployee o1, BaseEmployee o2) {
                return NameComparator.super.compare(o1, o2);
            }
        });
        employeeArr.printEmployeeArr(arrayList);
    }
}
