package com.example.demo;




import javax.persistence.Entity;

@Entity
public class Student {


    private String name;

    private int standard;

    private int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Student(String name, int standard, int marks) {
        this.name = name;
        this.standard = standard;
        this.marks = marks;
    }


}
