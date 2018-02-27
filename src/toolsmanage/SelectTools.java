package toolsmanage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class SelectTools {

		  @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
		  public void selectTools(String username,String password) throws Exception {
			  ChromeDriver driver =new ChromeDriver();
			  Uti.ChromeBrowser_setup(driver, username, password);
			  Uti.ChangeWindows(driver, 1);
			  driver.findElement(By.linkText("教学工具管理")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("教学工具选择")).click();
			  //driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
			  //driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
			  driver.findElement(By.xpath("(//input[@type='checkbox'])[14]")).click();

			  driver.findElement(By.linkText("确定")).click();
			  driver.quit();
			  //driver.findElement(By.xpath("(//a[contains(text(),'配置')])[1]")).click();

		  }
		}