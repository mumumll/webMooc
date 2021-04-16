package com.mumu.page;

import com.mumu.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import java.util.Set;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/15 17:19
 */
public class BasePage {
    public WebDriver driver;
    static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement GetElement(String key) {
        boolean flag=true;
        int i =0;
        WebElement Element=null;
        while(flag) {
            try {
                Element = driver.findElement(this.GetByLocal(key));
                flag=false;

            }
            catch(Exception e) {
                i=i+1;
                if(i ==10) {
                    flag=false;
                }
            }
        }
        return Element;

    }

    public By GetByLocal(String key) {
        ProUtil pro = new ProUtil("element.properties");
        logger.debug("你得定位信息得key为："+key);
        String Locator = pro.GetPro(key); //username=name>email
        String LocatorBy = Locator.split(">")[0];
        String LocatorValue = Locator.split(">")[1];
        logger.debug("你得定位方式为："+LocatorBy);
        logger.debug("你得定位值为："+LocatorValue);

        if(LocatorBy.equals("id")) {
            return By.id(LocatorValue);
        }else if(LocatorBy.equals("name")) {
            return By.name(LocatorValue);
        }else if(LocatorBy.equals("className")) {
            return By.className(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }

    public void MoveToElement(WebElement ToElement) {
        Actions MoseActions = new Actions(driver);
        MoseActions.moveToElement(ToElement).perform();
    }


    public boolean GetCookie(String key) {
        boolean flag = false;
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie:cookies) {
            if(cookie.getName().equals(key)) {
                flag = true;
            }
        }
        return flag;
    }
}
