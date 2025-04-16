package designPattern.adapter;

import designPattern.adapter.thirdParty.yesbank.YesBankAPI;

public class YesBankAdapter implements BankAPIAdapter {
    //The following line represents objects of 3rd party application of yes bank.
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return yesBankAPI.examineBalance(accountNumber);
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("sending " + amount + " from " + fromAccount + " account to " + toAccount + " account in Yes Bank.");
        return false;
    }
}
