package Set_up_project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class ClassManage {
	  @Test(dataProvider = "guanliyuanBanjiPath",dataProviderClass = DateProvider.class)
	  public void importBanJi(String username,String password,String path) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("数据字典与班级管理")).click();
		  driver.findElement(By.linkText("班级管理")).click();
		  driver.findElement(By.linkText("添加班级")).click();
		  driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		  //driver.findElement(By.xpath("(//a[contains(text(),'配置')])[1]")).click();
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