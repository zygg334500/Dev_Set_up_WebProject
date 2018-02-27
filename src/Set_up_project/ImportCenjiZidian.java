package Set_up_project;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DateProvider.DateProvider;

import uti.Uti;

public class ImportCenjiZidian {
  
  @Test(dataProvider = "guanliyuanCenjiPath",dataProviderClass = DateProvider.class)
  public void importcenji(String username,String password,String path) throws Exception {
	  ChromeDriver driver =new ChromeDriver();
	  Uti.ChromeBrowser_setup(driver, username, password);
	  Uti.ChangeWindows(driver, 1);
	  driver.findElement(By.linkText("数据字典与班级管理")).click();
	  driver.findElement(By.linkText("层级管理")).click();
	  driver.findElement(By.linkText("导入层级信息")).click();
	  driver.findElement(By.name("myfile")).click();
	  Thread.sleep(2000);
	  Runtime.getRuntime().exec(path);
	  Thread.sleep(6000);
	  driver.findElement(By.className("btnlink")).click();
	  driver.findElement(By.linkText("确定")).click();
	  Thread.sleep(3000);
	  driver.quit();
  }
}
