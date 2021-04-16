package com.mumu.runcase;

import com.mumu.common.TestNGListenerScreen;
import com.mumu.handle.CourseHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/16 11:39
 */
@Listeners({TestNGListenerScreen.class})
public class CourseCase extends BaseCase {
    static Logger logger = Logger.getLogger(CourseCase.class);

    public WebDriver driver;
    CourseHandle coursehandle;

    @Parameters({"url","browser"})
    @BeforeClass
    //@BeforeGroups(groups="sucess")
    //@Test
    public void beforeClass(String url,String browser) {
        System.out.println("---------->case开始执行的第一个beforeClass");
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");
        logger.debug("打开浏览器");
        driver = GetDriver(browser);
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        coursehandle = new CourseHandle(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }


    // 默认没有在xml中渠道值 @Optional("mushishi@qq.com,111111")
    @Parameters({"coursename"})
    @Test
    public void TestAddCourseSucess(String coursename) {
        System.out.println("---------->case开始执行的第一个coursecase");
        int a = 0;
        logger.debug("开始执行第一个case");
        String course_title = coursehandle.GetTitle();
        boolean flag = course_title.contains(coursename);
        Assert.assertEquals(flag, true);
        //Assert.assertEquals(course_title, "慕虎0064869");
        int before_number = coursehandle.GetCartNum();
        coursehandle.ClickAddCart();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int after_number = coursehandle.GetCartNum();
        a = after_number-before_number;
        Assert.assertEquals(a, 1);
    }
    @Test
    public void TestAleradyBuy() {
        coursehandle.ClickAddCart();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        coursehandle.ClickCartSure();
    }
    @Test
    public void TestAlreadyLogin() {
        coursehandle.SetUserCookie();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.navigate().refresh();
        //coursehandle.ClickAddCart();
        coursehandle.ClickBuyNow();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
