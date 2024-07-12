package adapter.thirParty.icicibank;

public class ICICIBank {
    //ICICIbank use the method name as make payment to transfer the amount
    //not necessarily every bank keep this method as same as other bank
    //In Yes Bank, they might use transferMoney instead of makePayment
    public void makePayment(String to, String from, int amount){
        System.out.println("Transferring money via ICICI Bank");
    }
}
