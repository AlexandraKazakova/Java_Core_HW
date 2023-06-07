package ru.homework.lesson3;

import java.util.Comparator;

public interface NameComparator extends Comparator<BaseEmployee> {
    @Override
    default int compare(BaseEmployee o1, BaseEmployee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
