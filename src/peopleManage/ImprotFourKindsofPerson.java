package peopleManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
//导入学员

public class ImprotFourKindsofPerson {
  
	  @Test(dataProvider = "guanliyuanImportPersons",dataProviderClass = DateProvider.class)
	  public void importpersons(String username,String password,String student,String teacher,String export,String admin) throws Exception {
		  ChromeDriver driver =new ChromeDriver();
		  Uti.ChromeBrowser_setup(driver, username, password);
		  Uti.ChangeWindows(driver, 1);
		  WebElement ss = driver.findElement(By.linkText("组织人员管理"));
          Uti.stayMouse(ss, driver);
		  driver.findElement(By.linkText("人员管理")).click();
		  driver.findElement(By.linkText("用户管理")).click();
		  driver.findElement(By.id("dict_file_1")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(student);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[1]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_4")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(teacher);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[2]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[2]")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_2")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(export);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[3]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[3]")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_3")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(admin);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[4]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[4]")).click();	
//          Uti.UploadFile(driver, teacher, "dict_file_4");
//          Thread.sleep(2000);
//          driver.findElement(By.xpath("(//input[@id='submit'])[2]")).click();
//          Thread.sleep(2000);
//		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
//		  Thread.sleep(1000);
//          Uti.UploadFile(driver, export, "dict_file_2");
//          Thread.sleep(2000);
//          driver.findElement(By.xpath("(//input[@id='submit'])[3]")).click();
//          Thread.sleep(2000);
//		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
//		  Thread.sleep(1000);
//          Uti.UploadFile(driver, admin, "dict_file_3");
//          Thread.sleep(2000);
//          driver.findElement(By.xpath("(//input[@id='submit'])[4]")).click();
//          Thread.sleep(2000);
//		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
	      Thread.sleep(1000);
          driver.quit();
	  
  }
}
