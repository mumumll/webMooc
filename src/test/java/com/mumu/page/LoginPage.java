package com.mumu.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/15 17:18
 */
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //RegisterPage.java
    //获取元素
    /**
     * 获取 手机号 元素
     * 获取 验证码 元素
     * 获取 注册按钮 元素
     * */


    public WebElement GetEmailElement() {
        return GetElement("username");
    }

    public WebElement GetPasswordElement() {
        return GetElement("password");
    }

    public WebElement GetSenvenElement() {
        return GetElement("senven");
    }

    public WebElement GetLoginButtonElement() {
        return GetElement("loginbutton");
    }

    public WebElement GetUsePngElement() {
        return GetElement("headpng");
    }

    public WebElement GetUseInfoElement() {
        return GetElement("userinfo");
    }

    public WebElement GetSigninButtonElement() {
        return GetElement("signin_button");
    }

}
