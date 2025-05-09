package designPattern.observer;

public class EmailSender implements OrderPlacedSubscriber{
    //I don't want to create object of Amazon for everytime when I have a new service
    //Here services are InvoiceGenerator, EmailSender, AnalyticsSender
    //So, following the singleton pattern here
    public EmailSender(){
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);
    }
    @Override
    public ReturnData announceOrderPlaced() {
        sendEmail();
        return null;
    }

    public void sendEmail(){
        System.out.println("Sending email");
    }
}
