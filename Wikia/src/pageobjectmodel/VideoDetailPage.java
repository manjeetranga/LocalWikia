package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoDetailPage extends Page{
	
	public class VideoTitle extends TextElement
	{
		public VideoTitle() {
			super();
			by = By.xpath("//header[@id='WikiaPageHeader']/h1");
		}
	}
	public VideoTitle videoTitle;
	SecureHomePage parentPage;
	public VideoDetailPage(SecureHomePage secureHomePage)
	{
		super();
		videoTitle = new VideoTitle();
		parentPage = secureHomePage;
	}
	public void load()
	{
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentPage.addedLink.click();
	}
	
	public void waitForPage(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//header[@id='WikiaPageHeader']/h1"))));
	}
}
