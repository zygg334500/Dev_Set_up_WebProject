package RegistrationCardManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;

public class CreatCard {
	
	
	@Test(dataProvider = "guanliyuan",dataProviderClass = DateProvider.class)
    public void creatCards(String username,String password) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  WebElement ss = driver.findElement(By.linkText("组织人员管理"));
          Uti.stayMouse(ss, driver);
		  driver.findElement(By.linkText("注册卡管理")).click();
		  driver.findElement(By.linkText("注册卡管理")).click();
		  //生成管理员注册卡
		  driver.findElement(By.linkText("生成注册卡")).click();
		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("管理员");
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
		  driver.findElement(By.name("num")).sendKeys("2");
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(2000);
		  //生成专家注册卡
		  driver.findElement(By.linkText("生成注册卡")).click();
		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("专家");
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("语文");//选择学科
		  driver.findElement(By.name("num")).sendKeys("1");
		  driver.findElement(By.linkText("确定")).click();
		  driver.findElement(By.linkText("生成注册卡")).click();
		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("专家");
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("数学");//选择学科
		  driver.findElement(By.name("num")).sendKeys("1");
		  driver.findElement(By.linkText("确定")).click();
		  //生成辅导老师的注册卡
		  driver.findElement(By.linkText("批量生成注册卡")).click();
		  driver.findElement(By.xpath("(//input[@type='radio'])[4]")).click();

		  driver.findElement(By.linkText("确定")).click();
		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
		  Thread.sleep(2000);
		  //生成数学学员注册卡
		  driver.findElement(By.linkText("生成注册卡")).click();
		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("学员");		
		  driver.findElement(By.name("hasclass")).click();
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("数学");//选择学科
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
		  Thread.sleep(2000);
		  driver.findElement(By.name("num")).sendKeys("2");
		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[2]"))).selectByVisibleText("惠州市");//选择学科
		  Thread.sleep(2000);
		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[3]"))).selectByVisibleText("惠州市第八中学");//选择学科
		  driver.findElement(By.name("classid")).click();
		  driver.findElement(By.linkText("确定")).click();
		  //生成语文学员注册卡
		  driver.findElement(By.linkText("生成注册卡")).click();
		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("学员");		
		  driver.findElement(By.name("hasclass")).click();
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("语文");//选择学科
		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
		  //new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.className( "dicttype_select" )));
		  Thread.sleep(2000);
		  driver.findElement(By.name("num")).sendKeys("2");
		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[2]"))).selectByVisibleText("惠州市");//选择学科
		  Thread.sleep(2000);
		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[3]"))).selectByVisibleText("惠州市第八中学");//选择学科
		  driver.findElement(By.name("classid")).click();
		  driver.findElement(By.linkText("确定")).click();
		  driver.quit();
	}
}
