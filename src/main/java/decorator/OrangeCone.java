package decorator;

public class OrangeCone implements IceCreamConeConstituents{
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
