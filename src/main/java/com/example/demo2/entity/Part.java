package com.example.demo2.entity;

import com.example.demo2.entity.interfaces.IPart;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "part")
public class Part implements IPart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String vendorCode;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "analog",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "analog_id"))
    List <Part> analogs;

    private String mark;

    private boolean available;

    @ManyToMany(targetEntity=com.example.demo2.entity.Kit.class)
    private List<Kit> kits;

    public Part(String name) {
        this.name = name;
    }

    public Part() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }

    @Override
    public List<Part> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<Part> analogs) {
        this.analogs = analogs;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", price=" + price +
                ", analogs=" + analogs +
                ", mark='" + mark + '\'' +
                ", available=" + available +
                ", kits=" + kits +
                '}';
    }
}
