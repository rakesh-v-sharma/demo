package com.programmerio.Shoppingcart;


import javax.persistence.*;

@Entity
@Table(name = "items")
public class ItemsModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Column(name = "is_deleted")
    private boolean isDeleted;


    public ItemsModel(String name, String description, long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemsModel() {
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", desc=" + description + ", price=" + price + "]";
    }

}

