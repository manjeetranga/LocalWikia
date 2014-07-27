package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVideoPage extends Page {
	public class AddVideoUrl extends TextFieldElement
	{
		public AddVideoUrl() {
			super();
			by = By.id("wpWikiaVideoAddUrl");
		}
	}
	public class AddButton extends ButtonElement
	{
		public AddButton() {
			super();
			by = By.xpath("//div[@id='mw-content-text']/form/div/input");
		}
	}
	
	SecureHomePage parentPage;
	public AddVideoUrl addVideoUrl;
	public AddButton add;
	public AddVideoPage(SecureHomePage secureHomePage)
	{
		super();
		parentPage = secureHomePage;
		addVideoUrl = new AddVideoUrl();
		add = new AddButton();
	}

	public void load()
	{
		try {
			parentPage.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentPage.contributeMenu.addVideo.click();
	}
	
	public void waitForPage(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("wpWikiaVideoAddUrl"))));
	}
}
