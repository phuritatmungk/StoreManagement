/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karnkha;

/**
 *
 * @author chait
 */
public class SalesReport {
    
    private String id;
    private String name;
    private String category;
    private Integer quantity;
    private Double cost;
    private Double total;
    private String date;
    private Double price;
    private Double service;

    public SalesReport(String date, String id, String name, String category, Double cost, Integer quantity, Double price, Double total, Double service) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getService() {
        return service;
    }

    public void setService(Double service) {
        this.service = service;
    }
}
