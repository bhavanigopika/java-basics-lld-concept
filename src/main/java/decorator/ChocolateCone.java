package decorator;

public class ChocolateCone implements IceCreamConeConstituents{
    //Apply dependency injection...the dependency pf ChocolateCone provide and the dependency should come from outside..
    //No 2 concrete class depend on each other...so do interface
    private IceCreamConeConstituents iceCreamConeConstituents;

    public ChocolateCone(){

    }

    public ChocolateCone(IceCreamConeConstituents iceCreamConeConstituents){
        this.iceCreamConeConstituents = iceCreamConeConstituents;
    }


    @Override
    public String getDescription() {
        if(iceCreamConeConstituents != null){
            return iceCreamConeConstituents.getDescription() + " + Chocolate Cone";
        }
        return "Chocolate Cone";
    }

    @Override
    public int getCost() {
        if(iceCreamConeConstituents != null){
            return iceCreamConeConstituents.getCost() + 30;
        }
        return 30;
    }
}
