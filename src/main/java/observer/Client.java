package observer;

public class Client {

    public static void main(String[] args) {

        Amazon amazon = Amazon.getInstance();
        //Amazon amazon = new Amazon();

        EmailSender emailSender = new EmailSender();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        AnalyticsSender analyticsSender = new AnalyticsSender();

        amazon.orderPlaced();

        emailSender.announcedOrderPlaced();
        invoiceGenerator.announcedOrderPlaced();
        analyticsSender.announcedOrderPlaced();

        invoiceGenerator.generateInvoice();
        emailSender.sendEmail();

        analyticsSender.announceOrderCancelled();
    }
}
