package ProjectInfoManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class OtherSetting {
	 @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
	  public void otherSeting(String username,String password) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  WebElement info = driver.findElement(By.linkText("项目信息管理"));
		  Uti.stayMouse(info, driver);
		  driver.findElement(By.linkText("其他功能配置")).click();
		  driver.findElement(By.id("frequency_btn")).click();
		  Uti.waitForAlertAndCloseAlert(driver);
		  driver.quit();
 }
}