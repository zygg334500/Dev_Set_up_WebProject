package DateProvider;

import org.testng.annotations.DataProvider;

import uti.Uti;

/**
 * @author ziyang
 *
 */
public class DateProvider {
	private static String SuperAdmin="admin";
	private static String SuperPassword="123123";		
	private static String AdminUsername="wnceshi123";
	private static String AdminPassword="123123";
	private static String BackgroundUrl="http://dev.teacheredu.cn/baseplat/permission/project/project_search_view.htm";
	public static String cenji="E:/Downloads/uploadCenji.exe";
	public static String xueke="E:/Downloads/uploadXueke.exe";
	public static String banji="E:/Downloads/uploadbanji.exe";
	public static String testPlan="E:/Downloads/uploadTestPlan.exe";
	public static String studentpath="E:/Downloads/uploadDevStudent.exe";
	public static String teacherpath="E:/Downloads/uploadDevTeacher.exe";
	public static String exportpath="E:/Downloads/uploadDevExport.exe";
	public static String adminpath="E:/Downloads/uploadDevadminuser.exe";
	public static String IsStageOrNot="no";


@DataProvider(name = "guanliyuanCenjiPath")

public static Object[][] admin() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword,cenji}		
};
}

@DataProvider(name = "guanliyuanXuekePath")

public static Object[][] admin2() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword,xueke}		
};
}

@DataProvider(name = "guanliyuanBanjiPath")

public static Object[][] admin3() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword,banji}		
};
}

@DataProvider(name = "guanliyuanTestPath")

public static Object[][] admin5() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword,testPlan}		
};
}

@DataProvider(name = "guanliyuan")

public static Object[][] admin4() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword}		
};
}

@DataProvider(name = "guanliyuana")

public static Object[][] admin4a2() {
	
return new Object[][] { 
new Object[]{SuperAdmin,SuperPassword,AdminUsername,AdminPassword,BackgroundUrl,IsStageOrNot}		
};
}

@DataProvider(name = "guanliyuanImportPersons")

public static Object[][] admin88() {
	
return new Object[][] { 
new Object[]{AdminUsername,AdminPassword,studentpath,teacherpath,exportpath,adminpath}		
};
}

}
