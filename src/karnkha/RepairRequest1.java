package karnkha;

/**
 *
 * @author chait
 */
public class RepairRequest1 {
    
    private Integer no;
    private String date;
    private String pname;
    private String name;
    private String pid;
    private String category;
    private Double cost;
    private Double price;
    private Integer quantity;
    private Double total;
    private Double result;
    private Double service;
    
    
    public RepairRequest1(Integer no, String date,String pid, String pname,String name, String category, Double cost, Double price, Integer quantity,Double total, Double service) {
        this.no = no;
        this.date = date;
        this.pname = pname;
        this.name=name;
        this.pid =pid;
        this.category = category;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.service = service;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getPname() {
        return pname;
    }
    
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the result
     */
    public Double getResult() {
        Double result = getPrice() * getQuantity();
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Double result) {
        this.result = result;
    }

    /**
     * @return the service
     */
    public Double getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Double service) {
        this.service = service;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


}