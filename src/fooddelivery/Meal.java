package fooddelivery;

public class Meal extends MenuItem {
    private static final double TOPPING_PRICE = 1.5;
    private int extraToppings;

    public Meal(String name, double basePrice, int extraToppings) {
        super(name, basePrice);
        this.extraToppings = extraToppings;
    }

    @Override
    public double getPrice() {
        return getBasePrice() + extraToppings * TOPPING_PRICE;
    }
}