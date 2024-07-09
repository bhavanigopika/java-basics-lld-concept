package factory;

import factory.constants.Platform;

public class Flutter {
    // Keep non-factory methods initially

    //Let's talk about functional part of UI
    void refreshUI(){
        System.out.println("Refreshing the UI");
    }
    void setTheme(){
        System.out.println("Setting theme");
    }

    //keep factory methods - This is core method
    //connect the UIfactory interface to apply factory method and this is abstract factory design pattern
    //get the UIfactory(getUIFactory) -> actually returns the object corresponding to the platform type

/*    UIFactory getUIFactory(String platform){
        if(platform == "iOS") {
            return new iOSFactory();
        }else if(platform == "Windows"){
            return new WindowsFactory();
        }else if(platform == "Android"){
            return new AndroidFactory();
        }else{
            throw new RuntimeException("Unsupported platform");
        }
    }*/

/*    UIFactory getUIFactory(Platform platform) {
        if(platform.equals(Platform.iOS)) {
            return new iOSFactory();
        }else if(platform.equals(Platform.WINDOWS)){
            return new WindowsFactory();
        }else if(platform.equals(Platform.ANDROID)) {
            return new AndroidFactory();
        }else{
            throw new RuntimeException("Invalid platform");
        }
    }*/

    //To reach practical factory design patter, we delete the above if else condition and copy in new class...Here the new class name is UIFactoryFactory
    //The code of if else for creating corresponding object is moved to UIFactoryFactory class - Practical Factory Design Pattern
    UIFactory getUIFactory(Platform platform){
        return UIFactoryFactory.getUIFactoryForPlatform(platform);
    }
}
