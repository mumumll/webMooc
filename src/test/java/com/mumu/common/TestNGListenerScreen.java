package com.mumu.common;

import com.google.common.io.Files;
import com.mumu.runcase.BaseCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mumu
 * @Description:
 * @date 2021/4/15 18:42
 */
public class TestNGListenerScreen extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getInstance());
        BaseCase tc = (BaseCase)tr.getInstance();
        WebDriver driver = tc.driver;

        this.TakeScreenShot(driver);
        super.onTestFailure(tr);
    }





    public void TakeScreenShot(WebDriver driver) {
        //图片名字
        //图片存的路径
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String curTime = sdf.format(new Date());
        //获取当前类名
        String curClassName = this.getClass().getName();
        String pngPath = curClassName+"_"+curTime+".png";
        //路径
        String curPath = System.getProperty("user.dir");

        File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile, new File(curPath+"\\"+pngPath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
