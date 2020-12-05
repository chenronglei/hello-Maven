package com.feiyu.web.helloworld;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class test1 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "E:\\minieye\\E\\java\\IDEA\\chromedriver_win32\\chromedriver.exe");// chromedriver服务地址
        WebDriver driver = new ChromeDriver(); // 新建一个WebDriver 的对象，但是new 的是谷歌的驱动
        String url = "http://www.baidu.com";
        driver.get(url); // 打开指定的网站

        try {
            /**
             * WebDriver自带了一个智能等待的方法。 dr.manage().timeouts().implicitlyWait(arg0, arg1）；
             * Arg0：等待的时间长度，int 类型 ； Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取当前浏览器的信息
        System.out.println("Title:" + driver.getTitle());
        System.out.println("currentUrl:" + driver.getCurrentUrl());
        Assert.assertEquals( driver.getTitle(),"百度一下，你就知道");
        for(int i=0;i<3;i++){
            try{
                driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[6]")).click();
                Thread.sleep(5000);
                break;
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        driver.quit();
    }
}
