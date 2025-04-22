package designPattern.decorator;

public class VanillaScoop implements IceCreamConeConstituents{
    private IceCreamConeConstituents iceCreamConeConstituents;

    //Vaniila Scoop is toppings, so we didn't add default constructor. So here add only parameterized constructor
    public VanillaScoop(IceCreamConeConstituents iceCreamCone){
        this.iceCreamConeConstituents = iceCreamCone;
    }

    @Override
    public int getCost() {
        return iceCreamConeConstituents.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return iceCreamConeConstituents.getDescription() + " + Vanilla Scoop";
    }
}
