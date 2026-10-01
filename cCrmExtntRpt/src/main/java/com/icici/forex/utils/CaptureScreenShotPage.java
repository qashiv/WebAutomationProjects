package com.icici.forex.utils;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class CaptureScreenShotPage extends AbstractPage {
	
	public CaptureScreenShotPage(WebDriver driver) {
		super(driver);

	}

	 public void takeScreenshot(String methodName,String report_path, String title) {
			
		 	String fileName;
			String path;

		 	try {
		 		
				 	if(methodName.contains("Failed") || methodName.contains("VPScreenshot"))
					{
				 		fileName=methodName;
				 		path=report_path+"/"+fileName;
				 		
				 		//Take screenshot
						TakesScreenshot ts=(TakesScreenshot)driver;
						
						//this will capture ss
						File source=ts.getScreenshotAs(OutputType.FILE);
						
						FileUtils.copyFile(source,new File(path));
						System.out.println("Screenshot taken");	
						
						BaseAbstractTest.htmlScreenshotList=BaseAbstractTest.htmlScreenshotList+
								"<li class=\"loaded\"><a href=\""+fileName+"\"><img src=\""+fileName+"\" title=\""+title+"\" onload=\"\"></a></li>";

		
					}
					else if (BaseAbstractTest.isCustom_Screenshot.equals("true")){
					fileName=getScreenshotname(methodName);
			 		path=report_path+"/"+fileName;
			 		
			 		//Take screenshot
					TakesScreenshot ts=(TakesScreenshot)driver;
					
					//this will capture ss
					File source=ts.getScreenshotAs(OutputType.FILE);
					
					FileUtils.copyFile(source,new File(path));
					System.out.println("Screenshot taken");	
					
					BaseAbstractTest.htmlScreenshotList=BaseAbstractTest.htmlScreenshotList+
							"<li class=\"loaded\"><a href=\""+fileName+"\"><img src=\""+fileName+"\" title=\""+title+"\" onload=\"\"></a></li>";		
					
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Code written to get screenshot name
		 * @param methodName
		 * @return
		 */
		public static String getScreenshotname(String methodName) {
			Date d=new Date();
			String fileName= methodName+"_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
			return fileName;
		}

}
