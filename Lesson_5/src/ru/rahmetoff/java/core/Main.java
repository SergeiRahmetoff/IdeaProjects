package ru.rahmetoff.java.core;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File dataFile = new File("./data.csv");
        //dataFile.createNewFile();

        AppData data = new AppData(new String[]{"Value 1", "Value 2", "Value 3"});
        data.setData(new int[][]{{100, 200, 123}, {300, 400, 500}});

        data.saveData(dataFile);
        data.loadData(dataFile);

        data.dataToString();

    }
}
