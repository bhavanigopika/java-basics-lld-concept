package designPattern.decorator;

public class StrawberryScoop implements IceCreamConeConstituents{
    private IceCreamConeConstituents iceCreamConeConstituents;

    //StrawberryScoop is toppings, so we didn't add default constructor. So here add only parameterized constructor
    public StrawberryScoop(IceCreamConeConstituents iceCreamConeConstituents) {
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }
    @Override
    public int getCost() {
        return iceCreamConeConstituents.getCost() + 15;
    }

    @Override
    public String getDescription() {
        return iceCreamConeConstituents.getDescription() + " + Strawberry Scoop";
    }
}
