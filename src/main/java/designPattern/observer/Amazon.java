package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
    //I don't want to create object of Amazon for everytime when I have a new service
    //Here services are InvoiceGenerator, EmailSender, AnalyticsSender
    //So use singleton design pattern - see 8, 12-14 line
    private static Amazon instance;

    private List<OrderPlacedSubscriber> orderPlacedSubscriberList = new ArrayList<>();

    public static Amazon getInstance(){
        if(instance == null){
            instance = new Amazon();
        }
        return instance;
    }
    void registerSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscriberList.add(orderPlacedSubscriber);
    }

    void unregisterSubscriber(OrderPlacedSubscriber orderPlacedSubscriber) {
        orderPlacedSubscriberList.remove(orderPlacedSubscriber);
    }

    public void orderPlaced(){
//        an.notify();
//        ig.generateInvoice();
//        es.send();

        for(OrderPlacedSubscriber orderPlacedSubscriber : orderPlacedSubscriberList){
            orderPlacedSubscriber.announceOrderPlaced();
        }
    }

}
