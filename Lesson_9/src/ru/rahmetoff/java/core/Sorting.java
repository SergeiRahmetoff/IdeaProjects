package ru.rahmetoff.java.core;

import java.util.*;
import java.util.stream.Collectors;

public class Sorting {


    public List<Object> getCoursesFromStudentList (Student student){
        return Arrays.stream(student.getAllCourses().stream().toArray()).collect(Collectors.toList());
    }

    public Set<Object> getUniqueCourses(List<Student> studentList){

        List<Object> allCourses = new ArrayList();
        studentList.stream()
                .forEach(student -> {
                    allCourses.addAll(getCoursesFromStudentList(student));
                });

        Set<Object> uniqueCourses = allCourses.stream()
                .collect(Collectors.toSet());

        return uniqueCourses;
    }

    public boolean compareCourses (List list, Course course){
        boolean t = list.stream()
                .anyMatch(course::equals);
        return t;
    }

    public List<Student> getStudentsByCourse(List<Student> studentList, Course course){
        List<Student> studentsByCourse = new ArrayList<>();
            studentList.stream()
                .forEach(student -> {
                    if (compareCourses(getCoursesFromStudentList(student), course) == true){
                        studentsByCourse.add(student);
                    }
                });
        return studentsByCourse;
    }

    public List<Object> bestStudents (List<Student> studentList){

        List<Object> bestStudents =
        studentList.stream()
                .sorted((s1,s2) -> s2.getAllCourses().size() - s1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
        return bestStudents;
    }
}
