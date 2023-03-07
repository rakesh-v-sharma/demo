package com.programmerio.Shoppingcart;



import javax.persistence.*;

@Entity
@Table(name = "cart")
public class CartModel {
    public CartModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="item_id")
    private long itemId;

    @Column(name="item_quantity")
    private int itemQuantity;




    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }


    public CartModel( long itemId, int itemQuantity) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "CartModel{" +
                "cartId=" + id +
                ", itemId=" + itemId +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
