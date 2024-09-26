package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Hooks;

    public class ApiDemosPage extends Hooks {

        public ApiDemosPage(){PageFactory.initElements(androidDriver,this);}

//        @FindBy(xpath ="//android.widget.TextView[@content-desc=\"Access'ibility\"]" )
//        public WebElement accessibilityButton ;

        public WebElement findelementByAccessibilityId(String id){
            return androidDriver.findElementByAccessibilityId(id) ;
        }

//        public WebElement accessbilityId =
//                androidDriver.findElementByAccessibilityId("Access'ibility");

        public WebElement getAccessibilityButton(){
            return findelementByAccessibilityId("Access'ibility");
        }

        public WebElement getViewsButton(){
            return findelementByAccessibilityId("Views");
        }

        public WebElement getListsButton(){
            return findelementByAccessibilityId("Lists");
        }

        public void clickElement(WebElement element){element.click();}

    }

