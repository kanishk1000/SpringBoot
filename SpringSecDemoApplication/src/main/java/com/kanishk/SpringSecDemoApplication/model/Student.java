package com.kanishk.SpringSecDemoApplication.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int rollNo;
    private String name;
    private String techStack;

    public Student(){

    }

    public Student(int rollNo, String name, String techStack) {
        this.rollNo = rollNo;
        this.name = name;
        this.techStack = techStack;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }
}
