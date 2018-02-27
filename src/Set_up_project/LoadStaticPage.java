package Set_up_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
//生成静态页
public class LoadStaticPage {
	@Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
    public void loadStaticPage(String username,String password) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  WebElement ss = driver.findElement(By.linkText("主页定制和发布"));
          Uti.stayMouse(ss, driver);
		  driver.findElement(By.linkText("主页定制")).click();
		  WebElement ss2 = driver.findElement(By.className("imgtitle"));
          Uti.stayMouse(ss2, driver);
		  driver.findElement(By.linkText("编辑模板")).click();
		  Thread.sleep(3000);
//		  driver.findElement(By.linkText("启用统计表格")).click();
//		  driver.findElement(By.id("nav_edit")).click();
//		  driver.findElement(By.id("nav_edit_col")).sendKeys("项目")
		  WebElement ss4 = driver.findElement(By.cssSelector("#cont > div.main_cont.clear > div.main.fl"));
          Uti.stayMouse(ss4, driver);
          driver.findElement(By.id("xm_edit")).click();
          driver.findElement(By.name("otool_checkbox")).click();
          driver.findElement(By.linkText("确定")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();
          Thread.sleep(3000);
		  WebElement ss3 = driver.findElement(By.linkText("主页定制和发布"));
          Uti.stayMouse(ss3, driver);
		  driver.findElement(By.linkText("静态页生成")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[contains(text(),'测试项目')]")).click();
		  
	}
}