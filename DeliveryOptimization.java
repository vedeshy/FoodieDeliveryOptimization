import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Order {
    int id;
    String address;
    int orderTime;
    int prepTime;
    int deadline;

    public Order(int id, String address, int orderTime, int prepTime) {
        this.id = id;
        this.address = address;
        this.orderTime = orderTime;
        this.prepTime = prepTime;
        this.deadline = orderTime + prepTime;
    }
}

public class DeliveryOptimization {
    private static double distanceBetween(Order a, Order b) {
        // This method would return distance between two orders
        double distance = 0;
        return distance;
    }

    public static List<Order> optimizeDeliveryRoute(List<Order> orders) {
        orders.sort(Comparator.comparingInt(o -> o.deadline));

        List<Order> optimizedRoute = new ArrayList<>();
        PriorityQueue<Order> unvisitedOrders = new PriorityQueue<>(orders);

        Order currentOrder = unvisitedOrders.poll();

        while (currentOrder != null) {
            optimizedRoute.add(currentOrder);
            Order nextOrder = null;
            double minDistance = Double.MAX_VALUE;

            for (Order candidateOrder : unvisitedOrders) {
                double distance = distanceBetween(currentOrder, candidateOrder);
                if (distance < minDistance) {
                    minDistance = distance;
                    nextOrder = candidateOrder;
                }
            }

            unvisitedOrders.remove(nextOrder);
            currentOrder = nextOrder;
        }

        return optimizedRoute;
    }

    public static void main(String[] args) {
        // Orders would be processed and added to this list
        // orders.add(new Order(123, "123 Main St", 10, 30));
        List<Order> orders = new ArrayList<>();
        
        List<Order> optimizedRoute = optimizeDeliveryRoute(orders);

        System.out.println("Optimized delivery route:");
        for (Order order : optimizedRoute) {
            System.out.println("Order ID: " + order.id + ", Address: " + order.address);
        }
    }
}
