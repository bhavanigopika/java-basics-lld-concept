package factory.components.button;

public class iOSButton implements Button{
    @Override
    public void showButton() {
        System.out.println("Showing iOS button");
    }

    @Override
    public void clickButton() {
        System.out.println("Clicking iOS button");
    }
}
