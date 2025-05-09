package designPattern.observer;

public class AnalyticsSender implements OrderPlacedSubscriber, OrderCancelledSubscriber{
    //I don't want to create object of Amazon for everytime when I have a new service
    //Here services are InvoiceGenerator, EmailSender, AnalyticsSender
    //So, following the singleton pattern here
    public AnalyticsSender(){
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);
    }

    @Override
    public ReturnData announceOrderPlaced() {
        System.out.println("Updating analytics");
        return null;
    }

    @Override
    public void announceOrderCancelled() {
        System.out.println("Cancelling the order");
    }
}
// VideoUploadHandler -> Publisher
// --------------  KAFKA Queue ----------------
// SpamChecker -> Subscribers
// VideoCompressor -> Subscribers
// CaptionGenerator ->Subscriber
