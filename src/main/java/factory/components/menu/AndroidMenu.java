package factory.components.menu;

public class AndroidMenu implements Menu {
    @Override
    public void showMenu() {
        System.out.println("Showing android menu");
    }

    @Override
    public void hideMenu() {
        System.out.println("Hiding android menu");
    }
}
