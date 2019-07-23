package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AndroidDemoTest4 extends BaseTest {
	protected AndroidDriver<AndroidElement> driver = null;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank/.LoginActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
		dc.setCapability("testName", "AndroidDemoTest");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
		Thread.sleep(3000);
	}
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void test1(){
		driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@text='Login']")).click();
		driver.findElement(By.xpath("//*[@text='Make Payment']"));
	}
	@Test
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
