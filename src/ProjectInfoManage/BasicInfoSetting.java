package ProjectInfoManage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;

public class BasicInfoSetting {
	 @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
	  public void basicInfoSeting(String username,String password) throws Exception {
		 ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("项目信息管理")).click();
		  Actions action = new Actions(driver);//声明一个动作
	        action.doubleClick().build().perform();//双击空白
	        Thread.sleep(1000);	        
	        driver.findElement(By.xpath("(//a[contains(text(),'编辑(保存)')])[1]")).sendKeys(Keys.DOWN);  //敲击键盘，页面自动下拉到底部
		    Thread.sleep(1000);
		    
		  driver.findElement(By.linkText("编辑(保存)")).click();
		  driver.findElement(By.id("registStartTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.id("registEndTime")).sendKeys("2018-10-08");
		  driver.findElement(By.id("footerMsg")).sendKeys("中国教师教育网");
		  
		  //driver.switchTo().frame(driver.findElement(By.id("back_f")));
		  driver.switchTo().frame(driver.findElement(By.className("ke-edit-iframe")));
		  driver.findElement(By.className("ke-content")).sendKeys("这是一个最新的测试项目");
		  driver.switchTo().defaultContent();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("保存")).click();
		  driver.quit();
  }
}
