package day04;

import io.appium.java_client.TouchAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AndroidTestPage;
import utils.Driver;
import utils.ReusableMethods;

import static io.appium.java_client.touch.offset.PointOption.point;

public class C05_AndroidTestApk {


    Driver driver = new Driver();
    AndroidTestPage androidTestPage = new AndroidTestPage();
    ReusableMethods reusableMethods = new ReusableMethods();

    @BeforeTest
    public void setUp() {

        driver.getAndroidDriver();
    }

    @Test
    public void tabOnThePointwithTouchAction() {
        // TouchAction class i Selenium daki Action class ina benzer ozellikler tasir
        // Note: aldigimiz point ler kullandigimiz device a gore degisiklik gosterebilir, bu konuda dikkatli olalim
        TouchAction action = new TouchAction(driver.getAndroidDriver()) ;
        action.tap(point(91,118)).perform();
        reusableMethods.waitFor(3);

    }
    @Test
    public void dynamicTabMethodUsing(){
        reusableMethods.tabOnThePoints(91,118);
    }



    @AfterTest
    public void tearDown() {
        // driver.closeAppiumDriver();
    }
}







//package day04;
//
//import io.appium.java_client.TouchAction;
//import org.testng.annotations.*;
//import utils.Driver;
//import utils.ReusableMethods;
//
//import static io.appium.java_client.touch.offset.PointOption.point;
//
//public class C05_AndroidTestApi {
//    Driver driver = new Driver();
//    ReusableMethods reusableMethods = new ReusableMethods();
//
//    @BeforeTest
//    public void  setUp(){
//        //1-Launch the Android mobile application.
//        driver.getAndroidDriver();
//    }
//
//@Test
//public void tabOnThePointwithTouchAction(){
//        //TouchAction class i Selenium daki Action class ına benzer özellikler taşır.
//        //Note: aldığımız pointler kullandığımız device a göre değişiklik gösterebilir, bu konuda dikkatli olun
//    TouchAction action = new TouchAction(driver.getAndroidDriver());
//    action.tap(point(91,118)).perform();
//    //action.press(point(91, 118)).waitAction().release().perform();
//    reusableMethods.waitFor(3);
//}
//
//@Test
//public void dynamicTabMethodUsing(){
//    reusableMethods.tabOnThePoints(91,118);
//    reusableMethods.waitFor(3);
//}
//
//
//
//
//
//    @AfterTest
//    public void tearDown() {
//        driver.quitAppiumDriver();//hoca burda closeAppiumDriver() kullanmış bende hata verdiği için quit kullandım
//    }
//}
