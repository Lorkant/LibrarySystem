package dao;

import model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private Map<Integer, List<Order>> orders = new HashMap<>();
    public void addOrder(Order order) {
        List<Order> ordersFromRepository = orders.get(order.getUserId());
        if (ordersFromRepository == null) {
            List<Order> newOrders = new ArrayList<>();
            newOrders.add(order);
            orders.put(order.getUserId(), newOrders);
        } else {
            ordersFromRepository.add(order);
        }
    }

    public void removeOrder (Order order) {
        orders.remove(order.getUserId());
    }

    public Map<Integer, List<Order>> getOrders() {
        return orders;
    }

    public List<Order> getOrdersByUserId(Integer userId) {
        return orders.get(userId);
    }
}
