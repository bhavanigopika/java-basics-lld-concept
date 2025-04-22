package designPattern.decorator;

public class OrangeCone implements IceCreamConeConstituents{
    private IceCreamConeConstituents iceCreamConeConstituents;

    //OrangeCone is both base addon and topping.
    //For base add on, use default constructor and toppings, use parameterized constructor
    public OrangeCone(){

    }

    public OrangeCone(IceCreamConeConstituents iceCreamCone){
        this.iceCreamConeConstituents = iceCreamCone;
    }

    @Override
    public int getCost() {
        if(iceCreamConeConstituents != null){
            return iceCreamConeConstituents.getCost() + 20;
        }
        return 20;
    }

    @Override
    public String getDescription() {
       if(iceCreamConeConstituents != null){
           return iceCreamConeConstituents.getDescription() + " + Orange Cone";
       }
       return "Orange Cone";
    }

    public void setvitaminCLEvel(int newLevel){
        if(iceCreamConeConstituents != null){

        }
    }
}
