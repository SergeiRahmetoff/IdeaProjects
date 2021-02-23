package ru.rahmetoff.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Course course_1 = new JBCourse("DATABASE");
        Course course_2 = new JBCourse("JAVA_1");
        Course course_3 = new JBCourse("JAVACORE");
        Course course_4 = new JBCourse("GIT");
        Course course_5 = new JBCourse("SOFTSKILLS");
        Course course_6 = new JBCourse("WEB_UI_TESTING");


        JBStudent student_1 = new JBStudent("Ivanov", new ArrayList<>(Arrays.asList(course_1, course_2, course_3, course_4, course_6)));
        JBStudent student_2 = new JBStudent("Petrov", new ArrayList<>(Arrays.asList(course_1, course_2, course_3, course_4)));
        JBStudent student_3 = new JBStudent("Sidorov", new ArrayList<>(Arrays.asList(course_6, course_5, course_3, course_4)));
        JBStudent student_4 = new JBStudent("Vasilyev", new ArrayList<>(Arrays.asList(course_1, course_3, course_6)));
        JBStudent student_5 = new JBStudent("Orlov", new ArrayList<>(Arrays.asList(course_6, course_2)));

        List<Student> jBStudentList = new ArrayList<>(Arrays.asList(student_1, student_2, student_3, student_4, student_5));

        Sorting sorting = new Sorting();
        System.out.println(sorting.getUniqueCourses(jBStudentList).toString());
        System.out.println(sorting.getStudentsByCourse(jBStudentList, course_3).toString());
        System.out.println(sorting.bestStudents(jBStudentList).toString());


//        Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
//        Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
//        Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.


    }


}
