package day06;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import page.AmazonPage;
import utils.HooksWeb;

public class CO7_BrowserTest extends HooksWeb {

    AmazonPage amazonPage = new AmazonPage(androidDriver);

    @Test
    public void test01(){
        androidDriver.get("https://www.amazon.com");
    }



    @Test
    public void searchTextBox() {
        androidDriver.get("https://www.amazon.com");
        amazonPage.execetuEelement(amazonPage.searchTextBoxJS("Mobile Phone")); //amazonda search box ında mobile phone arattık.
        amazonPage.execetuEelement(amazonPage.clickSearchBoxJS());
    }
}
