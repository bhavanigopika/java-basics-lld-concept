package factory.components.dropdown;

public class WindowsDropDown implements DropDown {
    @Override
    public void showDropDown() {
        System.out.println("Showing windows dropdown");
    }

    @Override
    public void collapseDropDown() {
        System.out.println("Collapse windows dropdown");
    }
}
