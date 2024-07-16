package observer;

public class InvoiceGenerator implements OrderPlacedSubscriber{

    public InvoiceGenerator(){
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);
    }
    @Override
    public ReturnData announcedOrderPlaced() {
        generateInvoice();
        return null;
    }
    public void generateInvoice() {
        System.out.println("I am generating invoice");
    }
}
