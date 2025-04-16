package designPattern.factory;

//This is kind of a helper class
public class UIFactoryFactory {
    //Factory method to get the object of the corresponding UIFactory
    public static UIFactory getUIFactory(Platform platform) {
        if(platform.equals(Platform.IOS)){
            return new iosUIFactory();
        }
        else if(platform.equals(Platform.ANDROID)){
            return new AndroidUIFactory();
        }
        else if(platform.equals(Platform.MACOS)){
            return new MacUIFactory();
        }
        else if(platform.equals(Platform.WINDOWS)){
            return new WindowsUIFactory();
        }
        else{
            throw new RuntimeException("Unsupported platform");
        }
    }
}
