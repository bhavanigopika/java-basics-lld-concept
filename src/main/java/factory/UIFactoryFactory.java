package factory;

import factory.constants.Platform;

public class UIFactoryFactory {

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
