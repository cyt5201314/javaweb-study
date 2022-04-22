package night.pojo;

import java.sql.Date;

/**
 * @author night520
 * @create 2022-04-15
 */
public class Record {
    //primary key(start from 1)
    private int id;

    //date(yyyy-mm-dd)
    private Date recordDate;

    //category(meals,daily necessities,traffic...)(varchar 25)
    private String category;

    //spend amount(japan yen)
    private int amount;

    //remark (varchar 100)
    private String remark;

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRecordDate() {return recordDate;}

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
