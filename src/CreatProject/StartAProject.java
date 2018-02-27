package CreatProject;

import java.awt.Toolkit;
import java.security.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.NewSession;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;

public class StartAProject {
	 @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
  public void startProject(String username,String password) throws Exception {
		 //System.setProperty("webdriver.chrome.driver", "/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

		 ChromeDriver driver =new ChromeDriver();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--start-fullscreen");
		 System.setProperty("webdriver.chrome.driver", "/Program Files (x86)/Google/Chrome/Application/chromedriver.exe" + "common\\browserProfiles\\drivers\\chromedriver.exe");

		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.get("http://pub.teacheredu.cn/baseplat/permission/project/project_search_view.htm");
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.cssSelector("h3.login_kxdl")).click();
		  driver.findElement(By.xpath("(//input[contains(@id,'button')])[2]")).click();
		  driver.findElement(By.name("_fm.p._0.n")).sendKeys(Uti.get_currenttime1()+"测试项目"+Uti.get_random());
		  driver.findElement(By.name("_fm.p._0.b")).sendKeys(Uti.get_random()+"");
		  new Select(driver.findElement(By.id("domainName"))).selectByVisibleText("中国教师教育网");
		  new Select(driver.findElement(By.name("_fm.p._0.t"))).selectByVisibleText("研修平台");
		  new Select(driver.findElement(By.name("_fm.p._0.is"))).selectByVisibleText("是");
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.id("endTime")).sendKeys("2018-10-02");
		  driver.findElement(By.name("_fm.p._0.n")).sendKeys("");
		  Thread.sleep(2000);
          Uti.dropDown(driver,"保存");//下拉页面到底部
		  driver.findElement(By.linkText("保存")).click();
		  driver.quit();
  }
	 
}
