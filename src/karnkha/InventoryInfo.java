/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karnkha;

/**
 *
 * @author chait
 */
public class InventoryInfo {
    
    private Integer no;
    private String id;
    private String name;
    private String category;
    private Integer quantity;
    private Double price;
    private Double cost;
    private Double total;
    private String date;
    private String img;

    public InventoryInfo(Integer no, String id, String date, String name, String category, Double cost, Integer quantity, Double price,String img) {
        this.no = no;
        this.id = id;
        this.date = date;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.quantity = quantity;
        this.price = price;
        this.img=img;
    }
    
    public Integer getNo() {
        return no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        Double total = getPrice() * getQuantity();
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

    /**
     * @return the img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }
}
