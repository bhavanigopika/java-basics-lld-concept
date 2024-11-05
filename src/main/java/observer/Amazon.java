package observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {

    private static Amazon instance = null;
    private List<OrderPlacedSubscriber> opsList = new ArrayList<>();

    private Amazon(){

    }

    public static Amazon getInstance(){
        if(instance == null){
            instance = new Amazon();
        }
        return instance;
    }
    //OrderPlacedSubscriber - interface
    void registerSubscriber(OrderPlacedSubscriber ops){
        opsList.add(ops);
    }

    void unregisterSubscriber(OrderPlacedSubscriber ops){
        opsList.remove(ops);
    }

    public void orderPlaced(){
        //Earlier, we did as
        /*
        InvoiceGenerator.generateInvoice();
        EmailSender.sendEmail();
        AnalyticsSender.notify();
         */
        //Now, doing observer pattern
        for(OrderPlacedSubscriber ops: opsList){
            ops.announcedOrderPlaced();
            System.out.println("***" + ops.announcedOrderPlaced() + "***");
        }
    }
}
