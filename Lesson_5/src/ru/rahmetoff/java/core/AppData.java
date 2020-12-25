package ru.rahmetoff.java.core;

import java.io.*;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void dataToString() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void saveData(File file) throws IOException {
        String name = file.getPath();
        file.delete();
        File dataFile = new File(name);
        dataFile.createNewFile();
        try (BufferedWriter s = new BufferedWriter(new FileWriter(file, true))) {
            for (String o : header) {
                s.write(o + ";");
            }
            s.write("\n");
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    s.write(data[i][j] + ";");
                }
                s.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(File file) {
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String str = null;
            r.readLine();
            for (int i = 0; i < data.length; i++) {
                str = r.readLine();
                String[] d = str.split(";");
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = Integer.parseInt(d[j]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}