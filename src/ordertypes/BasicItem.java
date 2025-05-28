package ordertypes;

public abstract class BasicItem {
    public Byte id;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    protected static Byte ID = 0;


    public Byte getId() {return id;}

    public void setId(Byte id) {this.id = id;}

    public String getItemName() {return itemName;}

    public void setItemName(String itemName) {this.itemName = itemName;}

    public String getItemDescription() {return itemDescription;}

    public void setItemDescription(String itemDescription) {this.itemDescription = itemDescription;}

    public Double getItemPrice() {return itemPrice;}

    public void setItemPrice(Double itemPrice) {this.itemPrice = itemPrice;}

}
