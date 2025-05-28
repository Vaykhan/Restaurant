package ordertypes;


public class Drink extends BasicItem {
    Boolean isFizzy;
    public Drink(String name, String itemDescription, Double itemPrice, Boolean isFizzy ) {
        super.setId(ID++);
        super.setItemName(name);
        super.setItemDescription(itemDescription);
        super.setItemPrice(itemPrice);
        this.isFizzy = isFizzy;

    }
    @Override
    public String toString() {
        String isfizzy = isFizzy ? "Fizzy" : "Not Fizzy";
        return getItemName() + " | " + getItemPrice() + " | " + isfizzy + " | \n|" + getItemDescription() + "|";
    }
}
