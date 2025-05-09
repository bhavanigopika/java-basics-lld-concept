package decorator;

public class ChocoChips implements IceCreamConeConstituents {

    //I want existing cost and description of an ice cream. so, I use DI here. DI should come from outside
    //I need iceCreamConeConstituents object
    private IceCreamConeConstituents iceCreamConeConstituents;

    public  ChocoChips(IceCreamConeConstituents iceCreamConeConstituents) {
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }

    @Override
    public String getDescription() {
        return iceCreamConeConstituents.getDescription() + " + Choco Chips";
    }

    @Override
    public int getCost() {
        return iceCreamConeConstituents.getCost() + 5;
    }
}
