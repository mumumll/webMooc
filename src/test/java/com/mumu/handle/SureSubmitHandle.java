package com.mumu.handle;

import com.mumu.page.SureSubmitPage;
import org.openqa.selenium.WebDriver;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/16 11:44
 */
public class SureSubmitHandle extends BaseHandle {
    public SureSubmitPage suresubmitpage;
    //public WebDriver driver;

    public SureSubmitHandle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        suresubmitpage = new SureSubmitPage(driver);
    }

    public void ClickSureSubmitElement() {
        /**
         * 点击确认订单按钮
         * */
        ClickElement(suresubmitpage.GetSureSubmitElement());
    }
}
