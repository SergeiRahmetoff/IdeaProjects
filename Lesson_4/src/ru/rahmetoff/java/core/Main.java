package ru.rahmetoff.java.core;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Задание 1.
        String[] sentence = "Создать массив с набором слов 10-20 слов должны встречаться повторяющиеся Найти и вывести список уникальных слов из которых состоит массив дубликаты не считаем".split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(sentence));

        //Посчитать, сколько раз встречается каждое слово.
        Iterator<String> iter = list.iterator();
        HashMap<String, Integer> countedList = new HashMap<>();
        while (iter.hasNext()) {
            Integer count = 0;
            String str = iter.next();
            for (String o : list) {
                if (str.equals(o)) {
                    count++;
                }
                countedList.put(str, count);
            }
        }
        for (Map.Entry<String, Integer> o : countedList.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        HashSet<String> checkedList = new HashSet<>(list);
        System.out.println(checkedList);

        //Задание 2.
        Phonebook myPhonebook = new Phonebook();
        myPhonebook.add("Иванов", "79219951685");
        myPhonebook.add("Петров", "79261251685");
        myPhonebook.add("Сидоров", "89249951658");
        myPhonebook.add("Иванов", "+79215284122");

        for (HashMap o : myPhonebook.getPhoneBook()) {
            System.out.println(o.keySet() + ": " + o.values());
        }

        myPhonebook.get("Петров");
        myPhonebook.get("Иванов");

    }
}



