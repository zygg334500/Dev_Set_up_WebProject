package com.compelteAllStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import uti.Uti;
import DateProvider.DateProvider;

public class SetUpACompleteProject {
	 @Test(dataProvider = "guanliyuana",dataProviderClass = DateProvider.class)
  public void startProject(String superadmin,String superpassword,String username,String password,String BackgroundUrl,String IsStageOrNot) throws Exception {
		//建一个项目
		 ChromeDriver driver =new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver", "C:/Users/gg/AppData/Local/Google/Chrome/Application/chromedriver.exe");
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.get(BackgroundUrl);
		 driver.findElement(By.id("username")).sendKeys(superadmin);
		 driver.findElement(By.id("password")).sendKeys(superpassword);
		 driver.findElement(By.cssSelector("h3.login_kxdl")).click();
		  driver.findElement(By.xpath("(//input[contains(@id,'button')])[2]")).click();
		  if(IsStageOrNot.indexOf("yes")!=-1 ){
			   driver.findElement(By.name("_fm.p._0.n")).sendKeys(Uti.get_currenttime1()+"分阶段kend测试项目"+Uti.get_random());
		  }else{
			   driver.findElement(By.name("_fm.p._0.n")).sendKeys(Uti.get_currenttime1()+"测试kend项目"+Uti.get_random());
			   new Select(driver.findElement(By.name("_fm.p._0.t"))).selectByVisibleText("研修平台");
		  }	  		  
		  driver.findElement(By.name("_fm.p._0.b")).sendKeys(Uti.get_random()+"");
		  new Select(driver.findElement(By.id("domainName"))).selectByVisibleText("中国教师教育网");
		  Thread.sleep(1000);
		  new Select(driver.findElement(By.name("_fm.p._0.ist"))).selectByVisibleText("是");
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.id("endTime")).sendKeys("2018-10-02");
		  Thread.sleep(2000);
		  driver.findElement(By.name("_fm.p._0.c")).click();
		  driver.findElement(By.name("_fm.p._0.c")).click();
		  Thread.sleep(2000);
		  //driver.findElement(By.xpath("(//input[contains(@value,'2301523')])")).click();
		  if(BackgroundUrl.indexOf("pub") > 0 ){
			  driver.findElement(By.xpath("(//input[contains(@value,'2301523')])")).sendKeys(Keys.SPACE);
		  }else{
			  driver.findElement(By.xpath("(//input[contains(@value,'1749767')])")).sendKeys(Keys.SPACE);	
		  }
          //Uti.dropDown(driver,"保存");
		   driver.findElement(By.linkText("保存")).click();
		  driver.findElement(By.linkText("退出")).click();
		  Thread.sleep(2000);
		  //driver.quit();

		  
		  //项目基本信息设置
		  driver.get(BackgroundUrl);
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys(username);
		  driver.findElement(By.id("password")).clear();
		  driver.findElement(By.id("password")).sendKeys(password);
		  driver.findElement(By.cssSelector("h3.login_kxdl")).click();
		  driver.findElement(By.linkText("项目管理")).click();
		  driver.findElement(By.xpath("(//a[contains(text(),'配置')])[1]")).click();
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("项目信息管理")).click();
          Uti.dropDown(driver,"编辑(保存)");
		  driver.findElement(By.linkText("编辑(保存)")).click();
		  driver.findElement(By.id("registStartTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.id("registEndTime")).sendKeys("2018-10-08");
		  if(IsStageOrNot.indexOf("yes")!=-1 ){
		  Thread.sleep(1000);
		  driver.findElement(By.id("jxgjkqfs")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("jdjsfswxjs")).click();
		  Thread.sleep(1000);	    
		  }else{
          Thread.sleep(1000);	 
		  }	  		  
		  driver.findElement(By.id("footerMsg")).sendKeys("中国教师教育网");
		  Uti.richText(driver, 1, "这是一个最新的测试项目");
		  
//		  driver.switchTo().frame(driver.findElement(By.className("ke-edit-iframe")));
//		  driver.findElement(By.className("ke-content")).sendKeys("这是一个最新的测试项目");
//		  driver.switchTo().defaultContent();
		  
		  Thread.sleep(2000);	    
          Uti.dropDown(driver,"保存");
		  driver.findElement(By.linkText("保存")).click();
		  //driver.quit();
		  
		  //项目其他信息设置
		  WebElement info = driver.findElement(By.linkText("项目信息管理"));
		  Uti.stayMouse(info, driver);
		  driver.findElement(By.linkText("其他功能配置")).click();
		  driver.findElement(By.id("frequency_btn")).click();
		  Uti.waitForAlertAndCloseAlert(driver);
		  //driver.quit();
		  
		//导入层级字典
		  driver.findElement(By.linkText("数据字典与班级管理")).click();
		  driver.findElement(By.linkText("层级管理")).click();
		  driver.findElement(By.linkText("导入层级信息")).click();
		  driver.findElement(By.name("myfile")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.cenji);
		  Thread.sleep(6000);
		  driver.findElement(By.className("btnlink")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(4000);
		  try {
			  driver.findElement(By.className("close")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(1000);
		  //driver.quit();
		  
		  //导入学科字典
		  driver.findElement(By.linkText("数据字典与班级管理")).click();
		  driver.findElement(By.linkText("学科管理")).click();
		  driver.findElement(By.linkText("导入学科信息")).click();
		  driver.findElement(By.name("myfile")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.xueke);
		  Thread.sleep(6000);
		  driver.findElement(By.className("btnlink")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(3000);
		  try {
			  driver.findElement(By.className("close")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(1000);
		  //driver.quit();
		  
		  //导入班级
		  driver.findElement(By.linkText("数据字典与班级管理")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("班级管理")).click();
		  driver.findElement(By.linkText("添加班级")).click();
		  driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		  driver.findElement(By.name("myfile")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.banji);
		  Thread.sleep(6000);
		  driver.findElement(By.className("btnlink")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(4000);
		  try {
			  driver.findElement(By.className("close")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(1000);
		  //driver.quit();
		  
		  //选择教学工具
		  driver.findElement(By.linkText("教学工具管理")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("教学工具选择")).click();
		  try {
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		  //driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[14]")).click();
		  driver.findElement(By.xpath("(//input[@type='checkbox'])[15]")).click();
		  if(IsStageOrNot.indexOf("yes")!=-1 ){
		  }else{
          //driver.findElement(By.xpath("(//input[@type='checkbox'])[14]")).click();	 
		  }	  
		  } catch (Exception e) {
			  System.out.println("资源工具没有选择全");
			  //如果选择工具的时候有问题，就抛掉
				// TODO: handle exception
			}
		  
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(1000);
		  driver.navigate().refresh();
		  driver.navigate().refresh();
		  //driver.quit();
		  if(IsStageOrNot.indexOf("yes")!=-1 ){
	  		  //教学工具选择配置
		  driver.findElement(By.linkText("教学工具管理")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("研修阶段配置")).click();
		  Thread.sleep(5000);
		  driver.navigate().refresh();
		  Thread.sleep(1000);
		  driver.findElement(By.linkText("添加研修阶段")).click();
		  driver.navigate().refresh();
		  Thread.sleep(1000);
		  driver.findElement(By.name("jdmc")).sendKeys("阶段一");
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[1]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[2]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[3]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[4]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[8]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[9]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[10]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[11]")).click();

          Thread.sleep(1000);
          driver.findElement(By.xpath("(//a[contains(text(),'确定')])[1]")).click();
          Thread.sleep(1000);
          driver.findElement(By.name("jdzn")).sendKeys("阶段一的简单介绍");
          driver.switchTo().frame(0);
          driver.findElement(By.className("ke-content")).sendKeys("阶段一的具体内容");
          driver.switchTo().defaultContent();
          Uti.dropDown(driver, "确定");
          driver.findElement(By.xpath("(//a[contains(text(),'确定')])[2]")).click();
          driver.findElement(By.linkText("继续添加阶段")).click();
          
    	  Thread.sleep(1000);
		  driver.findElement(By.name("jdmc")).sendKeys("阶段二");
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[1]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[2]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[3]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[4]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[8]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[9]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[10]")).click();
		  driver.findElement(By.xpath("(//input[@name='toolcb'])[11]")).click();

          Thread.sleep(1000);
          driver.findElement(By.xpath("(//a[contains(text(),'确定')])[1]")).click();
          Thread.sleep(1000);
          driver.findElement(By.name("jdzn")).sendKeys("阶段二的简单介绍");
          driver.switchTo().frame(0);
          driver.findElement(By.className("ke-content")).sendKeys("阶段二的具体内容");
          driver.switchTo().defaultContent();
          Uti.dropDown(driver, "确定");
          driver.findElement(By.xpath("(//a[contains(text(),'确定')])[2]")).click();
		  driver.navigate().refresh();
		  driver.navigate().refresh();
          //driver.quit();      	    
		  }else{
          	 
		  }	  
		  
		  //添加公告工具
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.navigate().refresh();
		  driver.findElement(By.linkText("教学工具配置")).click();
		  driver.navigate().refresh();
		  driver.navigate().refresh();
		  driver.navigate().refresh();
		  Thread.sleep(1000);
		  driver.navigate().refresh();
		  Thread.sleep(2000);
		  driver.navigate().refresh();
		  Thread.sleep(5000);
		  driver.navigate().refresh();
		  Thread.sleep(1000);
          driver.findElement(By.xpath("(//a[contains(text(),'复用')])[4]")).click();
          driver.findElement(By.xpath("(//input[@value='文章' and @name='platformTitle'])[2]")).clear();
          Thread.sleep(2000);
          driver.findElement(By.xpath("(//input[@value='文章' and @name='platformTitle'])[2]")).sendKeys("公告");
          Thread.sleep(2000);
          driver.findElement(By.linkText("确定")).click();
          Thread.sleep(9000);
          driver.navigate().refresh();
          //driver.quit();
          
          //教学工具配置
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.findElement(By.linkText("教学工具配置")).click();
		  driver.findElement(By.linkText("教学计划配置")).click();
		  driver.findElement(By.name("myfile")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.testPlan);
		  Thread.sleep(6000);
		  driver.findElement(By.className("btnlink")).click();
          Uti.dropDown(driver, "确定");
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(4000);
		  //driver.quit();
		  
		  //必填字典配置
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
		  //driver.quit();
		 
		  //角色权限设置
		  driver.findElement(By.linkText("组织人员管理")).click();
		  driver.findElement(By.linkText("角色权限配置")).click();
	
		  driver.findElement(By.xpath("(//span[contains(text(),'管理员')])[1]")).click();  
		  Thread.sleep(2000);
		  try {
			  Uti.checkAllPermission(driver,"admin");

			} catch (Exception e) {
				// TODO: handle exception
			}
		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);	
		  driver.findElement(By.xpath("(//span[contains(text(),'专家')])[1]")).click();

		  try {
			  Thread.sleep(2000);
			  Uti.checkAllPermission(driver,"export");
		} catch (Exception e) {
			// TODO: handle exception
		}

		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[contains(text(),'辅导者')])[1]")).click();

		  try {
			  Thread.sleep(2000);
			  Uti.checkAllPermission(driver,"teacher");
		} catch (Exception e) {
			// TODO: handle exception
		}

		  driver.findElement(By.linkText("保存")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//span[contains(text(),'学员')])[1]")).click();

		  try {
			  Thread.sleep(2000);
			  Uti.checkAllPermission(driver,"student");
		} catch (Exception e) {
			// TODO: handle exception
		}

		  driver.findElement(By.linkText("保存")).click();
          Thread.sleep(5000);
		  if(IsStageOrNot.indexOf("yes")!=-1 ){
		  Thread.sleep(2000);
          driver.findElement(By.linkText("菜单预览")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//span[contains(text(),'学员')]")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("保存")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//span[contains(text(),'专家')]")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("保存")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//span[contains(text(),'管理员')]")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("保存")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//span[contains(text(),'辅导者')]")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("保存")).click();
          driver.navigate().refresh();
          driver.findElement(By.linkText("组织人员管理")).click();
          Thread.sleep(4000);
		  //driver.quit();  	    
		  }else{
          	 
		  }	  
		  
//		  //创建注册卡
//		  WebElement ss = driver.findElement(By.linkText("组织人员管理"));
//          Uti.stayMouse(ss, driver);
//          Thread.sleep(2000);
//		  driver.findElement(By.linkText("注册卡管理")).click();
//		  driver.findElement(By.linkText("注册卡管理")).click();
//		  //生成管理员注册卡
//		  driver.findElement(By.linkText("生成注册卡")).click();
//		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("管理员");
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
//		  driver.findElement(By.name("num")).sendKeys("2");
//		  driver.findElement(By.linkText("确定")).click();
//		  Thread.sleep(2000);
//		  //生成专家注册卡
//		  driver.findElement(By.linkText("生成注册卡")).click();
//		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("专家");
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("语文");//选择学科
//		  driver.findElement(By.name("num")).sendKeys("1");
//		  driver.findElement(By.linkText("确定")).click();
//		  driver.findElement(By.linkText("生成注册卡")).click();
//		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("专家");
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("数学");//选择学科
//		  driver.findElement(By.name("num")).sendKeys("1");
//		  driver.findElement(By.linkText("确定")).click();
//		  //生成辅导老师的注册卡
//		  driver.findElement(By.linkText("批量生成注册卡")).click();
//		  driver.findElement(By.xpath("(//input[@type='radio'])[4]")).click();
//
//		  driver.findElement(By.linkText("确定")).click();
//		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
//		  Thread.sleep(2000);
//		  //生成数学学员注册卡
//		  driver.findElement(By.linkText("生成注册卡")).click();
//		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("学员");		
//		  driver.findElement(By.name("hasclass")).click();
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("数学");//选择学科
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
//		  Thread.sleep(2000);
//		  driver.findElement(By.name("num")).sendKeys("2");
//		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[2]"))).selectByVisibleText("惠州市");//选择学科
//		  Thread.sleep(2000);
//		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[3]"))).selectByVisibleText("惠州市第八中学");//选择学科
//		  driver.findElement(By.name("classid")).click();
//		  driver.findElement(By.linkText("确定")).click();
//		  //生成语文学员注册卡
//		  driver.findElement(By.linkText("生成注册卡")).click();
//		  new Select(driver.findElement(By.name("roleId"))).selectByVisibleText("学员");		
//		  driver.findElement(By.name("hasclass")).click();
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[2]"))).selectByVisibleText("语文");//选择学科
//		  new Select(driver.findElement(By.xpath("(//select[contains(@id,'dicttype')])[1]"))).selectByVisibleText("广东省");//选择层级
//		  //new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.className( "dicttype_select" )));
//		  Thread.sleep(2000);
//		  driver.findElement(By.name("num")).sendKeys("2");
//		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[2]"))).selectByVisibleText("惠州市");//选择学科
//		  Thread.sleep(2000);
//		  new Select(driver.findElement(By.xpath("(//select[contains(@class,'_select')])[3]"))).selectByVisibleText("惠州市第八中学");//选择学科
//		  driver.findElement(By.name("classid")).click();
//		  driver.findElement(By.linkText("确定")).click();
//		  //driver.quit();
//		  922号屏蔽的代码
		  //导入人员
		  WebElement ss = driver.findElement(By.linkText("组织人员管理"));
          Uti.stayMouse(ss, driver);
		  driver.findElement(By.linkText("人员管理")).click();
		  //driver.findElement(By.linkText("用户管理")).click();
		  driver.findElement(By.id("dict_file_1")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.studentpath);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[1]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_4")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.teacherpath);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[2]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[2]")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_2")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.exportpath);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[3]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[3]")).click();	
		  Thread.sleep(2000);
		  driver.findElement(By.id("dict_file_3")).click();
		  Thread.sleep(2000);
		  Runtime.getRuntime().exec(DateProvider.adminpath);
          Thread.sleep(4000);
          driver.findElement(By.xpath("(//input[@id='submit'])[4]")).click();
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])[4]")).click();	
	      Thread.sleep(1000);
		  //driver.quit();
	      
	      //保存工具
		  driver.findElement(By.linkText("教学工具管理")).click();
		  driver.findElement(By.linkText("教学工具配置")).click();
		  driver.findElement(By.linkText("确定")).click();
		  Thread.sleep(10000);
		  
          driver.navigate().refresh();
          Thread.sleep(1000);
		  driver.findElement(By.linkText("主页定制和发布")).click();
		  //driver.quit();
		  
		  //加载静态页
		  WebElement ssd = driver.findElement(By.linkText("主页定制和发布"));
          Uti.stayMouse(ssd, driver);
		  driver.findElement(By.linkText("主页定制")).click();
		  WebElement ss2 = driver.findElement(By.className("imgtitle"));
          Uti.stayMouse(ss2, driver);
		  driver.findElement(By.linkText("编辑模板")).click();
		  try {
			
			  Thread.sleep(3000);
			  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
			  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
			  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		  WebElement ss4 = driver.findElement(By.cssSelector("#cont > div.main_cont.clear > div.main.fl"));
          Uti.stayMouse(ss4, driver);
          driver.findElement(By.id("xm_edit")).click();
          try {
          driver.findElement(By.xpath("(//input[@name='otool_checkbox'])[2]")).click();

		} catch (Exception e) {
	      driver.findElement(By.name("otool_checkbox")).click();
		}
          driver.findElement(By.linkText("确定")).click();

          driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();
          try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
          Thread.sleep(1000);
          Thread.sleep(3000);
          Thread.sleep(1000);
          driver.findElement(By.linkText("主页定制和发布")).click();
          driver.navigate().refresh();
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  WebElement ss3 = driver.findElement(By.linkText("主页定制和发布"));
          Uti.stayMouse(ss3, driver);
		  driver.findElement(By.linkText("静态页生成")).click();
		  Thread.sleep(1000);
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  try {
    		  Uti.waitForAlertAndCloseAlert(driver);
			  Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		  driver.findElement(By.xpath("//span[contains(text(),'kend')]")).click();
	 }
}
