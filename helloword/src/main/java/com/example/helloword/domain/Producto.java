package com.example.helloword.domain;

public class Producto {
    private int Id;
    private String Name;
    private double Price;

    public Producto( int Id, String Name, double Price){
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    
}
