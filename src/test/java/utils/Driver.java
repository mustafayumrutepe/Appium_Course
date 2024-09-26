package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {
    public static AndroidDriver<AndroidElement> androidDriver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static AndroidDriver getAndroidDriver() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        URL appiumServerUrl = null;
        try {
            appiumServerUrl = new URL("http://127.0.0.1:4723");
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }

        if (androidDriver == null) {
            capabilities.setCapability("deviceName",ConfigReader.getProperty("deviceName"));
            capabilities.setCapability("platformName",ConfigReader.getProperty("platformName"));
            capabilities.setCapability("platformVersion",ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability("automationName",ConfigReader.getProperty("automationName"));
            capabilities.setCapability("app",System.getProperty("user.dir")+ConfigReader.getProperty("app"));
            capabilities.setCapability("noReset", false);
            // When set to false, the application is reset at the beginning of each test and starts from the beginning.
            // It doestn't leave anything in memory, it clears it automatically.
        }

        if (ConfigReader.getProperty("platformName").equals("Android")){
            assert appiumServerUrl != null;
            androidDriver = new AndroidDriver<AndroidElement>(appiumServerUrl, capabilities);
            androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }else {
            throw new UnsupportedOperationException("Invalid Platform Name");
        }

    return androidDriver;
    }

    public static void closeAppiumDriver(){
        if (androidDriver != null){
            androidDriver.closeApp();
            androidDriver = null;
        }
    }
    public static void quitAppiumDriver(){
        if (androidDriver != null){
            androidDriver.quit();
            androidDriver = null;
        }
    }

}
