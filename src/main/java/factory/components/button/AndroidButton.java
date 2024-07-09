package factory.components.button;

public class AndroidButton implements Button {
    //implement button interface

    @Override
    public void showButton() {
        System.out.println("Showing android button");
    }

    @Override
    public void clickButton() {
        System.out.println("Clicking android button");
    }
}
