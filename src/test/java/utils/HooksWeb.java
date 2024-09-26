package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class HooksWeb {
    public static AndroidDriver<WebElement> androidDriver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp(){
        try {
            capabilities.setCapability("deviceName",ConfigReader.getProperty("deviceName"));
            capabilities.setCapability("platformName",ConfigReader.getProperty("platformName"));
            capabilities.setCapability("platformVersion",ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability("automationName",ConfigReader.getProperty("automationName"));
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("disableIdLocatorAutocompletion", true); //bunu ben kendim ekledim. inspectorda id bulurken appium kendisi otomotik olarak bir paket ismi atıyor bu da locatoru bulmamızı engelliyor. bunu disable yaptık
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (MalformedURLException e){
            System.out.println("Malformed Url Exception" + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        if (androidDriver != null){
            androidDriver.quit();
            androidDriver = null;
        }
    }
}
