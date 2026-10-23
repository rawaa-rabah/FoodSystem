package fooddelivery;

public class Main {
    public static void main(String[] args) {
        Order order = new Order("Rawaa", new ExpressDelivery());

        order.addItem(new Meal("Burger Meal", 8, 1), 2);
        order.addItem(new Drink("Juice", 3, true));

        System.out.println("Order #" + order.getOrderNumber() + " - " + order.getStatus());
        System.out.printf("Subtotal = %.2f%n", order.getSubtotal());
        System.out.printf("Total    = %.2f%n", order.getTotal());

        order.pay(new CardPayment());
        System.out.printf("Paid by card = %.2f%n", order.getAmountPaid());
        System.out.println("Status: " + order.getStatus());

        order.deliver();
        System.out.println("Status: " + order.getStatus());
    }
}