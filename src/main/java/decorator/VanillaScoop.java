package decorator;

public class VanillaScoop implements IceCreamConeConstituents{

    //I want existing cost and description of an ice cream. so, I use DI here. DI should come from outside
    private IceCreamConeConstituents iceCreamConeConstituents;

    public VanillaScoop(IceCreamConeConstituents iceCreamConeConstituents) {
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }

    @Override
    public String getDescription() {
        //ofcourse these toppings will not be null and this is non-base entity...already base entity will be there
        //so we cannot say these object will be null...so you directly return the stmt
        return iceCreamConeConstituents.getDescription() + " + Vanilla Scoop";
    }

    @Override
    public int getCost() {
        return iceCreamConeConstituents.getCost() + 10;
    }
}
