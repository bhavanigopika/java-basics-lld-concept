package designPattern.adapter;

import org.springframework.http.converter.json.GsonBuilderUtils;

public class PhonePe {
    private static BankAPIAdapter bankAPI = new YesBankAdapter();
    private static BankAPIAdapter bankAPI1 = new ICICIBankAdapter();
    private String name;

    //here,we pass actual object of bankAPI, In spring boot project, we use dependency injection,
    //but talking about java, whenever we create an object of PhonePe, we will pass bankAPI object
    public PhonePe(BankAPIAdapter bankAPI, String name) {
        this.bankAPI = bankAPI;
        this.name = name;
    }

    double doSomething() throws InterruptedException {
        double currentBalance = bankAPI.getBalance("accountNumber");
        Thread.sleep(24 * 24 * 60 * 60 * 1000);
        return currentBalance * 2;
    }



}
