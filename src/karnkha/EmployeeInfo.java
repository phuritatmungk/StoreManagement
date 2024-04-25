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
    private Integer id;
    private String job;
    private Double wage;
    private Integer phone;
    private String address;
    private String sname;
    private String full;

    public EmployeeInfo(Integer no, String fname, String sname, Integer id, String job, Double wage, Integer phone, String address) {
        this.no = no;
        this.fname = fname;
        this.sname = sname;
        this.id = id;
        this.job = job;
        this.wage = wage;
        this.phone = phone;
        this.address = address;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
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
}