package com.mumu.handle;

import com.mumu.page.CoursePage;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/16 11:37
 */
public class CourseHandle extends BaseHandle{
    static Logger logger = Logger.getLogger(CourseHandle.class);
    public CoursePage coursepage;
    public WebDriver driver;
    public CourseHandle(WebDriver driver) {
        super(driver);
        this.driver = driver;
        coursepage = new CoursePage(driver);
    }
    /**
     * 点击添加购物车
     * */
    public void ClickAddCart() {
        ClickElement(coursepage.GetAddCartElement());
    }

    /**
     * 点击立即购买
     * */
    public void ClickBuyNow() {
        ClickElement(coursepage.GetBuyElement());
    }

    /**
     * 点击模态框确定按钮
     * */
    public void ClickCartSure() {
        ClickElement(coursepage.GetCartSureElement());
    }

    /**
     * 点击购物车按钮
     * */
    public void ClickCart() {
        ClickElement(coursepage.GetCartElement());
    }

    /**
     * 获取购物车商品数量
     * */
    public int GetCartNum() {
        int CartNum;
        try {
            CartNum = Integer.parseInt(coursepage.GetCartNumElement().getText());
        }catch(Exception e){
            CartNum = 0;
        }
        return CartNum;

    }
}
