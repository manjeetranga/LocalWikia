package com.wikia.framework.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkPage extends Page
{
	class LoginMenuButton extends ButtonElement
	{
		public LoginMenuButton() {
			super();
			by = By.xpath("//a[text()='Log in']/img");
		}
	}
	class UserName extends TextFieldElement
	{
		public UserName() {
			super();
			by = By.name("username");
		}
	}
	class Password extends TextFieldElement
	{
		public Password() {
			super();
			by = By.name("password");
		}
	}
	class LoginButton extends ButtonElement
	{
		public LoginButton() {
			super();
			by = By.xpath("//input[@value='Log in']");
		}
	}
	
	LoginButton loginButton;
	UserName userName;
	Password password;
	LoginMenuButton loginMenuButton;
	public HomeWorkPage()
	{
		super();
		loginMenuButton = new LoginMenuButton();
		userName = new UserName();
		password = new Password();
		loginButton = new LoginButton();
	}
	
	public void load()
	{
		driver.get("http://testhomework.wikia.com/");
	}
	
	public void waitForPage(WebDriverWait wait)
	{
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Photos']"))));
	}
	
	public void signIn()
	{
		userName.setVaue("Testwikia123");
		password.setVaue("Testwikia@123");
		loginButton.click();
	}
}
