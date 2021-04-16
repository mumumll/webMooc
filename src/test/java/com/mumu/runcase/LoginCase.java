package com.mumu.runcase;

import com.mumu.common.TestNGListenerScreen;
import com.mumu.handle.LoginHandle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author mumu
 * @Description: 登录
 * @date 2021/4/15 17:11
 */
@Listeners({TestNGListenerScreen.class})
public class LoginCase  extends BaseCase{
    static Logger logger = Logger.getLogger(LoginCase.class);

    public WebDriver driver;
    LoginHandle loginhandle;

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
        loginhandle = new LoginHandle(driver);
        loginhandle.ClickSigninButton();
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

    public void Test01() {
        System.out.println("---------->case开始执行的第一个Test01");
    }
    // 默认没有在xml中渠道值 @Optional("mushishi@qq.com,111111")

    @Parameters({"username","password"})
    public void TestLoginSucess(String username,String password) {
        logger.debug("开始执行第一个case");
        loginhandle.SendEmail(username);
        loginhandle.SendPassword(password);
        //loginhandle.ClickSenvenBox();
        loginhandle.ClickLogin();
        String username1 = loginhandle.GetUserText();
        Assert.assertEquals(username1, "xixihaha");

    }

    @Parameters({"username","password"})
    public void TestLoginEmailError(String username,String password) {
        logger.debug("开始执行第二个case");
        loginhandle.SendEmail(username);
        loginhandle.SendPassword(password);
        //loginhandle.ClickSenvenBox();
        loginhandle.ClickLogin();
        String username1 = loginhandle.GetUserText();
        Assert.assertEquals(username1, "nihao");
    }
}
