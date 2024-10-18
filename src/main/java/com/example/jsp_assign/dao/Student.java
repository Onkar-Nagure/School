package com.example.jsp_assign.dao;

public class Student {
    private int id;
    private String name;
    private String last_name;
    private String dept;

    public Student() {}

    public Student(int id, String name, String last_name, String dept) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.dept = dept;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
