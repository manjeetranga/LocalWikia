package com.wikia.framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.wikia.framework.pageobjectmodel.AddVideoPage;
import com.wikia.framework.pageobjectmodel.HomeWorkPage;
import com.wikia.framework.pageobjectmodel.SecureHomePage;
import com.wikia.framework.pageobjectmodel.VideoDetailPage;
import com.wikia.framework.util.DriverUtil;

public class TestLogin 
{
	@BeforeMethod
	public void SetUp()
	{
		DriverUtil.getInstance();
	}
	
	@AfterMethod
	public void TearDown()
	{
		DriverUtil.tearDown();
	}
	
	@Test
	public void TestLoginVerifyLoggedIn() throws Exception
	{
		HomeWorkPage homeWorkPage = new HomeWorkPage();
		SecureHomePage secureHomePage = new SecureHomePage(homeWorkPage);
		secureHomePage.get();
		Assert.assertEquals("Testwikia123", secureHomePage.loggedInUserName.actualValue());
	}
	
	@Test
	public void TestAddVideoVerifyAdded() throws Exception
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

