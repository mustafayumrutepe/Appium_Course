package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class HooksWebIOS {
    public static AppiumDriver appiumDriver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp(){
        try {
            capabilities.setCapability("deviceName",ConfigReader.getProperty("iPhone 11 Pro"));
            capabilities.setCapability("platformName",ConfigReader.getProperty("iOS"));
            capabilities.setCapability("platformVersion",ConfigReader.getProperty("15.6.1"));
            capabilities.setCapability("browserName", "safari");
            capabilities.setCapability("safari:useSimulator", true);
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("disableIdLocatorAutocompletion", true); //bunu ben kendim ekledim. inspectorda id bulurken appium kendisi otomotik olarak bir paket ismi atıyor bu da locatoru bulmamızı engelliyor. bunu disable yaptık
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (MalformedURLException e){
            System.out.println("Malformed Url Exception" + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        if (appiumDriver != null){
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
