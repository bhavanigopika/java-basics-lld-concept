package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.menu.Menu;

public interface UIFactory {
    //This UIFactory interface having factory methods
    Button createButton();
    Menu createMenu();
}
