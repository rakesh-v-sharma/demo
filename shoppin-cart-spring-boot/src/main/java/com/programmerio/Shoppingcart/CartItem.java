package com.programmerio.Shoppingcart;

public class CartItem {
    private long itemId;
    private String itemDescription;
    private long price;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    private String itemName;

    public CartItem(long itemId, String itemDescription, long price, String itemName, int itemQuantity) {
        this.itemId = itemId;
        this.itemDescription = itemDescription;
        this.price = price;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    private int itemQuantity;

}
