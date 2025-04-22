package designPattern.decorator;

public class ChocoChips implements IceCreamConeConstituents{
    private IceCreamConeConstituents iceCreamConeConstituents;

    //ChocoChips is toppings, so we didn't add default constructor. So here add only parameterized constructor
    public ChocoChips(IceCreamConeConstituents iceCreamConeConstituents){
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }

    @Override
    public int getCost() {
       return iceCreamConeConstituents.getCost() + 5;
    }

    @Override
    public String getDescription() {
        return iceCreamConeConstituents.getDescription() + " + Choco-Chips";
    }
}
