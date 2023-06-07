package ru.homework.lesson3;

import java.util.Comparator;

public class SalaryComparator implements Comparator<BaseEmployee> {
    @Override
    public int compare(BaseEmployee o1, BaseEmployee o2) {
        if(o1.averageMonthlySalary() == o2.averageMonthlySalary()) return 0;
        if(o1.averageMonthlySalary() > o2.averageMonthlySalary()) return 1;
        else return -1;
    }
}
