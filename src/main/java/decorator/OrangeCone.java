package decorator;

public class OrangeCone implements IceCreamConeConstituents{
    //enforce the user to inject only orange cone because without a single cone, we can't add any scoop, chips, toppings or even some other cone.
    //So, let's decide here that user have to inject only orange cone first
    @Override
    public String getDescription() {
        return "Orange cone";
    }

    @Override
    public int getCost() {
        return 25;
    }

    public void setVitaminCLevel(int vitaminCLevel) {

    }
}
