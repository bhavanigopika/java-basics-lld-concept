package factory.components.menu;

public class iOSMenu implements Menu{
    @Override
    public void showMenu() {
        System.out.println("Showing iOS menu");
    }

    @Override
    public void hideMenu() {
        System.out.println("Hiding iOS menu");
    }
}
