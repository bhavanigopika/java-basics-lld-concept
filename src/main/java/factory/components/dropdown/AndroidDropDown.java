package factory.components.dropdown;

public class AndroidDropDown implements DropDown {
    @Override
    public void showDropDown() {
        System.out.println("Showing android dropdown");
    }

    @Override
    public void collapseDropDown() {
        System.out.println("Collapse android dropdown");
    }
}
