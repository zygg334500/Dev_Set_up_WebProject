package rolemanage;
//未完待续
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class RequiredFildSeting {
	
		  @Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
		  public void importBanJi(String username,String password) throws Exception {
			  ChromeDriver driver =new ChromeDriver();
			  Uti.ChromeBrowser_setup(driver, username, password);
			  Uti.ChangeWindows(driver, 1);
			  driver.findElement(By.linkText("组织人员管理")).click();
			  driver.findElement(By.linkText("必填字段配置")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='realName']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='idcard']")).click();
			  driver.findElement(By.linkText("确定")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//a[@value='1' and @class='btn']")).click();	
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//input[@name='roleid' and @value='2']")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='realName']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='idcard']")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.linkText("确定")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[2]")).click();
			  //driver.findElement(By.xpath("(//a[contains(text(),'配置')])[1]")).click();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//input[@name='roleid' and @value='3']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='realName']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='idcard']")).click();
			  driver.findElement(By.linkText("确定")).click();
			  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[3]")).click();
			  driver.findElement(By.xpath("//input[@name='roleid' and @value='4']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='realName']")).click();
			  driver.findElement(By.xpath("//input[@type='checkbox' and @value='idcard']")).click();
			  driver.findElement(By.linkText("确定")).click();
			  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[4]")).click();
			  driver.quit();
		  }
}
