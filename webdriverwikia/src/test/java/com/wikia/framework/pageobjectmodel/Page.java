package com.wikia.framework.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.wikia.framework.exceptions.PageNotLoadedException;
import com.wikia.framework.util.DriverUtil;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait = null;
    public Page()
    {
        this.driver = DriverUtil.getInstance();
    }

    public void get() throws Exception
    {
        try
        {
            DriverUtil.decreaseTimeout();
            isLoaded();
            DriverUtil.increaseTimeout();
        }
        catch(Exception e)
        {
            load();
            DriverUtil.increaseTimeout();
            isLoaded();
        }
    }

    public void load()
    {
    }

    public void waitForPage(WebDriverWait _wait) throws PageNotLoadedException
    {
    }

    public void isLoaded() throws Exception
    {
        try
        {
            wait = new WebDriverWait(driver, DriverUtil.timeout);
            try
            {
                waitForPage(wait);
            }
            catch (PageNotLoadedException e)
            {
                waitForPage(wait);
            }
        }
        catch (Exception ex)
        {
			throw new Exception();
		}
    }
}

