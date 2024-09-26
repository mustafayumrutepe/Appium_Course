package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetUpCapabilities {
    //Set-up Appium Environments

    //1st step : Create androidDriver from the AndroidDriver class
    AndroidDriver<AndroidElement> androidDriver;

    //2nd step : Create capabilities object from the DesiredCapabilities class
    DesiredCapabilities capabilities=new DesiredCapabilities();

    /*
    Why do we need to use capabilities?
    1-We should define name of the emulator, operating system, url, automation name, app name
    2-Capabilities are working as a key-value
     */

    @Test
    public void setUpCalculator() throws MalformedURLException {
        capabilities.setCapability("deviceName","Pixel7");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","12.0");
        capabilities.setCapability("automationName","uiAutomator2");
        //Download an application from the apkPure
        //create a package with name app under the project name then drag and drop the downloaded app.
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/myCalculator.apk");
        //set-up the driver and implement the url
        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"),capabilities);
        //AndroidDriver dan obje oluşturduk, içine url i implement ettik , sonra dedik ki kardeşim
        //sen url e gideceksin ama bu capabilities leri kullanacaksın dedik.
    }






}
