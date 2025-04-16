package designPattern.adapter;

import designPattern.adapter.thirdParty.icicibank.ICICIBankAPI;

public class ICICIBankAdapter implements BankAPIAdapter {
    //The following line represents objects of 3rd party application of icici bank.
    private ICICIBankAPI iciciBankAPI = new ICICIBankAPI();
    @Override
    public double getBalance(String accountNumber) {
        return iciciBankAPI.checkBalance(accountNumber);
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("sending " + amount + " from " + fromAccount + " account to " + toAccount + " account in ICICI Bank.");
        return false;
    }
}
