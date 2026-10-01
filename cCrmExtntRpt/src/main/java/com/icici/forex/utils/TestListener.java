package com.icici.forex.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TestListener implements ITestListener {

	private int passedTests = 0;
	private int failedTests = 0;
	private int skippedTests = 0;
	private Date startTime;
	private Date endTime;

	@Override
	public void onFinish(ITestContext context) {
		endTime = new Date();
		try {
			uploadAndSendReportByOneDrive();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		SendTestResultsEmail();
	}

	@Override
	public void onStart(ITestContext contextStart) {
		startTime = new Date();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failedTests++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skippedTests++;
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passedTests++;
	}

	public void uploadAndSendReportByOneDrive() throws Exception {
		/// C:\Program Files\Google\Chrome\Application>
		// chrome.exe --remote-debugging-port=1111 --user-data-dir="D:\AutomationProfile"
		System.setProperty("webdriver.chrome.driver", "./qps-hub\\lib\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("debuggerAddress", "127.0.0.1:1111");
		WebDriver driver = new ChromeDriver(opt);
		driver.get(
				"https://icicibankltd-my.sharepoint.com/personal/ban428735_ext_icicibank_com/_layouts/15/onedrive.aspx?view=0");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement folderName = driver.findElement(By.xpath("//span//*[contains(text(),'Phase1 Automation Report')]"));
		folderName.click();
		/// Create New Folder or verify existing folder : Report_dateTime
		String date = new SimpleDateFormat("ddMMMyyyy").format(new Date());
		WebElement addNewBtn = driver.findElement(By.xpath("//span[text()='Add new']//parent::button"));
		WebElement folder_Name = null;
		try {
			folder_Name = driver.findElement(By.xpath("//span//*[text()='Report_" + date + "']"));
			String folderAvailable = folder_Name.getText();
			if (folderAvailable.equals("Report_" + date)) {
				folder_Name.click();
			}
		} catch (Exception e) {
			addNewBtn.click();
			WebElement createFolder = driver.findElement(By.xpath("//span[text()='Folder']"));
			createFolder.click();
			WebElement inputFolderName = driver.findElement(By.xpath("//input[contains(@placeholder,'folder name')]"));
			inputFolderName.sendKeys("Report_" + date);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@data-automation-id='Create']//span[text()='Create']")).click();
			Thread.sleep(5000);
			folder_Name = driver.findElement(By.xpath("//span//*[text()='Report_" + date + "']"));
			folder_Name.click();
		}
		WebElement folderWithTimeDate = null;
		String timeDate = new SimpleDateFormat("ddMMM_hh_mm_ss").format(new Date());
		try {
			folderWithTimeDate = driver.findElement(By.xpath("//span//*[text()='Report_"+timeDate+"']"));
			String currentFolder = folderWithTimeDate.getText();
			if(currentFolder.equals("Report_" + timeDate)) {
				folderWithTimeDate.click();
			}
		}catch(Exception e) {
			addNewBtn.click();
			WebElement createFolder = driver.findElement(By.xpath("//span[text()='Folder']"));
			createFolder.click();
			WebElement inputFolderName = driver.findElement(By.xpath("//input[contains(@placeholder,'folder name')]"));
			inputFolderName.sendKeys("Report_" + timeDate);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@data-automation-id='Create']//span[text()='Create']")).click();
			Thread.sleep(5000);
			folder_Name = driver.findElement(By.xpath("//span//*[text()='Report_" + timeDate + "']"));
			folder_Name.click();
		}
		addNewBtn.click();
		Thread.sleep(2000);
		WebElement folderUpload = driver.findElement(By.xpath("//span[text()='Folder upload']"));
		folderUpload.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		String folderPath = System.getProperty("user.dir") + "\\reports";
		StringSelection stringSelection = new StringSelection(folderPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		// Press CTRL+V to paste the path
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(30000);
		WebElement shareBtn = driver.findElement(By.xpath("//span[text()='Share']"));
		shareBtn.click();
		Thread.sleep(2000);
		WebElement shareFrame = null;
		try {
			shareFrame = driver.findElement(By.xpath("//iframe[@title='Share']"));
			driver.switchTo().frame(shareFrame);
		} catch (Exception e) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(30000);
			shareBtn.click();
			Thread.sleep(2000);
			try {
				shareFrame = driver.findElement(By.xpath("//iframe[@title='Share']"));
				driver.switchTo().frame(shareFrame);
			} catch (Exception ex) {
				Robot rbt = new Robot();
				rbt.keyPress(KeyEvent.VK_TAB);
				rbt.keyRelease(KeyEvent.VK_TAB);
				rbt.keyPress(KeyEvent.VK_ENTER);
				rbt.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(30000);
				shareBtn.click();
				Thread.sleep(2000);
				shareFrame = driver.findElement(By.xpath("//iframe[@title='Share']"));
				driver.switchTo().frame(shareFrame);
			}
		}
		WebElement inputUserName = driver.findElement(By.xpath("//input[@aria-autocomplete='both']"));
		inputUserName.sendKeys("Shiv Babu");
		WebElement suggestionOpt = driver.findElement(By.xpath("//div[contains(@aria-label,'Shiv Babu ')]"));
		suggestionOpt.click();
		WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add a message']"));
		String emailContent = "Dear Team,\n\n"
				+ "Automation suite has been executed for ICICI Forex DS. Please find the summary below.\n\n"
				+ "Application Name: ICICI FOREX DS\nNo of Test Scenarios: " + (passedTests + failedTests + skippedTests)
				+ "\nPassed: " + passedTests + "\nFailed: " + failedTests + "\nSkipped: " + skippedTests
				+ "\nStart Date Time: " + startTime + "\nEnd Date Time: " + endTime + "\n\nRegards,\n"
				+ "Automation Team";
		description.sendKeys(emailContent);
		WebElement sendBtn = driver.findElement(By.xpath("//button[@aria-label='Send']"));
		sendBtn.click();
		Thread.sleep(10000);
		driver.close();
	}

	public void SendTestResultsEmail() {

		final String username = "ban428735@ext.icicibank.com";
		final String password = "QKquality@1101";
		final String emailto = "ban428735@ext.icicibank.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.ssl.trust", "smtp.office365.com");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.debug", "true");

		props.put("mail.imap.ssl.enable", "true");
		props.put("mail.imap.auth.mechanisms", "XOAUTH2");
		props.put("mail.imap.auth.plain.disable", "true");
		props.put("mail.imap.auth.xoauth2.disable", "false");

		props.put("mail.debug", "true");
		props.put("mail.debug.auth", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				System.out.println("Authenticating");
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));
			message.setSubject("Test Suite Results");

			String startTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(startTime);
			String endTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime);

			StringBuilder emailContent = new StringBuilder();
			emailContent.append("<p>Dear Team,</p>");
			emailContent.append(
					"<p>Automation suite has been executed for <strong>ICICI FOREX DS</strong>. Please find the summary below.</p>");
			emailContent.append("<table border='1'>").append(
					"<tr><th>Application Name</th><th>Run ID</th><th>No of Test Cases</th><th>Passed</th><th>Failed</th><th>Skipped</th><th>Start Date Time</th><th>End Date Time</th></tr>")
					.append("<tr><td>ICICI FOREX DS</td><td>484</td><td>")
					.append(passedTests + failedTests + skippedTests).append("</td>").append("<td>").append(passedTests)
					.append("</td>").append("<td>").append(failedTests).append("</td>").append("<td>")
					.append(skippedTests).append("</td>").append("<td>").append(startTimeStr).append("</td>")
					.append("<td>").append(endTimeStr).append("</td></tr>").append("</table>");
			emailContent.append("<p>Regards,<br>Automation Team.</p>");
			emailContent.append("<p><i>This is a system generated mail, please don't reply to this mail.</i></p>");

			message.setContent(emailContent.toString(), "text/html");
			Transport.send(message);
			System.out.println("Test results email sent successfully.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
