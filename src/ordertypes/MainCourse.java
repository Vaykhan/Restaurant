package ordertypes;

public class MainCourse extends BasicItem {
    String SpecialIngredient;
    public MainCourse(String title, String description, Double price, String SpecialIngredient ) {
        super.setId(ID++);
        super.setItemName(title);
        super.setItemDescription(description);
        super.setItemPrice(price);
        this.SpecialIngredient = SpecialIngredient;
    }

    @Override
    public String toString() {
        return getItemName() + " | "+ getItemPrice() + " | " + this.SpecialIngredient + " | \n|" + getItemDescription() + "|";
    }
}
