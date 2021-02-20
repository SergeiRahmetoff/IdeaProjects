package ru.rahmetoff.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Course> courses_1 = new ArrayList<>();
        courses_1.set(1, Course.)

        JBStudent student_1 = new JBStudent("Ivanov",courses_1);
        JBStudent student_2 = new JBStudent();
        JBStudent student_3 = new JBStudent();


//        Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
//        Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
//        Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.


    }

    public Student getUniqueCourses (List<Student> studentList){
        return studentList.stream()
                .collect(Collectors.toSet();
    }




}
