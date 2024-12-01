package dao;

import model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();
    public void addOrder(Order order) {
        orders.put(order.getUserId(), order);
    }

    public void removeOrder (Order order) {
        orders.remove(order.getUserId());
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Order getOrderByUserId(Integer userId) {
        return orders.get(userId);
    }
}
