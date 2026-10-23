package fooddelivery;

public class Drink extends MenuItem {
    private static final double LARGE_EXTRA = 1.0;
    private boolean large;

    public Drink(String name, double basePrice, boolean large) {
        super(name, basePrice);
        this.large = large;
    }

    @Override
    public double getPrice() {
        if (large) {
            return getBasePrice() + LARGE_EXTRA;
        }
        return getBasePrice();
    }
}