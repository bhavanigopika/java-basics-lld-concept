package designPattern.observer;

public class InvoiceGenerator implements OrderPlacedSubscriber{
   //Let's create constructor
   public InvoiceGenerator(){
       //I don't want to create object of Amazon for everytime when I have a new service
       //Here services are InvoiceGenerator, EmailSender, AnalyticsSender
       //So, following the singleton pattern here
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);

   }
   @Override
    public ReturnData announceOrderPlaced() {
        generateInvoice();
        return null;
    }

    public void generateInvoice(){
        System.out.println("Generating Invoice");
    }
}
