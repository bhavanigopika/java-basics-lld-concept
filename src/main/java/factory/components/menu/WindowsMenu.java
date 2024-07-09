package factory.components.menu;

public class WindowsMenu implements Menu {
    @Override
    public void showMenu() {
        System.out.println("Showing windows menu");
    }

    @Override
    public void hideMenu() {
        System.out.println("Hiding windows menu");
    }
}
