package adapter;

import adapter.thirParty.icicibank.ICICIBank;

public class ICICIAdapter implements BankAPI {

    private ICICIBank icicibank = new ICICIBank();


    @Override
    public void sendMoney(String from, String to, int amount) {
        icicibank.makePayment(to, from, amount);
    }

    @Override
    public void registerAccount(String accountNumber) {

    }

    @Override
    public long getBalance(String accountNumber) {
        return 0;
    }
}
