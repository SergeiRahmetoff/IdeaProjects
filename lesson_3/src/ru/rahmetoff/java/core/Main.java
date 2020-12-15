package ru.rahmetoff.java.core;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Задание 2
        Box box1 = new Box("корзина_1");
        Box box2 = new Box("корзина_2");
        Box box3 = new Box("корзина_3");
        Fruit apple1 = new Apple("яблоко_1");
        Fruit apple2 = new Apple("яблоко_2");
        Fruit apple3 = new Apple("яблоко_3");
        Fruit apple4 = new Apple("яблоко_4");
        Fruit orange1 = new Orange("апельсин_1");
        Fruit orange2 = new Orange("апельсин_2");
        Fruit orange3 = new Orange("апельсин_3");

        box1.putInBox(orange1);
        box1.putInBox(apple1);
        box1.putInBox(orange2);
        box1.putInBox(apple2);
        box1.putInBox(apple3);
        box1.putInBox(apple4);
        box1.putInBox(orange2);
        box2.putInBox(orange1);
        box2.putInBox(apple1);
        box2.putInBox(orange2);
        box2.putInBox(apple2);
        box2.putInBox(apple3);
        box2.putInBox(apple4);
        box2.putInBox(orange2);
        box3.putInBox(orange3);

        System.out.println(box1.getBoxContents());
        System.out.println(box2.getBoxContents());
        System.out.println(box3.getBoxContents());
        System.out.println(box1.getBoxWeight());
        System.out.println(box2.getBoxWeight());
        System.out.println(box3.getBoxWeight());
        System.out.println(box1.compare(box2));
        box1.transferFruit(box2);
        box1.transferFruit(box3);
        box1.transferFruit(box2);
        System.out.println(box1.getBoxContents());
        System.out.println(box2.getBoxContents());
        System.out.println(box3.getBoxContents());

        ArrayList arr = new ArrayList(box2.getBoxContents());
        Object[] arr2 = arr.toArray(new Object[0]);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("");
        changePlaces(arr2, 1, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }

    //Задание 1
    public static void changePlaces(Object[] arr, int i, int j) {
        Object a = arr[i];
        Object b = arr[j];
        arr[i] = b;
        arr[j] = a;
    }
}