package kz.iitu.midterm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`payment`")
public class Payment {

    // reservation fields and annotate with it's column to connect to jpa entity manager

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private int id;

    @Column(name = "pay_phoneId")
    private int phoneId;

    @Column(name = "pay_phoneName")
    private String phoneName;

    @Column(name = "pay_price")
    private int price;

    @Column(name = "pay_date")
    private String payDate;

    @Column(name = "pay_user_id")
    private int userId;

    public Payment() {
    }

    public Payment(int phoneId, String phoneName, int price, String payDate, int userId) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.price = price;
        this.payDate = payDate;
        this.userId = userId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getPhoneId() { return phoneId; }

    public void setPhoneId(int phoneId) { this.phoneId = phoneId; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public String getPayDate() { return payDate; }

    public void setPayDate(String payDate) { this.payDate = payDate; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", phoneId=" + phoneId +
                ", price=" + price +
                ", payDate='" + payDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}

