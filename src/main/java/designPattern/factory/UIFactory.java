package designPattern.factory;

import designPattern.factory.components.button.Button;
import designPattern.factory.components.menu.Menu;

public interface UIFactory {
    //UI factory having factory methods
    Button createButton();
    Menu createMenu();
}
