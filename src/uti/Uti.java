package uti;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Uti {
 

	private static String current_time;
	//程序启动并进项目代码
	public static void ChromeBrowser_setup(ChromeDriver driver,String username,String password){
		System.setProperty("webdriver.chrome.driver", "/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
	    //driver.get("http://cas.dev.teacheredu.cn/auth/login?service=http%3A%2F%2Fcas.dev.teacheredu.cn%2Fuc%2Findex.htm&renew=true&share=share&isGate=false");
	    driver.get("http://dev.teacheredu.cn/baseplat/permission/project/project_search_view.htm");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.cssSelector("h3.login_kxdl")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'配置')])[1]")).click();//点击第一个项目的去配置，xpath可以查找以某字符串开头的、结尾的或者是包含的元素
    	
//	    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
//	    List<String> it = new ArrayList<String>(handles);
//	    driver.switchTo().window(it.get(1));	
    }
	//切换窗口的方法
	public static void ChangeWindows(WebDriver driver, int index){
	    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it = new ArrayList<String>(handles);
	    driver.switchTo().window(it.get(index));	
	}
	
	//上传文件方法
	public synchronized static void UploadFile(WebDriver driver, String path,String idname) throws Exception{
	    driver.findElement(By.id(idname)).click();
	    driver.findElement(By.id(idname)).click();
	    driver.findElement(By.id(idname)).click();
	    Runtime.getRuntime().exec(path);
	    Thread.sleep(6000);
	}
	
	//WebDriver的富文本输入方法
	public static void richText(WebDriver driver,int frame_index,String content){
		
		driver.switchTo().frame(frame_index);
		driver.findElement(By.tagName("body")).sendKeys(content);
		driver.switchTo().defaultContent();
		
	}
	
	//上传视频方法
	public synchronized static void UploadVedio(WebDriver driver, String path) throws Exception{
	    driver.findElement(By.cssSelector("#uploadVideo")).click();    
	    Thread.sleep(1000);
	    
	    try {
		    while (true){
		    	driver.findElement(By.id("uploadList_li")).click();
			    driver.findElement(By.id("uploadswf")).click();
			    Runtime.getRuntime().exec(path); 
			    Thread.sleep(6000);
			    break;
		    }
			
		} catch (Exception e) {
		}
	    driver.findElement(By.id("uploadswf")).click();
	    Runtime.getRuntime().exec(path); 
	    Thread.sleep(6000); 
	}
	//获取当前系统时间，带双引号的时间戳
	public static String  get_currenttime() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Currentday =sdf.format(date);		
		current_time= "\""+Currentday+"\"";		
		return current_time;//带双引号的时间字符串
		
	}
	//获取当前系统时间,时间戳
	public static String  get_currenttime1() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Currentday =sdf.format(date);				
		return Currentday;//不带双引号的时间字符串
	}
	
    //获取页面要查找元素的个数并点击处理所有页面下的该元素
	public static void getFindElementCount(ChromeDriver driver,String a) throws Exception{
	
		
		
		  int number = driver.findElements(By.linkText(a)).size();
		  //System.out.println(number);
          //查找当前页面所有要查找的元素的个数
        for(int i=0;i<number;i++){
      	     driver.findElement(By.linkText(a)).click();
			  driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.linkText("确定")).click();
			  driver.navigate().refresh();
			  Thread.sleep(1000);
        }
		
	}
	//实现拖拽效果
	public static void dragHuodongStep(WebElement element1,WebElement element2,ChromeDriver driver) throws Exception{
		   Actions actions = new Actions(driver);  
		   Action dragaction=actions.clickAndHold(element1).moveToElement(element2).release(element2).build();
		   dragaction.perform();
	}
	
	public static void dropDown(ChromeDriver driver,String string) throws Exception{
		    Actions actions = new Actions(driver);//声明一个动作
	        actions.doubleClick().build().perform();//双击空白
	        Thread.sleep(1000);	        
	        driver.findElement(By.linkText(string)).sendKeys(Keys.DOWN);  //敲击键盘，页面自动下拉到底部
		    Thread.sleep(1000);
	}
	
	//鼠标悬停操作
	public static void stayMouse(WebElement element,ChromeDriver driver) throws Exception{

		  Actions actions = new Actions(driver); 
		  Actions dragaction=actions.clickAndHold(element);
		  dragaction.perform();
	}
	
	//勾选各个角色的权限
	public static void checkAllPermission(ChromeDriver driver,String role) throws Exception{
			switch(role){
			case "admin":
				  //driver.findElement(By.xpath("(//input[@class='p_parent_'])[2]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[3]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[4]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[5]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[6]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[7]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[8]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[9]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[10]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[11]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[12]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[13]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[14]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[15]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[16]")).click();

				  break;
			case "export":
				  //driver.findElement(By.xpath("(//input[@class='p_parent_'])[2]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[3]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[4]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[5]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[6]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[7]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[8]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[9]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[10]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[11]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[12]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[13]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[14]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[15]")).click();

				  break;
			case "teacher":
				  //driver.findElement(By.xpath("(//input[@class='p_parent_'])[2]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[3]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[4]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[5]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[6]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[7]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[8]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[9]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[10]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[11]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[12]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[13]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[14]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[15]")).click();

				  break;
			case "student":
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[2]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[3]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[4]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[5]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[6]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[7]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[8]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[9]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[10]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[11]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[12]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[13]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[14]")).click();
				  driver.findElement(By.xpath("(//input[@class='p_parent_'])[15]")).click();
				  break;
			}
		}  
