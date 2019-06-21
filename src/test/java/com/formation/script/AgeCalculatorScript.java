package com.formation.script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.formation.AgeCalculatorPage;

public class AgeCalculatorScript {
	public static void main(String[] args) {
		String chromeDriverPath = "c:/tmp/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		checkAgeCalculator();
	}

	private static void checkAgeCalculator() {
		WebDriver driver = new ChromeDriver();
		
		//instance et ouverture
		AgeCalculatorPage ageCalculatorPage = new AgeCalculatorPage(driver);
		ageCalculatorPage.open();
		
		//start test
		ageCalculatorPage.calculate("11", "February", "1983");
		
		//verify results
		if (ageCalculatorPage.getAge().equals("36")) {
			System.out.println("Age calculated with success !");
		} else {
			System.out.println("Error with age calculation !");
		}
		
		if (ageCalculatorPage.getZodiacSign().equals("Aquarius")) {
			System.out.println("Zodiac sign calculated with success !");
		} else {
			System.out.println("Error with zodiac sign claculation !");
		}
		
		ageCalculatorPage.close();
	}
}
