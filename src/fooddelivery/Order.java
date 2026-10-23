package fooddelivery;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderNumber = 1001;

    private int orderNumber;
    private String customerName;
    private DeliveryOption delivery;
    private OrderStatus status;
    private List<OrderLine> lines = new ArrayList<>();
    private double amountPaid;

    public Order(String customerName, DeliveryOption delivery) {
        this.orderNumber = nextOrderNumber++;
        this.customerName = customerName;
        this.delivery = delivery;
        this.status = OrderStatus.NEW;
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int qty) {
        if (status != OrderStatus.NEW)
            throw new IllegalStateException("Items can only be added while the order is NEW");
        if (qty <= 0)
            throw new IllegalArgumentException("Quantity must be positive");
        lines.add(new OrderLine(item, qty));
    }

    public double getSubtotal() {
        double sum = 0;
        for (OrderLine line : lines) {
            sum += line.getLineTotal();
        }
        return sum;
    }

    public double getTotal() {
        return getSubtotal() + delivery.getFee();
    }

    public void pay(PaymentMethod method) {
        if (status != OrderStatus.NEW)
            throw new IllegalStateException("Only a NEW order can be paid");
        amountPaid = method.pay(getTotal());
        status = OrderStatus.PAID;
    }

    public void deliver() {
        if (status != OrderStatus.PAID)
            throw new IllegalStateException("Only a PAID order can be delivered");
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.NEW)
            throw new IllegalStateException("Only a NEW order can be cancelled");
        status = OrderStatus.CANCELLED;
    }

    public int getOrderNumber() { return orderNumber; }
    public String getCustomerName() { return customerName; }
    public OrderStatus getStatus() { return status; }
    public double getAmountPaid() { return amountPaid; }
}