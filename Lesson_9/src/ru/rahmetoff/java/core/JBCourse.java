package ru.rahmetoff.java.core;

//public class JBCourse implements Course{

    public class JBCourse implements Course{

        private String jBCourse;

        public JBCourse(String jBCourse) {
            this.jBCourse = jBCourse;
        }


        @Override
        public String getCourse() {
            return jBCourse;
        }

        @Override
        public String toString() {
            return jBCourse;
        }
    }


