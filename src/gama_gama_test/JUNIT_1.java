package gama_gama_test;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.PrinterInfo;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.GoForward;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




















import com.codeborne.selenide.Selenide;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.google.common.base.Verify;
import com.thoughtworks.selenium.webdriven.commands.Click;
import com.thoughtworks.selenium.webdriven.commands.Close;
import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;
import com.thoughtworks.selenium.webdriven.commands.SelectWindow;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;



public class JUNIT_1 {
	WebDriver driver = new FirefoxDriver();
	 
	@Before
	  public void setUp() throws Exception {
			    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  }  		
	
	
	@Test
	public void RightLoginAndFalsePass() throws InterruptedException {
		//введен правильный логин, введен НЕправильный пароль
		driver.get("http:/gama-gama.ru");
		driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
		Thread.sleep(1000);
		
		
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_login")).sendKeys("dollar_ego2@mail.ru");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_pass")).sendKeys("ljkkfh");
		
		driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
		Thread.sleep(500);
		assertTrue(driver.getPageSource().contains("Необходимо авторизоваться"));

		driver.close();
		
		
	}
	@Test
	public void NoLoginAndNoPass() throws InterruptedException {
		//не введен логин и не введен пароль
		//driver.get("http:/gama-gama.ru");
		driver.navigate().to("http:/gama-gama.ru");
		driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
		assertTrue(driver.getPageSource().contains("Введите E-mail, на который вы регистрировались"));
		
		
	}
	@Test
	public void EnterLoginAndNoPass() throws InterruptedException {
		//введен логин и не введен пароль
				driver.get("http:/gama-gama.ru");
				driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
				Thread.sleep(1000);
				
				driver.findElement(By.name("Email")).clear();
				driver.findElement(By.cssSelector("form input.auth_form_login")).sendKeys("dollar_ego2@mail.ru");
				
				driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
				assertTrue(driver.getPageSource().contains("Введите ваш пароль"));
				
	}
	@Test
	public void NoLoginAndEnterPass() throws InterruptedException {
		//не введен логин, но введен пароль
		driver.get("http:/gama-gama.ru");
		driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
		Thread.sleep(1000);
		
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_pass")).sendKeys("ljkkfh_tuj");
		
		driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
		assertTrue(driver.getPageSource().contains("Введите E-mail, на который вы регистрировались"));
		
		
	}
	@Test
	public void FalseLoginAndEnterPass() throws InterruptedException {
		//введен неправильный логин, введен пароль
		driver.get("http:/gama-gama.ru");
		driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
		Thread.sleep(1000);
		
		
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_login")).sendKeys("dollar111");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_pass")).sendKeys("ljkkfh_tuj");
		
		driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
		assertTrue(driver.getPageSource().contains("Такого пользователя не существует."));
		
		
	}
	
	@Test
	public void RightLoginAndRightPass() throws InterruptedException {
		//введен правильный логин и пароль
		driver.get("http:/gama-gama.ru");
		driver.navigate().to("javascript:GamaGama.UI.showAuthForm();");
		Thread.sleep(1000);
		
		driver.findElement(By.name("Email")).clear();
		//driver.findElement(By.name("Email")).sendKeys("dollar_ego2");
		driver.findElement(By.cssSelector("form input.auth_form_login")).sendKeys("dollar_ego2@mail.ru");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.cssSelector("form input.auth_form_pass")).sendKeys("ljkkfh_tuj");
		
		driver.findElement(By.cssSelector("form button.btn-small.btn-blue.auth_submit-block.js-login")).click();
		
		//assertTrue(driver.getPageSource().contains("Личный кабинет"));
		//тут может начать ругаться на капчу
		driver.navigate().to("http://gama-gama.ru/personal/settings/");	 		 		
		driver.navigate().to("http://gama-gama.ru/#");
	
	}
	
	
	
	
}

