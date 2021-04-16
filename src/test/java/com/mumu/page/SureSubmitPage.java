package com.mumu.page;

import com.mumu.runcase.BaseCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author mumu
 * @Description: 确定订单
 * @date 2021/4/16 11:42
 */
public class SureSubmitPage extends BasePage {
    public SureSubmitPage(WebDriver driver) {
        super(driver);
    }
    public WebElement GetSureSubmitElement() {
        return GetElement("submit_order");
    }

}
