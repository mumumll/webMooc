package com.mumu.runcase;

import com.mumu.common.TestNGListenerScreen;
import com.mumu.handle.SureSubmitHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/16 11:45
 */
@Listeners({TestNGListenerScreen.class})
public class SureSubmitCase extends BaseCase{
    static Logger logger = Logger.getLogger(SureSubmitCase.class);

    public WebDriver driver;
    SureSubmitHandle sure_submit_handle;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url,String browser) {
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
        sure_submit_handle = new SureSubmitHandle(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //sure_submit_handle.SetUserCookie();

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Parameters({"url"})
    @Test
    public void LoginSureSubmit(String url) {
        String submit_title;
        sure_submit_handle.SetUserCookie();
        driver.get(url);
        submit_title = sure_submit_handle.GetTitle();
        boolean flag = submit_title.contains("确认订单");
        Assert.assertEquals(flag, true);
        sure_submit_handle.ClickSureSubmitElement();
    }

    @Parameters({"url"})
    @Test
    public void SureSubmit(String url) {
        //sure_submit_handle.SetUserCookie();
        String submit_title;
        driver.get(url);
        submit_title = sure_submit_handle.GetTitle();
        boolean flag = submit_title.contains("登陆");
        Assert.assertEquals(flag, true);
        //sure_submit_handle.ClickSureSubmitElement();
    }




}
