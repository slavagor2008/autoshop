package com.example.demo2.dto;

public class PartDto {

    private long id;

    private boolean available;

    private String mark;

    private String name;

    private double price;

    private String vendorCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }


    @Override
    public String toString() {
        return "PartDto {" +
                "id=" + id +
                ", available=" + available +
                ", mark='" + mark + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", vendorCode='" + vendorCode + '\'' +
                '}';
    }
}
