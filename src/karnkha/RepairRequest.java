package karnkha;

/**
 *
 * @author chait
 */
public class RepairRequest {
    
    private Integer no;
    private String date;
    private String name;
    private Integer phone;
    private String item;
    private Integer id;
    private String repairman;
    private String status;
    
    public RepairRequest(Integer no, String date, String name, Integer phone, String item, Integer id, String repairman, String status) {
        this.no = no;
        this.date = date;
        this.name = name;
        this.phone = phone;
        this.item = item;
        this.id = id;
        this.repairman = repairman;
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairman() {
        return repairman;
    }

    public void setRepairman(String repairman) {
        this.repairman = repairman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}