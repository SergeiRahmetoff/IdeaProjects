package ru.rahmetoff.java.core;

import java.util.ArrayList;
import java.util.List;

public class JBStudent implements Student {

    private String name;
    private List<Course> courses;

    public JBStudent(String name) {
        this.name = name;
    }

    public JBStudent(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public void setCourses(Course course) {
        List<Course> courses = new ArrayList<>();
        courses.add(course);
    }

    @Override
    public String toString() {
        return "JBStudent{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
