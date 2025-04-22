package designPattern.decorator;

public class ChocolateCone  implements IceCreamConeConstituents{
    private IceCreamConeConstituents iceCreamConeConstituents;

    //ChocolateCone is both base addon and topping.
    //For base add on, use default constructor and toppings, use parameterized constructor
    public ChocolateCone(){

    }
    public ChocolateCone(IceCreamConeConstituents iceCreamConeConstituents){
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }

    @Override
    public int getCost() {
        if(iceCreamConeConstituents != null){
            return iceCreamConeConstituents.getCost() + 30;
        }
        return 30;
    }

    @Override
    public String getDescription() {
        if(iceCreamConeConstituents != null){
            return iceCreamConeConstituents.getDescription() + " + Chocolate Cone";
        }
        return "Chocolate Cone";
    }
}
