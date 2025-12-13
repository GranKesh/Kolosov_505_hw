import classes.*;
public class Main {
    public static void main(String[] args) {
        Order.privet();
        Order order1 = new Order(1, "06.12.2025");
        ExpressOrder expressOrder1 = new ExpressOrder(5,5);

        order1.addPrice(1000);
        expressOrder1.addPrice(1500);
        order1.setStatus("Отправлен");
        order1.setStatus("Доставлен");

    }
}