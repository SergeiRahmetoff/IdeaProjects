package ru.rahmetoff.java.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Phonebook {

    private HashSet<HashMap> phoneBook = new HashSet<>();

    public HashSet<HashMap> getPhoneBook() {
        return phoneBook;
    }

    public HashMap addRecording(String name, String phone) {
        HashMap<String, String> recording = new HashMap<>(2);
        recording.put(name, phone);
        return recording;
    }

    public void add(String name, String phone) {
        phoneBook.add(addRecording(name, phone));
    }

    public void get(String name) {
        for (HashMap i : phoneBook) {
            if (i.containsKey(name)) {
                System.out.println(name + ":" + i.get(name));
            }
        }
    }
}
