package factory;

import factory.components.button.Button;
import factory.components.dropdown.DropDown;
import factory.components.menu.Menu;
import factory.constants.Platform;

public class Client {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();

        //we change any platform here as iOS, Windows, Android...We should not change other than this(in bracket)....related platform output will come
        //UIFactory uifac= flutter.getUIFactory("hghgh");

        //now we changed into enum...so give as Platform.WINDOWS, Platform.ANDROID, Platform.iOS
        UIFactory uifac = flutter.getUIFactory(Platform.iOS);

        Button button = uifac.createButton(); //I will get iOS button
        button.clickButton();//output: Clicking iOS button
        button.showButton();//output: Showing iOS button

        System.out.println("***********");

        Menu menu = uifac.createMenu();
        menu.showMenu();//output: Showing iOS menu
        menu.hideMenu();//output: Hiding iOS menu

        System.out.println("***********");

        DropDown dropDown = uifac.createDropDown();
        dropDown.showDropDown();//output: Showing iOS dropdown
        dropDown.collapseDropDown();//output: Collapse iOS dropdown
    }
}
