package decorator;

public class Client {
    public static void main(String[] args) {
        IceCreamConeConstituents iceCreamConeConstituents = new ChocoChips(
                                                                new VanillaScoop(
                                                                        new StrawberryScoop(
                                                                                new ChocoChips(
                                                                                        new ChocolateCone(
                                                                                                new ChocolateCone(
                                                                                                        new OrangeCone(

                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )

                                                                )
                                                            );

        System.out.println(iceCreamConeConstituents.getDescription());//Orange cone + Chocolate Cone + Chocolate Cone + Choco Chips + Strawberry Scoop + Vanilla Scoop + Choco Chips
        System.out.println(iceCreamConeConstituents.getCost());//25 + 30 + 30 + 5 + 15 + 10 + 5 = 120
    }
}
