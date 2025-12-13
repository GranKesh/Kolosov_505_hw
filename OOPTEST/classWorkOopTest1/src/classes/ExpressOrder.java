package classes;

public class ExpressOrder extends Order implements Interface1{
    private int deliveryDays;
    private double expressPrice;

    public ExpressOrder(int OrderNubmers, int deliveryDays) {
        super(OrderNubmers, "");
        this.deliveryDays = deliveryDays;
        this.expressPrice = 500;
        super.addPrice(expressPrice);
    }

    public int getDeliveryDays(){
        return deliveryDays;
    }
    public int setDelivertDays(int deliveryDays){
        this.deliveryDays = deliveryDays;
        return deliveryDays;
    }

    public double getExpressPrice() {
        return expressPrice;
    }
}
