package toolsmanage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class ToosSettiing {
	 @Test(dataProvider = "guanliyuanTestPath",dataProviderClass = DateProvider.class)
	  public void importBanJi(String username,String password,String path) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.findElement(By.linkText("教学工具配置")).click();
		  driver.findElement(By.linkText("教学计划配置")).click();
		  driver.findElement(By.name("myfile")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(path);
		  Thread.sleep(6000);
		  driver.findElement(By.className("btnlink")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(2000);
		  driver.quit();
	 }
	 }