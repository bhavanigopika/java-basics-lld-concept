package decorator;

public class StrawberryScoop implements IceCreamConeConstituents{

    //I want existing cost and description of an ice cream. so, I use DI here. DI should come from outside
    private IceCreamConeConstituents iceCreamConeConstituents;

    public StrawberryScoop(IceCreamConeConstituents iceCreamConeConstituents) {
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }

    @Override
    public String getDescription() {
        return iceCreamConeConstituents.getDescription() + " + Strawberry Scoop";
    }

    @Override
    public int getCost() {
        return iceCreamConeConstituents.getCost() + 15;
    }
}
