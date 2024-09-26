package day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_DifferentDrivers {
    //If we only test on the Android apps, it is suggested to use AndroidDriver
    //If we test Android and IOS apps we should use AppiumDriver
    //If you will not test ios apps no need to use AppiumDriver

    AppiumDriver<MobileElement> appiumDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    @Test
    public void isCalculatorAppInstalled() throws MalformedURLException {
        capabilities.setCapability("deviceName","Pixel7");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("automationName","uiAutomator2");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/myCalculator.apk");
        //set-up the driver and implement the url
        appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"),capabilities);
        //to test for isAppInstalled we should find the bundle id of the application
        //download apk info from the apk pure website
        Assert.assertTrue(appiumDriver.isAppInstalled("com.google.android.calculator"));

    }


    //şimid bu deviceName falan onların yerine MobileCapabilityType ile yapacağız.
    /*
    Node.js kullanıyorsanız, Java nın MobileCapabilityType nin doğrudan access i yoktur. bu sebepten hata alma riski var.
     */
    @Test
    public void capabilityTypes() throws MalformedURLException {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel7");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/app/myCalculator.apk");
        appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"),capabilities);
    }


}
