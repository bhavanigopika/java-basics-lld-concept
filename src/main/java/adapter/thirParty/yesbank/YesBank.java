package adapter.thirParty.yesbank;

public class YesBank {
    //yesbank use the method name as transfer money to make payment....
    //not necessarily every bank keep this method as same as other bank
    //In ICICI, they might use makepayment instead of transferMoney
    public void transferMoney(int amount, String from, String to){
        System.out.println("Tranferring money via YES Bank");
    }
}
