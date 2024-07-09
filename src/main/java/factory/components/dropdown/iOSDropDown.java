package factory.components.dropdown;

public class iOSDropDown implements DropDown {
    @Override
    public void showDropDown() {
        System.out.println("Showing iOS dropdown");
    }

    @Override
    public void collapseDropDown() {
        System.out.println("Collapse iOS dropdown");
    }
}
