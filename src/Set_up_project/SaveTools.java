package Set_up_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class SaveTools {
	 @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
	  public void theEndSave(String username,String password) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.findElement(By.linkText("教学工具配置")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(7000);
		  driver.quit();
}
}