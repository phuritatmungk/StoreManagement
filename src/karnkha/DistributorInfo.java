/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karnkha;

/**
 *
 * @author chait
 */
public class DistributorInfo {
    
    private Integer no;
    private String company;
    private String fname;
    private String sname;
    private String phone;
    private String address;
    private String salesman;
    private String img;
            
    public DistributorInfo(Integer no, String company, String fname, String sname, String phone,String address,String img) {
        this.no = no;
        this.company = company;
        this.fname = fname;
        this.sname = sname;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getPhone() {
        return phone;
    }

    public String getSalesman() {
        String salesman = getFname() + " " + getSname();
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
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