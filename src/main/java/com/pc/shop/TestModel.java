package com.pc.shop;

public class TestModel {

    private int id;
    private String name;
    private String Model;

    public TestModel(int id, String name, String model) {
        this.id = id;
        this.name = name;
        Model = model;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return Model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        Model = model;
    }
}
