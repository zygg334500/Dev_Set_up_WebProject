package rolemanage;

import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class PermissionSetting {
 
	
	  @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
	  public void setPermission(String username,String password) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("组织人员管理")).click();
		  driver.findElement(By.linkText("角色权限配置")).click();
		  driver.findElement(By.xpath("(//span[contains(text(),'管理员')])[1]")).click();  
		  Thread.sleep(2000);
		  Uti.checkAllPermission(driver,"admin");
		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);	  
		  driver.findElement(By.xpath("(//span[contains(text(),'专家')])[1]")).click();
		  Thread.sleep(2000);
		  Uti.checkAllPermission(driver,"export");
		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[contains(text(),'辅导者')])[1]")).click();
		  Thread.sleep(2000);
		  Uti.checkAllPermission(driver,"teacher");
		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[contains(text(),'学员')])[1]")).click();
		  Thread.sleep(2000);
		  Uti.checkAllPermission(driver,"student");
		  driver.findElement(By.linkText("保存")).click();
		  driver.quit();
	  }
}