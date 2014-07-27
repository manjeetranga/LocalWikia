package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureHomePage extends Page
{
	public class UserNameTextElement extends TextElement
	{
		public UserNameTextElement() {
			super();
			by = By.xpath("//ul[@id='AccountNavigation']/li/a");
		}
	}
	
	public class SuccessText extends TextElement
	{
		public SuccessText() {
			super();
			by = By.xpath("//div[@class='msg']");
		}
	}
	
	public class AddedLink extends LinkElement
	{
		public AddedLink() {
			super();
			by = By.xpath("//div[@class='msg']/a");
		}
	}
	
    public class ContributeMenuItem extends PageElement
    {
    	By menuItem;
        public ContributeMenuItem(String text)
        {
        	super();
            by = By.xpath("//img[contains(@class,'contribute')]");
            menuItem = By.linkText(text);
        }
    	public void click()
    	{
    		getElement().click();
    		try
    		{
            	driver.findElement(menuItem).click();
    		}
    		catch(Exception ex)
    		{
    			driver.findElement(by).click();
            	driver.findElement(menuItem).click();
    		}
    	}
    }
    
    public class ContributeMenu
    {
        public ContributeMenuItem editThisPage;
        public ContributeMenuItem addVideo;
        public ContributeMenuItem addPhoto;
        public ContributeMenuItem AddPage;
        public ContributeMenu()
        {
        	editThisPage = new ContributeMenuItem("Edit this Page");
        	addVideo = new ContributeMenuItem("Add a Video");
        	addPhoto = new ContributeMenuItem("Add a Photo");
        	AddPage = new ContributeMenuItem("Add a Page");
        }
    }	
	
	HomeWorkPage parentPage;
	public UserNameTextElement loggedInUserName;
	public ContributeMenu contributeMenu;
	public SuccessText successText;
	public AddedLink addedLink;
	
	public SecureHomePage(Object parentPage) 
	{
		super();
		loggedInUserName = new UserNameTextElement();
		contributeMenu = new ContributeMenu();
		successText = new SuccessText();
		addedLink = new AddedLink();
		this.parentPage = (HomeWorkPage) parentPage;
	}

	public void load()
	{
		try {
			parentPage.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentPage.loginMenuButton.click();
		parentPage.signIn();
	}
	
	public void waitForPage(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Photos']"))));
	}
}

//class SecureHomePageFromAddVideoPage extends SecureHomePage
//{
//
//	public SecureHomePageFromAddVideoPage(Object parentPage) {
//		super(parentPage);
//	}
//
//	public void load()
//	{
//		try {
//			parentPage.get();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		parentPage.addVideoUrl.setVaue("http://www.youtube.com/watch?v=h9tRIZyTXTI");
//		parentPage.signIn();
//	}
//}
