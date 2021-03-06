package tests;

//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import framework.util.DriverUtil;
import pageobjectmodel.AddVideoPage;
import pageobjectmodel.HomeWorkPage;
import pageobjectmodel.SecureHomePage;
import pageobjectmodel.VideoDetailPage;

public class TestLoginWikia 
{
	@Before
	public void SetUp()
	{
		DriverUtil.getInstance();
	}
	
	@After
	public void TearDown()
	{
		DriverUtil.tearDown();
	}
	
	@Test
	public void TestLogin() throws Exception
	{
		HomeWorkPage homeWorkPage = new HomeWorkPage();
		SecureHomePage secureHomePage = new SecureHomePage(homeWorkPage);
		secureHomePage.get();
		Assert.assertEquals("Testwikia123", secureHomePage.loggedInUserName.actualValue());
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
		Assert.assertEquals("The Best Classical Music In The World", videoDetailPage.videoTitle.actualValue());
	}
}
