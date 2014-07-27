package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import pageobjectmodel.AddVideoPage;
import pageobjectmodel.HomeWorkPage;
import pageobjectmodel.SecureHomePage;
import pageobjectmodel.VideoDetailPage;

public class TestLoginWikia 
{
	@Test
	public void TestLogin() throws Exception
	{
		HomeWorkPage homeWorkPage = new HomeWorkPage();
		SecureHomePage secureHomePage = new SecureHomePage(homeWorkPage);
		secureHomePage.get();
		assertEquals("Testwikia123", secureHomePage.loggedInUserName.actualValue());
	}
	
	@Test
	public void TestAddVideo() throws Exception
	{
		HomeWorkPage homeWorkPage = new HomeWorkPage();
		SecureHomePage secureHomePage = new SecureHomePage(homeWorkPage);
		AddVideoPage addVideoPage = new AddVideoPage(secureHomePage);
		addVideoPage.get();
		addVideoPage.addVideoUrl.setVaue("http://www.youtube.com/watch?v=h9tRIZyTXTI");
		addVideoPage.add.click();
		secureHomePage.addedLink.click();
		VideoDetailPage videoDetailPage = new VideoDetailPage(secureHomePage);
		videoDetailPage.get();
		assertEquals("The Best Classical Music In The World", videoDetailPage.videoTitle.actualValue());
	}
}
