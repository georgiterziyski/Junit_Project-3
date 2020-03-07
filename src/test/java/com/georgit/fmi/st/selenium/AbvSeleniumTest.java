package com.georgit.fmi.st.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class AbvSeleniumTest {
	private static WebDriver driver;
	private AbvHomePage homePage;

	@BeforeClass
	public static void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "WebDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,
				TimeUnit.SECONDS);
	}

	@Before
	public void setup() {
		driver.get("https://www.google.com/");
		homePage = new AbvHomePage();
		PageFactory.initElements(driver, homePage);
	}

	@Test
	public void testMainContent() {
		assertTrue(homePage.isLogoExists());
		
	}
	
	@Test
	public void testSearchGmail() throws InterruptedException {
		homePage.addSearchValue("gmail");
		homePage.clickSearchButton();
		WebElement result = 
				driver.findElement(By.cssSelector("#rhs >"
						+ " div > div.kp-blk.EyBRub.knowledge-panel.Wnoohf.OJXvsb >"
						+ " div.xpdopen > div.ifM9O > div > div.kp-header > "
						+ "div:nth-child(2) > div.kp-hc > div > div > "
						+ "div.SPZz6b > div > span"));
		assertNotNull(result);
		assertEquals("Gmail", result.getText());
	}
	
	@Test
	public void testSearchYahoo() throws InterruptedException {
		homePage.addSearchValue("yahoo");
		homePage.clickSearchButton();
		//Thread.sleep(40000);
		WebElement result = 
				driver.findElement(By.cssSelector("#rso >"
						+ " div:nth-child(1) > "
						+ "div > div > div > div > "
						+ "div.r > a > h3"));		
		assertNotNull(result);
		assertEquals("Yahoo", result.getText());
	}
	
	@Test
	public void testSearchYouTube() throws InterruptedException {
		homePage.addSearchValue("youtube");
		homePage.clickSearchButton();
		//Thread.sleep(40000);
		WebElement result = 
				driver.findElement(By.cssSelector("#rso >"
						+ " div:nth-child(1) > div > "
						+ "div > div > div > div.r > a > h3"));		
		assertNotNull(result);
		assertEquals("YouTube", result.getText());
	}
	
	@Test
	public void testInvalidSearch() throws InterruptedException {
		homePage.addSearchValue("jsjd334rj");
		WebElement search = 
		driver.findElement(By.cssSelector("#tsf > "
				+ "div:nth-child(2) > div.A8SBwf > "
				+ "div.FPdoLc.tfB0Bf > center > input.gNO89b"));	
		search.click();
		WebElement result = 
				driver.findElement(By.cssSelector("#topstuff > div > div > p:nth-child(2)"));		
		assertNotNull(result);
		assertEquals("Предложения:", result.getText());
	}
	
	@AfterClass
	public static void stopDriver() {
		driver.close();
	}
}
