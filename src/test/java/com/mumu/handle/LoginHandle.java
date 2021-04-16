package com.mumu.handle;

import com.mumu.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/15 17:17
 */
public class LoginHandle extends BaseHandle{
    static Logger logger = Logger.getLogger(LoginHandle.class);
    public LoginPage loginpage;
    public LoginHandle(WebDriver driver) {
        super(driver);
        loginpage = new LoginPage(driver);
    }
    public void SendEmail(String email) {
        logger.debug("你输入得用户邮箱："+email);
        WebElement EmailElement = loginpage.GetEmailElement();
        ClearText(EmailElement);
        EmailElement.sendKeys(email);

    }

    public void SendPassword(String password) {
        logger.debug("你输入得用户密码："+password);
        WebElement PassworElement = loginpage.GetPasswordElement();
        ClearText(PassworElement);
        PassworElement.sendKeys(password);
    }
    public void ClickSenvenBox() {
        loginpage.GetSenvenElement().click();
    }

    public void ClickLogin() {
        logger.debug("你开始点击登陆按钮--->");
        loginpage.GetLoginButtonElement().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public String GetUserText() {
        loginpage.MoveToElement(loginpage.GetUsePngElement());
        String username = loginpage.GetUseInfoElement().getText();
        return username;
    }

    public void ClickSigninButton() {
        loginpage.GetSigninButtonElement().click();
    }
}
