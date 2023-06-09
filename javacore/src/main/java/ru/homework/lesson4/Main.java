package ru.homework.lesson4;

public class Main {
    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {

        String[][] array1 = { {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"} };
        String[][] array2 = new String[3][3];
        String[][] array3 = { {"1", "1", "1", "1"}, {"v", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"} };


        System.out.println(checkAndSumArray(array1));
        System.out.println(checkAndSumArray(array2));
        System.out.println(checkAndSumArray(array3));

    }
     public static int checkAndSumArray(String[][] array){  // throws MyArrayDataException, MyArraySizeException
        int sum = 0;
        if(array.length != 4 || array[0].length != 4){
            throw new MyArraySizeException("Неверный размер массива");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(!isDigit(array[i][j])) {
                    throw new MyArrayDataException("Неверные данные в массиве. Позиция: ", i, j);
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }
        return sum;
    }

    public static boolean isDigit(String a){
        return a.toLowerCase().equals(a.toUpperCase());
    }
}
