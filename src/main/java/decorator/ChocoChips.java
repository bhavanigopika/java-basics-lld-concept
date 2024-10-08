package decorator;

public class ChocoChips implements IceCreamConeConstituents {
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