//	  for(int i = 0;i < ascf.size();i++) {
//	  int j =i +1;
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[/"+j+"/]")).click();
//	  Thread.sleep(1000);
//	}
	
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[3]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[4]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[5]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[6]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[7]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[8]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[9]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[10]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[11]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[12]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[13]")).click();
//	  driver.findElement(By.xpath("(//input[@class='p_parent_'])[14]")).click();
	  
	//获取当前系统时间,时间戳
	public static String  get_currenttime2() throws Exception{
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		String Currentday =sdf.format(date);				
		return Currentday;//不带双引号的时间字符串		
	}
	//alert 处理方法，
	//二十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常
	public static void  waitForAlertAndCloseAlert(WebDriver driver) throws Exception   
	{  
	   int i=0;  
	   while(i++<30)  
	   {  
	        try  
	        {  
	            Alert alert = driver.switchTo().alert();  
	            alert.accept();  
	            break;  
	        }  
	        catch(NoAlertPresentException e)  
	        { 
	          Thread.sleep(1000);  
	          continue;  
	        }  
	   }  
	   if(i==29){  
	       throw new NoAlertPresentException();  
	   }  
	}
	//生成一个随机数
	public static int get_random() throws Exception{
        int random=(int) (Math.random()*1000);//产生0-1000的双精度随机数  
        //System.out.println(random);
		return random;
		
	}
	  public  boolean isTextPresent(ChromeDriver driver,String what) {
		  try{
		  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含文本 what,返回的是ture或者false
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }	 
	  }	  
	  
	  
	//获取同伴协作标题
	public static String  get_cooperationName() throws Exception{
		String cooperationName = "同伴协作"+Uti.get_random();			
		return cooperationName;
	}
	//获取活动名字
	public static String  get_activityName() throws Exception{
		String activityName = "活动"+Uti.get_random();					
		return activityName;
	}
	//获取磨课名字
	public static String  get_mokeName() throws Exception{
		String mokeName = "磨课"+Uti.get_random();
		return mokeName;
	}
	//获取备课名称
	public static String  get_beikeName() throws Exception{
		String beikeName = "备课"+Uti.get_random();
		return beikeName;
	}
	//获取作业名字
	public static String  get_zuoyeName() throws Exception{
		String zuoyeName = "作业"+Uti.get_random();
		return zuoyeName;
	}
	//获取文章名称
		public static String  get_docName() throws Exception{
			String docName = "文章"+Uti.get_random();
			return docName;
		}
	//获取交流名称
	public static String  get_exchangeName() throws Exception{
			String exchangeName ="交流"+Uti.get_random();
			return exchangeName;
		}
}
	

