/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karnkha;

/**
 *
 * @author chait
 */
public class EmployeeInfo {
    
    private Integer no;
    private String fname;
    private String id;
    private String job;
    private Double wage;
    private String phone;
    private String address;
    private String sname;
    private String full;
    private String img;

    public EmployeeInfo(Integer no, String fname, String sname, String id, String job, Double wage, String phone, String address,String img) {
        this.no = no;
        this.fname = fname;
        this.sname = sname;
        this.id = id;
        this.job = job;
        this.wage = wage;
        this.phone = phone;
        this.address = address;
        this.img = img;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFull() {
        String full = getFname() + " " + getSname();
        return full;
    }

    public void setFull(String full) {
        this.full = full;
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