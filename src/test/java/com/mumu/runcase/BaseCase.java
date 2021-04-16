package com.mumu.runcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author mumu
 * @Description: 公共服务加载浏览器
 * @date 2021/4/15 11:17
 */
public class BaseCase {
    public WebDriver driver;
    static Logger logger = Logger.getLogger(BaseCase.class);
    public WebDriver GetDriver(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            String chromePath = this.getClass().getResource("/chromedriver.exe").getPath();
            logger.debug("浏览器路径");
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            String edgePath = this.getClass().getResource("/msedgeDriver.exe").getPath().substring(1);
            System.setProperty("webdriver.edge.driver",edgePath);
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            String firePath = this.getClass().getResource("/geckodriver.exe").getPath().substring(1);
            System.setProperty("webdriver.gecko.driver",firePath);
            driver = new FirefoxDriver();
        }
        return driver;
    }

    /**
     * 测试启动浏览器
     */
    @Test
    public void driverTest(){
        String str1 = this.getClass().getResource("/chromedriver.exe").getPath().substring(1);
        System.out.println(str1);
       String str = this.getClass().getResource("/msedgeDriver.exe").getPath().substring(1);
        System.out.println(str);
        System.setProperty("webdriver.edge.driver",str);

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.baidu.com/");
    }
}
