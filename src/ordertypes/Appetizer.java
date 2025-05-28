package ordertypes;

public class Appetizer extends BasicItem {
    Byte spiceLevel;
    public Appetizer(String itemName, String itemDescription, Double itemPrice, Byte spiceLevel) {
        super.setId(ID++);
        super.setItemName(itemName);
        super.setItemDescription(itemDescription);
        super.setItemPrice(itemPrice);
        this.spiceLevel = spiceLevel;


    }

    @Override
    public String toString() {
        return getItemName() + " | "  + getItemPrice() + "₼ | " + spiceLevel + " | \n|" + getItemDescription() + "|";

    }
}
