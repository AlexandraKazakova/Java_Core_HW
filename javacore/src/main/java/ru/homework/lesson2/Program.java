package ru.homework.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '·';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char [][] field;
    private static final Random random = new Random();
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int countWin;
    private static int checkX;
    private static int checkY;


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, checkX, checkY, "Вы победили", countWin)) {
                    break;
                }
                aiTern();
                printField();
                if (gameCheck(DOT_AI, checkX, checkY, "Компьютер победил", countWin)) {
                    break;
                }
            }
            System.out.println("Желаете сыграть еще? (Y - да)");
            if(!SCANNER.next().equalsIgnoreCase("Y")){
                break;
            }
        }
    }

    /**
     * Инициализария игрового поля
     */

    private static void initialize(){
        System.out.println("Введите размер поля X на Y через пробел >>");
        fieldSizeX = SCANNER.nextInt();
        fieldSizeY = SCANNER.nextInt();

        // Если поле 4х4 и больше - выиграшная комбинация = 4
        countWin = ((fieldSizeX + fieldSizeY) > 7) ? 4 : 3;

        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){

        System.out.print("+-");
        for(int i = 1; i <= fieldSizeX; i++){
            System.out.printf("%s-", i);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.printf("%s|", i + 1);

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.printf("%s|", field[j][i]);
            }

            System.out.println();
        }

        System.out.print("+-");
        for(int i = 1; i <= fieldSizeX; i++){
            System.out.print("--");
        }

        System.out.println();
    }

    private static void humanTurn(){
        int x, y;
        do{
            System.out.printf("Введите координаты X (от 1 до %s) и Y (от 1 до %s) через пробел => ", fieldSizeX, fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }while (!isCellValid(x, y) || !isCellEmpty(x,y));
            field[x][y] = DOT_HUMAN;
            checkX = x;
            checkY = y;
    }

    private static void aiTern() {
        int x, y;
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellEmpty(x, y));
            field[x][y] = DOT_AI;
            checkX = x;
            checkY = y;
        }




    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean checkWin(char c, int x, int y, int countWin){
        return checkWinY(c, x, countWin) || checkWinX(c, y, countWin) || checkWinD1(c, x, y, countWin) || checkWinD2(c, x, y, countWin);
    }

    /**
     * Проверка на победу по вертикали от клетки
     * @param c char - HUMAN or AI
     * @param x int - горизонтальнаяя координата
     * @param countWin int - условие выигрыша
     * @return boolean
     */
    static boolean checkWinY(char c, int x, int countWin) {
        int count = 0;
        boolean win = false;
        for (int y = 0; y < fieldSizeY; y++){
            if(field[x][y] == c) {
                count++;
                if (count == countWin) win = true;
            }else count = 0;
        }
        return win;
    }

    /**
     * Проверка на победу по горизонтали от клетки
     * @param c char - HUMAN or AI
     * @param y int - вертикальная координата
     * @param countWin int - условие выигрыша
     * @return boolean
     */
    static boolean checkWinX(char c, int y, int countWin) {
        int count = 0;
        boolean win = false;
        for (int x = 0; x < fieldSizeX; x++){
            if(field[x][y] == c) {
                count++;
                if (count == countWin) win = true;
            }else count = 0;
        }
        return win;
    }


    /**
     * Проверка на победу по главной диагонали
     * @param c char - HUMAN or AI
     * @param y int - вертикальная координата
     * @param x int - горизонтальная координата
     * @param countWin int - условие выигрыша
     * @return boolean
     */
    static boolean checkWinD1(char c, int x, int y, int countWin){
        int count = 0;
        int startX = 0;
        int startY = 0;
            if(x >= y){
                startX = x - y;
            }else {
                startY = y - x;
            }
        while (startY < fieldSizeY && startX < fieldSizeX){
            count = (field[startX][startY] == c) ? count + 1 : 0;
            startY++;
            startX++;
        }
        return count == countWin;
        }


    /**
     * Проверка на победу по побочной диагонали
     * @param c char - HUMAN or AI
     * @param y int - вертикальная координата
     * @param x int - горизонтальная координата
     * @param countWin int - условие выигрыша
     * @return boolean
     */
    static boolean checkWinD2(char c, int x, int y, int countWin){
        int count = 0;
        int startX = 0;
        int startY = 0;

        if( checkField(fieldSizeX, fieldSizeY) && x + y < fieldSizeY){
            startY = x + y;
        } else if(x + y == 0){
            return false;
        } else if (!checkField(fieldSizeX, fieldSizeY) && x + y < fieldSizeY) {
            startY = x + y;
        } else {
            startY = fieldSizeY - 1;
            startX = x + y - startY;
        }

        while (startY >= 0 & startX < fieldSizeX){
            count = (field[startX][startY] == c) ? count + 1 : 0;
            startY--;
            startX++;
        }
        return count == countWin;
    }

    /**
     * Проверка, что выслта поля больше ширины
     * @param x int - ширина поля
     * @param y int - высота поля
     * @return boolean
     */

    static boolean checkField(int x, int y){
        return x <= y;
    }

    /**
     * Проверка, есть ли пустые ячейки
     * @return boolean
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++) {
                if(isCellEmpty(x,y)) return false;
            }
        }
        return true;
    }


    /**
     * Проверка на выигрыш либо ничью, вывод на экран
     * @param c char - HUMAN or AI
     * @param x int - коордирата по горизонтали
     * @param y int - координата по вертикали
     * @param str String - текст, который будет выведен на экран
     * @return boolean
     */
    static boolean gameCheck(char c, int x, int y, String str, int countWin){
        if(checkWin(c, x, y, countWin)){
            System.out.println(str);
            return true;
        }
        if(checkDraw()){
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

}
