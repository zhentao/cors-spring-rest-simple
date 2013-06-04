package com.zhentao.cors.example;

public class Employee {
    private long id;
    private String name;

    public Employee() {
        // No-arg constructor required for json conversion
    }

    public Employee(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
