package com.georgit.fmi.st.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbvHomePage {

	@FindBy(id = "hplogo")
	WebElement logoDiv;

	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "submit")
	WebElement loginButton;
	
	@FindBy(css = "#tsf > "
			+ "div:nth-child(2) > "
			+ "div.A8SBwf > div.RNNXgb > "
			+ "div > div.a4bIc > input")
	WebElement searchInput;
	
	@FindBy(css = "#tsf > "
			+ "div:nth-child(2) >"
			+ "div.A8SBwf.emcav > "
			+ "div.UUbT9 > div.aajZCb > "
			+ "div.tfB0Bf > center > input.gNO89b")
	WebElement searchButton;

	public boolean isLogoExists() {
		return null != logoDiv;
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void addSearchValue(final String searchValue) {
		searchInput.sendKeys(searchValue);
	}
}