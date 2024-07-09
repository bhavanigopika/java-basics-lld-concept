package factory.helper;

import factory.AndroidFactory;
import factory.UIFactory;
import factory.WindowsFactory;
import factory.constants.Platform;
import factory.iOSFactory;

public class Helper {
    public static UIFactory getUIFactoryForPlatform(Platform platform) {
        if (platform.equals(Platform.iOS)) {
            return new iOSFactory();
        } else if (platform.equals(Platform.WINDOWS)) {
            return new WindowsFactory();
        } else if (platform.equals(Platform.ANDROID)) {
            return new AndroidFactory();
        } else {
            throw new RuntimeException("Invalid platform");
        }
    }
}
