package adapter;

public class PhonePe {
    //We should use dependency injection here
    //phonepe using the bankAPI interface
    //currently phonepe using icici third party system
    private static BankAPI bankAPI = new ICICIBankAdapter();
    private static BankAPI bankAPI2 = new YesBankAdapter();

    public static void main(String[] args) {
        //interface BankAPI method:
        //void sendMoney(String from, String to, int amount);
        bankAPI.sendMoney("1234", " 9876", 100);
        bankAPI2.sendMoney("3452", "5641", 500);
    }

}
