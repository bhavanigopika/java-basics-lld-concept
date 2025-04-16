
package designPattern.factory;

public class Flutter {
    //non-factory methods

    void refreshUI(){
        System.out.println("Refreshing UI");
    }
    void setTheme(){
        System.out.println("Theme set");
    }

    //factory methods - It is used to get the object of corresponding UIFactory type
    public UIFactory getUIFactory(String platform){
        //According to the platform, then this type of factory should return
        if(platform.equals("IOS")){
            return new iosUIFactory();
        }
        else if(platform.equals("Android")){
            return new AndroidUIFactory();
        }
        else if(platform.equals("Mac")){
            return new MacUIFactory();
        }
        else if(platform.equals("Windows")){
            return new WindowsUIFactory();
        }
        else{
            throw new RuntimeException("Unsupported platform");
        }
    }

    //Above things violate SRP and OCP. But actual problem is every platform we are mentioning here
    //in flutter class. Flutter should not handle all of these complexities. Tomorrow, if I want to change other OS platform
    //say linux, then I have to add changes (one more platform) in if-else that is in flutter class

    //Ideally, I should not make change in flutter class. So, don't use if-else here. Add if-else condition in a new class

}
