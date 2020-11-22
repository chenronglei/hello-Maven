package com.feiyu.web.helloworld;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelloWorld {
    public String sayHello() {
        return "Hello Maven!";
    }


    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());

        System.setProperty("webdriver.chrome.driver", "E:\\minieye\\E\\java\\IDEA\\chromedriver_win32\\chromedriver.exe");// chromedriver服务地址
        WebDriver driver = new ChromeDriver(); // 新建一个WebDriver 的对象，但是new 的是谷歌的驱动
        String url = "http://www.baidu.com";

        driver.get(url); // 打开指定的网站

        /*
         *
         * driver.findElement(By.id("kw")).sendKeys(new String[] { "hello" });//
         * 找到kw元素的id，然后输入hello driver.findElement(By.id("su")).click(); // 点击按扭
         */
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

        //执行js脚本
        WebElement element = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[6]"));
        JavascriptExecutor js = ( JavascriptExecutor ) driver;   //声明一个js执行器
        js.executeScript("arguments[0].click();",element);
//        String title = (String) js.executeScript("return document.title"); //调用执行器的executeScript方法执行js脚本
//        System.out.println(title);   //打印的是当前浏览器的title值
        driver.quit();
    }

}
