package ru.rahmetoff.java.core;

public class Main {

    public static int sumAfterLengthCheck(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    if (arr.length == 4 || arr[i].length == 4) {
                        sum = sumInt(arr);
                    } else if (arr.length > 4 || arr[i].length > 4) {
                        try {
                            sum = Integer.parseInt(arr[arr.length][arr[i].length]);
                        } catch (IndexOutOfBoundsException e) {
                            throw new MyArraySizeException();
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new MyArraySizeException();
                }
            }
        }
        return sum;
    }


    public static int sumInt(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int a = Integer.parseInt(arr[i][j]);
                    sum = sum + a;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке " + "[" + i + "]" + "[" + j + "]. " + e.getMessage());
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] arr1 = {{"125", "7000", "15", "6"}, {"1", "56", "12", "21"}, {"125", "7000", "15", "6"}, {"125", "7000", "15", "6"}};
        String[][] arr2 = {{"125", "7000", "15", "6"}, {"Who", "Who", "12", "21"}, {"125", "7000", "15", "6"}, {"125", "7000", "15", "6"}};
        String[][] arr3 = {{"125", "7000", "15", "6", "6"}, {"1", "56", "12", "21"}, {"125", "7000", "15", "6"}, {"1", "56", "12", "21"}, {"125", "7000", "15", "6"}};
        String[][] arr4 = {{"125", "7000", "15", "6"}, {"125", "125", "12", "21"}, {"125", "7000", "15", "6"}};
        String[][] arr5 = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][][] arr = {arr1, arr2, arr3, arr4, arr5};


        for (int i = 0; i < arr.length; i++) {
            int a;
            try {
                a = sumAfterLengthCheck(arr[i]);
                System.out.println("Сумма полей в массиве arr" + (i + 1) + " = " + a);
            } catch (MyArraySizeException e) {
                System.out.println("Массив arr" + (i + 1) + ". Размер массива не 4х4");
            } catch (MyArrayDataException e) {
                System.out.println("Массив arr" + (i + 1) + ". " + e.getMessage());
            }
        }
    }
}
