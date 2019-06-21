package com.formation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgeCalculatorPage {
	private WebElement dayOfBirth = null;
	private WebElement monthOfBirth = null;
	private WebElement yearOfBirth = null;
	private WebElement age = null;
	private WebElement zodiacSign = null;
	private WebElement calculate = null;
	
	private WebDriver driver;
	
	Path sampleFile = Paths.get("pages/exercise_6_1.html");
	
	private String url = sampleFile.toUri().toString();
	
	//class constructor
	public AgeCalculatorPage(WebDriver webDriver) {
		driver = webDriver;
	}
	
	// methods to open an close the driver
	public void open() {
		this.driver.get(url);
	}
	
	public void close() {
		this.driver.quit();
	}
	
	public void calculate(String day, String month, String year) {
		getDayOfBirth().sendKeys(day);
		getMonthOfBirth().sendKeys(month);
		getYearOfBirth().sendKeys(year);
		getCalculate().click();
	}
	
	public String getAge() {
		age = driver.findElement(By.id("age"));
		return age.getText();
	}
	
	public String getZodiacSign() {
		zodiacSign = driver.findElement(By.id("zodiacSign"));
		return zodiacSign.getText();
	}

	private WebElement getCalculate() {
		calculate = driver.findElement(By.id("calculate"));
		return calculate;
	}

	private WebElement getYearOfBirth() {
		yearOfBirth = driver.findElement(By.id("yearOfBirth"));
		return yearOfBirth;
	}

	private WebElement getMonthOfBirth() {
		monthOfBirth = driver.findElement(By.id("monthOfBirth"));
		return monthOfBirth;
	}

	private WebElement getDayOfBirth() {
		dayOfBirth = driver.findElement(By.id("dayOfBirth"));
		return dayOfBirth;
	}

}
