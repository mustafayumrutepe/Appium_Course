package day05;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ApiDemosPage;
import utils.Hooks;
import utils.ReusableMethods;

public class C06_ApiDemosTest extends Hooks {
    ApiDemosPage apiDemosPage = new ApiDemosPage();
    ReusableMethods reusableMethods = new ReusableMethods();
    public AndroidTouchAction action;

    @Test
    public void clickAccessibilityButton(){
        apiDemosPage.clickElement(apiDemosPage.getAccessibilityButton());
    }


    @Test
    public void tabOnTheWithTouchAction(){
        action = new AndroidTouchAction(androidDriver);
        action.tap(PointOption.point(77,660)).perform();
    }

    @Test
    public void tabWithMethod(){
        reusableMethods.tabOnThePoints(77,660);
    }

    @Test
    public void scrollTest(){
        apiDemosPage.clickElement(apiDemosPage.getViewsButton());
        action = new AndroidTouchAction(androidDriver);
        action.longPress(PointOption.point(500,1600))
                .moveTo(PointOption.point(500,600)).release()
                .perform();
    }


    @Test
    public void scrollTestwithMethod(){
        apiDemosPage.clickElement(apiDemosPage.getViewsButton());
        reusableMethods.scroll(500, 1600, 500, 600);
        Assert.assertTrue(apiDemosPage.getListsButton().isDisplayed());
    }
}
