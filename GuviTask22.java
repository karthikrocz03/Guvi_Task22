package guvitask18;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GuviTask22 {
	@Test
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver;
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	//Provide the input 
	driver.get("https://phptravels.com/demo/");
	driver.findElement(By.name("first_name")).sendKeys("Karthik");
	driver.findElement(By.name("last_name")).sendKeys("Easwaran");
	driver.findElement(By.name("business_name")).sendKeys("Ktronics");
	driver.findElement(By.name("email")).sendKeys("karthikrocz03@gmail.com");
	//logic for the captcha
	WebElement num1 = driver.findElement(By.xpath("//span[@id='numb1']"));
	WebElement num2 = driver.findElement(By.xpath("//span[@id='numb2']"));

	
	int number1 = Integer.parseInt(num1.getText());
	int number2 = Integer.parseInt(num2.getText());
	
	System.out.println(number1 + "+" + number2 + "=" + (number1 + number2));
	int result = number1+number2;
	driver.findElement(By.xpath("//input[@id='number']")).sendKeys(Integer.toString(result));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='demo']")).click();
	//Verification
	WebElement resu = driver.findElement(By.xpath("//h2[@class='text-start fs-4']"));
	String re = resu.getText();
	if(re.contains("Instant demo request form")) {
		System.out.println("Verified");
	}
	Thread.sleep(4000);
	TakesScreenshot sc = (TakesScreenshot) driver; 
	File file = sc.getScreenshotAs(OutputType.FILE);
	File destination = new File("C:\\Users\\ke33284\\OneDrive - Brightstar, Corp\\Desktop\\Automation directory\\SeleniumLearning\\Screenshots\\Screenshot1.png");
    FileUtils.copyFile(file, destination);
    driver.close();
	
	
	

	
}
}
