package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import utils.HooksWeb;

public class AmazonPage extends HooksWeb {

    public AmazonPage(AndroidDriver<WebElement> driver){
        this.androidDriver = driver ;
    }

    // Java Script Path
    public String searchTextBoxJS(String key){
        return "document.querySelector(\"#twotabsearchtextbox\").value='"+key+"';";
    }

    public String clickSearchBoxJS(){
        return "document.querySelector(\"#nav-search-submit-button\").click()";
    }

    public void execetuEelement(String element){
        androidDriver.executeScript(element);
    }

}
