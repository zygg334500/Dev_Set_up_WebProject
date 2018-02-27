package toolsmanage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class AddAnnouncement {
	 @Test(dataProvider = "guanliyuanTestPath",dataProviderClass = DateProvider.class)
	  public void importBanJi(String username,String password,String path) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.findElement(By.linkText("教学工具配置")).click();
          driver.findElement(By.xpath("(//a[contains(text(),'复用')])[4]")).click();
          driver.findElement(By.xpath("(//input[@value='文章' and @name='platformTitle'])[2]")).clear();
          driver.findElement(By.xpath("(//input[@value='文章' and @name='platformTitle'])[2]")).sendKeys("公告");
          driver.findElement(By.linkText("确定")).click();
          Thread.sleep(10000);
          driver.findElement(By.linkText("退出")).click();
          driver.quit();
	 }
	 }