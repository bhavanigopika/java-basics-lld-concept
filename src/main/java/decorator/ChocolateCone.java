package decorator;

public class ChocolateCone implements IceCreamConeConstituents{
    //Apply dependency injection...the dependency of ChocolateCone provide and the dependency should come from outside..
    //No 2 concrete class depend on each other...so do interface

    //I want existing cost and description of an ice cream. so, I use DI here. DI should come from outside
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
