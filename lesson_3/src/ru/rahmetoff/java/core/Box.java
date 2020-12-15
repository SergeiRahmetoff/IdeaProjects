package ru.rahmetoff.java.core;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private String name;
    private T boxType;
    private ArrayList<T> boxContents = new ArrayList<T>();

    public Box(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ArrayList<T> getBoxContents() {
        return boxContents;
    }

    public T getBoxType() {
        return boxType;
    }

    public void putInBox(T fruit) {
        if (!fruit.inBox) {
            if (boxContents.isEmpty()) {
                boxContents.add(fruit);
                boxType = fruit;
                fruit.inBox = true;
                System.out.println(fruit.getName() + " добавлен в " + this.name);
            } else if (fruit.getClass().equals(boxType.getClass())) {
                boxContents.add(fruit);
                fruit.inBox = true;
                System.out.println(fruit.getName() + " добавлен в " + this.name);

            } else System.out.println("Неправильный тип фрукта");
        } else System.out.println("Фрукт уже в коробке");
    }

    public double getBoxWeight() {
        double weight = boxContents.size() * boxType.getWeight();
        return weight;
    }

    public boolean compare(Box box) {
        if (this.getBoxWeight() == box.getBoxWeight()) {
            return true;
        } else return false;
    }

    public void transferFruit(Box<T> box) {
        if (this.getBoxWeight() != 0){
            if (this.boxType.getClass().equals(box.boxType.getClass())){
                box.boxContents.addAll(this.boxContents);
                this.boxContents.clear();
            } else System.out.println("Не совпадает тип фруктов в коробках");
        } else System.out.println("Коробка пустая");
    }
}

