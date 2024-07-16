package observer;

public class AnalyticsSender implements OrderPlacedSubscriber, OrderCancelledSubscriber {

    AnalyticsSender(){
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);
    }
    @Override
    public ReturnData announcedOrderPlaced() {
        System.out.println("I am updating analytics");
        return null;
    }

    @Override
    public void announceOrderCancelled() {
        System.out.println("Analytics cancelled. Not updating analytics");
    }

}
