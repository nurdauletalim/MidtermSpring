package kz.iitu.midterm.entities.room;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    @Column(name = "phone_name")
    private String phoneName;

    @Column(name = "phone_isAvailable")
    private boolean isAvailable;

    @Column(name = "phone_type")
    private PhoneType type;

    @Column(name = "phone_price")
    private int price;


    public Phone(int id, String phoneName, boolean isAvailable, PhoneType type, int price) {
        this.id = id;
        this.phoneName = phoneName;
        this.isAvailable = isAvailable;
        this.type = type;
        this.price = price;
    }

    public Phone() {
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------------------------------\n" +
                "|" +
                "ID: " + id +
                "| Name: " + phoneName +
                "| is Available: " + isAvailable +
                "| Type: " + type +
                "| Price: " + price +
                "\n";
    }
}
