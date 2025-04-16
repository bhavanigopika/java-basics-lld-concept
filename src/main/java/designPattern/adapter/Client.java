package designPattern.adapter;

public class Client {
    static PhonePe phonePe;
    private static BankAPIAdapter bankAPI = new ICICIBankAdapter();
    private static BankAPIAdapter bankAPI1 = new YesBankAdapter();

    public static void main(String[] args) throws InterruptedException {
        bankAPI.sendMoney("Vidhu", "Krish", 100000);
        System.out.println(bankAPI.getBalance("VI7678687"));

        bankAPI1.sendMoney("Sam", "John", 89000);
        System.out.println(bankAPI1.getBalance("SAM9896567"));

        //System.out.println(phonePe.doSomething());
    }
}
