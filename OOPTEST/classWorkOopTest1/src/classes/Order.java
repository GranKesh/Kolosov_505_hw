package classes;

public class Order implements Interface2{
    private String status;
    protected String orderDate;
    protected int orderNumber;
    private double totalPrice;

    public static void privet(){
        System.out.println("privet");
    }

    public Order(int orderNumber, String orderDate){
        this.status = "Новый";
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalPrice = 0;
    }
    public String getStatus(){
        return status;
    }
    public String getOrderDate(){
        return orderDate;
    }
    public int getOrderNumber(){
        return orderNumber;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setStatus(String newStatus){
        if (status.equalsIgnoreCase("Доставлен")){
            System.out.println("Ошибка. Заказ уже доставлен.");
        }
        if (status.equalsIgnoreCase("Отправлен") && newStatus.equalsIgnoreCase("В обработке")){
            System.out.println("Ошибка. Заказ уже отправлен.");
        }
        if (status.equalsIgnoreCase("В обработке") && newStatus.equalsIgnoreCase("Новый")){
            System.out.println("Ошибка. Заказ уже в обработке.");
        }
        this.status = newStatus;
        System.out.println("Статус изменён на " + newStatus);
    }

    public void addPrice(double price){
        if (price > 0){
            totalPrice += price;
            System.out.println("Общая сумма заказа " + totalPrice + "руб.");
        }
        else {
           System.out.println("Ошибка. Сумма меньше 0");
        }
    }

    public void getOrferInfo(){
        System.out.println("Информация о заказе: ");
        System.out.println("Статус заказа: " + status);
        System.out.println("Дата создания заказа: " + orderDate);
        System.out.println("Номер заказа: " + orderNumber);
        System.out.println("Цена заказа = " + totalPrice + "руб.");
    }
}
