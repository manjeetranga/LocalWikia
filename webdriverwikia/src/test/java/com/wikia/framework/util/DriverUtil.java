package com.wikia.framework.util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {

    private static WebDriver driver;
    public static int timeout;
    private static int shortTimeOut = 0;
    private static int longTimeOut = 20;

    private DriverUtil() { }

    public static WebDriver getInstance()
    {
        if (driver == null)
        {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void increaseTimeout()
    {
        timeout = longTimeOut;
        int time = (timeout) / 4;
        resetTimeOut(time);
    }

    public static void decreaseTimeout()
    {
        timeout = shortTimeOut;
        int time = (timeout) / 4;
        resetTimeOut(time);
    }

    public static void resetTimeOut(int time)
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    
    public static void tearDown()
    {
    	getInstance().quit();
    	driver = null;
    }

}


