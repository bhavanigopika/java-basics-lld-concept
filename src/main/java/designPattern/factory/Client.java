package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.menu.Menu;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        //From flutter, we are able to get tthe object of the ecorresponding UI factory based on the platform

        //we can change the platform either as Android, ios, Mac, Windows
        UIFactory uifactory = flutter.getUIFactory(Platform.MACOS);

        Button button = uifactory.createButton();
        button.displayButton();//Mac Button

        Menu menu = uifactory.createMenu();
        menu.displayMenu();//Mac Menu

        flutter.refreshUI();//Refreshing UI
        flutter.setTheme();//Theme set
    }
}
