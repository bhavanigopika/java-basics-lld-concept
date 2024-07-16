package observer;

public class EmailSender implements OrderPlacedSubscriber{
    public EmailSender() {
        Amazon amazon = Amazon.getInstance();
        amazon.registerSubscriber(this);
    }

    @Override
    public ReturnData announcedOrderPlaced() {
        sendEmail();
        return null;
    }

    public void sendEmail(){
        System.out.println("I am sending an email");
    }
}
