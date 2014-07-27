package pageobjectmodel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.util.DriverUtil;


class BaseElement extends Object
{
	WebDriver driver;
	public BaseElement() {
		driver = DriverUtil.getInstance();
	}
}
class PageElement extends BaseElement
{
	Object expectedValue;
	By by;
	public PageElement() {
		super();
		expectedValue = null;
	}
	
	public boolean exists()
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean exist = false;
		try
		{
			exist = driver.findElements(by).size() != 0;
		}
		finally
		{
			DriverUtil.resetTimeOut(5);
		}
		return exist;
	}
	
	public boolean isDisplayed()
	{
		return getElement().isDisplayed();
	}
	
	public WebElement getElement()
	{
		return driver.findElement(by);
	}
}

class TextElement extends PageElement
{
	public TextElement()
	{
		super();
	}
	
	public String actualValue()
	{
		return getElement().getText();
	}
}

class TextFieldElement extends PageElement
{
	public TextFieldElement()
	{
		super();
	}
	
	public String actualValue()
	{
		return getElement().getAttribute("value");
	}
	
	public void setVaue(String value)
	{
		WebElement element = getElement();
		element.sendKeys(value);
		expectedValue = value;
	}
	
	public void clear()
	{
		getElement().clear();
	}
}

class ButtonElement extends PageElement
{
	public ButtonElement()
	{
		super();
	}
	
	public void click()
	{
		getElement().click();
	}
}

class LinkElement extends TextElement
{
    public LinkElement(){super();}

    public void click()
    {
        getElement().click();
    }
}
class MenuItemElement extends PageElement
{
	By menuItemLocator;
	public MenuItemElement(By by, By menuItemLocator)
	{
		super();
		this.menuItemLocator = menuItemLocator;
	}
	
	public void click()
	{
		getElement().click();
		try
		{
			driver.findElement(menuItemLocator).click();
		}
		catch(Exception ex)
		{
			driver.findElement(by).click();
			driver.findElement(menuItemLocator).click();
		}
	}
}