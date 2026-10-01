package com.icici.forex.pages;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.CardRatePagesOr;
import com.icici.forex.utils.CaptureScreenShotPage;

public class CardRatePages extends CardRatePagesOr {

	ExtentTest test;
	CommonReusableMethods reusable = new CommonReusableMethods(driver, test);
	private LoginPage loginPage = new LoginPage(getDriver());
	private DashboardPage dashboardPage = new DashboardPage(getDriver(), test);
	CaptureScreenShotPage cs = new CaptureScreenShotPage(getDriver());

	public CardRatePages(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void addRateSourceByAutoFetch(String marketType, String IFRACurrencyPair, String isJPMC,
			String JPMCCurrencyPair, String isIFRA, String ChekerId, String password, String comments, String reject,
			String makerId) {
		getTabRateSource().clickByJs();
		reusable.selectMarketType(marketType);
		getIconEdit().clickByJs();
		reusable.holdOn(1);
		if (getRadioManualMode().isChecked()) {
			getRadioManualMode().clickByActions();
		}
		if (getRadioAutoFetchMode().isChecked()) {
			getRadioAutoFetchMode().clickByJs();
			reusable.holdOn(1);
			getRadioBtnAutoFetchMode().clickByActions();
		} else if (!getRadioAutoFetchMode().isChecked()) {
			getRadioBtnAutoFetchMode().clickByActions();
		}
		if (isIFRA.equalsIgnoreCase("Yes") && !getRadioBtnIFRA().isChecked()) {
			getRadioBtnIFRA().clickByActions();
			getSelectIFRACurrencyPair().clickByJs();
			String[] currencyPair = reusable.getStringArray(IFRACurrencyPair);
			for (int i = 0; i < currencyPair.length; i++) {
				getInputCurrencyPair().type(currencyPair[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
			reusable.holdOn(1);
			getSelectIFRACurrencyPair().clickByJs();
		}
		if (isJPMC.equalsIgnoreCase("Yes") && !getRadioJPMC().isChecked()) {
			getRadioBtnJPMC().clickByActions();
			getSelectJPMCCurrencyPair().clickByJs();
			String[] currencyPairs = reusable.getStringArray(JPMCCurrencyPair);
			reusable.holdOn(1);
			getInputCurrencyPair().scrollTo();
			reusable.holdOn(1);
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
		}
		reusable.holdOn(1);
		getBtnUpdate().scrollTo();
		reusable.holdOn(1);
		getBtnUpdate().clickByJs();
		reusable.holdOn(2);
		String getTextAlreadyPendingList = getTextPendingAprroval().getText();
		if (getTextAlreadyPendingList.equals("Request for this rate source ID is already present in pending list")) {
			reusable.holdOn(1);
			reusable.logOut();
			loginPage.loginApplication(ChekerId, password);
			dashboardPage.clickHamburgerBtn();
			dashboardPage.hoverCardRate();
			approveOrRejectRateSource(comments, reject, marketType);
			reusable.holdOn(1);
			reusable.logOut();
			loginPage.loginApplication(makerId, password);
			dashboardPage.clickHamburgerBtn();
			reusable.holdOn(1);
			dashboardPage.hoverCardRate();
			getTabRateSource().clickByJs();
			reusable.selectMarketType(marketType);
			getIconEdit().clickByJs();
			reusable.holdOn(1);
			if (getRadioManualMode().isChecked()) {
				getRadioManualMode().clickByActions();
			}
			if (getRadioAutoFetchMode().isChecked()) {
				getRadioAutoFetchMode().clickByJs();
				reusable.holdOn(1);
				getRadioBtnAutoFetchMode().clickByActions();
			} else if (!getRadioAutoFetchMode().isChecked()) {
				getRadioBtnAutoFetchMode().clickByActions();
			}
			if (isIFRA.equalsIgnoreCase("Yes") && !getRadioBtnIFRA().isChecked()) {
				getRadioBtnIFRA().clickByActions();
				getSelectIFRACurrencyPair().clickByJs();
				String[] currencyPair = reusable.getStringArray(IFRACurrencyPair);
				for (int i = 0; i < currencyPair.length; i++) {
					getInputCurrencyPair().type(currencyPair[i]);
					reusable.holdOn(1);
					getRadioCurrencyPair().clickByActions();
				}
				reusable.holdOn(1);
				getSelectIFRACurrencyPair().clickByJs();
			}
			if (isJPMC.equalsIgnoreCase("Yes") && !getRadioJPMC().isChecked()) {
				getRadioBtnJPMC().clickByActions();
				getSelectJPMCCurrencyPair().clickByJs();
				String[] currencyPairs = reusable.getStringArray(JPMCCurrencyPair);
				reusable.holdOn(1);
				getInputCurrencyPair().scrollTo();
				reusable.holdOn(1);
				for (int i = 0; i < currencyPairs.length; i++) {
					getInputCurrencyPair().type(currencyPairs[i]);
					reusable.holdOn(1);
					getRadioCurrencyPair().clickByActions();
				}
			}
			reusable.holdOn(1);
			getBtnUpdate().scrollTo();
			reusable.holdOn(1);
			getBtnUpdate().clickByJs();
			reusable.holdOn(1);
		}

	}

	public void addRateSourceByManualMode(String marketType, String manualCurrencyPair) {
		getTabRateSource().clickByJs();
		reusable.selectMarketType(marketType);
		getIconEdit().clickByJs();
		if (getRadioAutoFetchMode().isChecked()) {
			getRadioAutoFetchMode().clickByActions();
		}
		if (!getRadioManualMode().isChecked()) {
			getRadioManualMode().clickByActions();
			String[] currencyPairs = reusable.getStringArray(manualCurrencyPair);
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				if (!getRadioCurrencyPair().isChecked()) {
					getRadioCurrencyPair().clickByActions();
				}
			}
		}
		reusable.holdOn(1);
		getBtnUpdate().clickByJs();
	}

	public void addRateSourceByAutoAndManualMode(String marketType, String IFRACurrencyPair, String isJPMC,
			String JPMCCurrencyPair, String manualCurrencyPair) {
		getTabRateSource().clickByJs();
		reusable.selectMarketType(marketType);
		reusable.holdOn(1);
		getIconEdit().clickByJs();
		reusable.holdOn(1);
		if (getRadioAutoFetchMode().isChecked()) {
			getRadioAutoFetchMode().clickByJs();
			reusable.holdOn(1);
			getRadioBtnAutoFetchMode().clickByActions();
		} else if (!getRadioAutoFetchMode().isChecked()) {
			getRadioBtnAutoFetchMode().clickByActions();
		}
		if (!getRadioIFRA().isChecked()) {
			getRadioBtnIFRA().clickByActions();
			getSelectIFRACurrencyPair().clickByJs();
			String[] currencyPair = reusable.getStringArray(IFRACurrencyPair);
			for (int i = 0; i < currencyPair.length; i++) {
				getInputCurrencyPair().type(currencyPair[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
			reusable.holdOn(1);
			getSelectIFRACurrencyPair().clickByJs();
		}
		if (isJPMC.equalsIgnoreCase("Yes") && !getRadioJPMC().isChecked()) {
			getRadioBtnJPMC().clickByActions();
			getSelectJPMCCurrencyPair().clickByJs();
			String[] currencyPairs = reusable.getStringArray(JPMCCurrencyPair);
			reusable.holdOn(1);
			getInputCurrencyPair().scrollTo();
			reusable.holdOn(1);
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
		}
		if (getRadioManualMode().isChecked()) {
			getRadioManualMode().clickByActions();
			reusable.holdOn(1);
			getRadioManualMode().clickByActions();
			String[] currencyPairs = reusable.getStringArray(manualCurrencyPair);
			getSelectManualCurrencyPair().clickByActions();
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				if (!getRadioCurrencyPair().isChecked()) {
					getRadioCurrencyPair().clickByActions();
				}
			}

		} else if (!getRadioManualMode().isChecked()) {
			getRadioManualMode().clickByActions();
			String[] currencyPairs = reusable.getStringArray(manualCurrencyPair);
			getSelectManualCurrencyPair().clickByActions();
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				if (!getRadioCurrencyPair().isChecked()) {
					getRadioCurrencyPair().clickByActions();
				}
			}
		}
		reusable.holdOn(1);
		getBtnUpdate().clickByActions();
	}

	public void addRefreshRate(String marketType, String refreshFrequency, String customTime, String refreshTimeFrom,
			String refreshTimeTo) {
		reusable = new CommonReusableMethods(driver, test);
		getTabRefreshRate().clickByJs();
		reusable.selectMarketType(marketType);
		getIconEdit().clickByJs();
		String status = getToggleStatus().getAttribute("aria-checked");
		if (!status.equals("true")) {
			getToggleStatus().clickByActions();
		}
		if (refreshFrequency.equalsIgnoreCase("Daily")) {
			getRadioDaily().clickByActions();
			getIconPublishTimeFrom().clickByJs();
			String[] timeFrom = reusable.getStringArray(refreshTimeFrom);
			reusable.holdOn(1);
			getInputHours().doubleClick();
			getInputHours().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputHours().type(timeFrom[0]);
			reusable.holdOn(1);
			getInputMinutes().doubleClick();
			getInputMinutes().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputMinutes().type(timeFrom[1]);
			reusable.holdOn(1);
			getBtnAM().clickByActions();
			getBtnOk().clickByActions();
		} else if (refreshFrequency.equalsIgnoreCase("Hourly")) {
			getRadioHourly().clickByActions();
			getIconPublishTimeFrom().clickByJs();
			String[] timeFrom = reusable.getStringArray(refreshTimeFrom);
			reusable.holdOn(1);
			getInputHours().doubleClick();
			getInputHours().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputHours().type(timeFrom[0]);
			reusable.holdOn(1);
			getInputMinutes().doubleClick();
			getInputMinutes().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputMinutes().type(timeFrom[1]);
			reusable.holdOn(1);
			getBtnAM().clickByActions();
			getBtnOk().clickByActions();
			getIconPublishTimeTo().clickByJs();
			String[] timeTo = reusable.getStringArray(refreshTimeTo);
			getInputHours().doubleClick();
			getInputHours().sendKeys(Keys.BACK_SPACE);
			getInputHours().type(timeTo[0]);
			reusable.holdOn(1);
			getInputMinutes().doubleClick();
			getInputMinutes().sendKeys(Keys.BACK_SPACE);
			getInputMinutes().type(timeTo[1]);
			getBtnPM().clickByJs();
			getBtnOk().clickByJs();
		} else if (refreshFrequency.equalsIgnoreCase("Custom")) {
			getRadioCustom().clickByActions();
			getSelectCustomTime().clickByJs();
			reusable.selectFromDropdown(customTime);
			getIconPublishTimeFrom().clickByJs();
			String[] timeFrom = reusable.getStringArray(refreshTimeFrom);
			reusable.holdOn(1);
			getInputHours().doubleClick();
			getInputHours().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputHours().type(timeFrom[0]);
			reusable.holdOn(1);
			getInputMinutes().doubleClick();
			getInputMinutes().sendKeys(Keys.BACK_SPACE);
			reusable.holdOn(1);
			getInputMinutes().type(timeFrom[1]);
			reusable.holdOn(1);
			getBtnAM().clickByActions();
			getBtnOk().clickByActions();
			String[] timeTo = reusable.getStringArray(refreshTimeTo);
			getIconPublishTimeTo().clickByJs();
			getInputHours().doubleClick();
			getInputHours().sendKeys(Keys.BACK_SPACE);
			getInputHours().type(timeTo[0]);
			getInputMinutes().doubleClick();
			getInputMinutes().sendKeys(Keys.BACK_SPACE);
			getInputMinutes().type(timeTo[1]);
			getBtnPM().clickByJs();
			getBtnOk().clickByJs();
		}
		getBtnUpdate().scrollTo();
		reusable.holdOn(1);
		getBtnUpdate().clickByJs();
	}

	public void uploadFilesOnInputDataSheet(String marketType, String IFRAFilePath, String JPMCFilePath) {
		getTabInputDataSheet().clickByJs();
		reusable.holdOn(1);
		reusable.selectMarketType(marketType);
		getBtnFetchRate().clickByActions();
		reusable.holdOn(1);
		String msg = reusable.toastMessage();
		if (msg.contains("Rates fetched successfully")) {
			reusable.holdOn(1);
			getRadioUploadFile().clickByActions();
		}
		waitUntil(ExpectedConditions.visibilityOfElementLocated(findIconAttach), EXPLICIT_TIMEOUT);
		WebElement ifraAttachFile = driver.findElement(By.xpath("//div[@class='fileUploadData']//input"));
		IFRAFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Test Files\\IFRATemplate.xlsx";
		JPMCFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Test Files\\jpmcTemplate.xlsx";
		ifraAttachFile.sendKeys(IFRAFilePath);
		reusable.holdOn(1);
		WebElement jpmcAttachFile = driver.findElement(By.xpath("//p[text()='JPMC']//parent::div//input"));
		jpmcAttachFile.sendKeys(JPMCFilePath);
		getBtnSubmit().scrollTo();
		reusable.holdOn(1);
		getBtnSubmit().clickByJs();
		reusable.holdOn(1);
		getBtnYes().clickByJs();
	}

	public void updateInputDataSheet(String marketType) {
		getTabInputDataSheet().clickByJs();
		reusable.selectMarketType(marketType);
		getBtnFetchRate().clickByJs();
		reusable.holdOn(1);
		String msg = reusable.toastMessage();
		if (msg.contains("Rates fetched successfully")) {
			reusable.holdOn(1);
			getIconEditRate().clickByJs();
		}
	}

	public void openMyRequest() {
		getBtnMyRequest().clickByJs();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPendingForApr));
	}

	public void approveOrRejectRateSource(String comments, String approveOrReject, String marketType) {
		getTabRateSource().clickByJs();
		reusable.selectMarketType(marketType);
		getBtnPendingApproval().clickByJs();
		reusable.holdOn(1);
		getIconEdit().clickByJs();
		getBtnAccept().scrollTo();
		getInputComments().type(comments);
		if (approveOrReject.equalsIgnoreCase("Approve")) {
			getBtnAccept().clickByJs();
			getBtnYes().clickByJs();
		} else if (approveOrReject.equalsIgnoreCase("Reject")) {
			getBtnReject().clickByJs();
			getBtnYes().clickByJs();
		} else {
			test.log(Status.FAIL, "Unable to click on " + approveOrReject + " button.");
		}

	}

	public void approveOrRejectRefreshRate(String comments, String approveOrReject) {
		getTabRefreshRate().clickByJs();
		getBtnPendingApproval().clickByJs();
		reusable.holdOn(1);
		getIconEdit().clickByJs();
		getInputComments().type(comments);
		if (approveOrReject.equalsIgnoreCase("Approve")) {
			getBtnAccept().clickByJs();
			getBtnYes().clickByJs();
		} else if (approveOrReject.equalsIgnoreCase("Reject")) {
			getBtnReject().clickByJs();
			getBtnYes().clickByJs();
		} else {
			test.log(Status.FAIL, "Unable to click on " + approveOrReject + " button.");
		}

	}

	public void goToInputDataSheet() {
		getTabInputDataSheet().clickByJs();
	}

	public List<String> returnInterbankSellingRatesFromIDS(String currencyPairForRates) {
		String[] currencyPairForRate = reusable.getStringArray(currencyPairForRates);
		List<String> interbankRatesFC = new ArrayList<String>();
		int k = 0;
		int size = getTxtInterbankRateFC().size();
		try {
			for (int i = 0; i < size; i++) {
				String currencyPairFC = getTxtCurrencyPairFCSelling().get(i).getAttribute("value");
				if (currencyPairFC.equals(currencyPairForRate[k])) {
					String text = getTxtInterbankRateFC().get(i).getAttribute("value");
					interbankRatesFC.add(text);
					k++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			test.log(Status.INFO, e.getMessage());
		}
		return interbankRatesFC;
	}

	public String currencyConversionCalculation(String currencyPairs) {
		String cpy1, cpy2, expSellingRate = null;
		double rate1, rate2, expectedSellingRate;
		DecimalFormat df = new DecimalFormat("#.####");
		String[] G5Currency = { "EUR", "USD", "GBP", "AUD", "NZD" };
		String[] currencyPair = reusable.getStringArray(currencyPairs);
		for (int i = 0; i < currencyPair.length; i++) {
			for (int j = 0; j < G5Currency.length; j++) {
				String cpy = G5Currency[j] + "/USD";
				if (currencyPair[i].equals(cpy)) {
					test.log(Status.INFO, currencyPair[i] + " - FC is G5 Currency");
					cpy1 = G5Currency[j] + "/USD";
					cpy2 = "USD/INR";
					String[] cpyForInterBankRates = { cpy1, cpy2 };
					List<String> interbankRatesFC = new ArrayList<String>();
					for (int k = 0; k < cpyForInterBankRates.length; k++) {
						String currencyPairFC = getTxtCurrencyPairFCSelling().get(k).getAttribute("value");
						for (int x = 0; x < cpyForInterBankRates.length; x++) {
							if (currencyPairFC.equals(cpyForInterBankRates[x])) {
								String cpyRate = getTxtInterbankRateFC().get(k).getAttribute("value");
								reusable.holdOn(1);
								interbankRatesFC.add(cpyRate);
							}
						}
					}
					rate1 = Double.parseDouble(interbankRatesFC.get(0));
					rate2 = Double.parseDouble(interbankRatesFC.get(1));
					expectedSellingRate = rate1 * rate2;
					test.log(Status.INFO, "After Multiplying " + cpy1 + " rate and " + cpy2
							+ " rate ,Expected Selling Rate is : " + expectedSellingRate);
					expSellingRate = df.format(expectedSellingRate);
					test.log(Status.INFO, G5Currency[j] + "/INR rate is : " + expSellingRate);
				}
			}
		}
		return expSellingRate;
	}

	public List<String> returnBuyingInterbankSpotRatesFromIDS(String currencyPairForRates) {

		String[] currencyPairForRate = reusable.getStringArray(currencyPairForRates);
		List<String> interBankSpotRate = new ArrayList<String>();
		int k = 0;
		try {
			int size = getTextBuyingInterbankSR().size();
			try {
				for (int i = 0; i < size; i++) {
					String currencyPairFC = getTextCurrencyPairFCBuying().get(i).getAttribute("value");
					if (currencyPairFC.equals(currencyPairForRate[k])) {
						String textSR = getTextBuyingInterbankSR().get(i).getAttribute("value");
						interBankSpotRate.add(textSR);
						k++;
					}

				}
			} catch (ArrayIndexOutOfBoundsException e) {
				test.log(Status.INFO, e.getMessage());
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to find Interbank spot rates of : " + currencyPairForRate[k]);
		}
		return interBankSpotRate;
	}

	public String returnFCINRSellingRatesFromIDS(String FCINRCurrencyPair) {
		int sizeOfCP = getTxtCurrencyPairFCINRSelling().size();
		reusable = new CommonReusableMethods(driver, test);
		String[] cpArr = reusable.getStringArray(FCINRCurrencyPair);
		int j = 0;
		String actBankSellingRates = null;
		try {
			for (int i = 0; i < sizeOfCP; i++) {
				String actCurrencyPair = getTxtCurrencyPairFCINRSelling().get(i).getAttribute("value");
				if (actCurrencyPair.equals(cpArr[j])) {
					actBankSellingRates = getTxtBankSellingRate().get(i).getAttribute("value");
					break;
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to find FCINR Selling rates of : " + cpArr[j]);
		}
		return actBankSellingRates;
	}
	
	public String returnFCINRBuyingRatesFromIDS(String FCINRCurrencyPair) {
		int sizeOfCP = getTxtCurrencyPairFCINRBuying().size();
		reusable = new CommonReusableMethods(driver, test);
		String[] cpArr = reusable.getStringArray(FCINRCurrencyPair);
		int j = 0;
		String actBankBuyingRates = null;
		try {
			for (int i = 0; i < sizeOfCP; i++) {
				String actCurrencyPair = getTxtCurrencyPairFCINRBuying().get(i).getAttribute("value");
				if (actCurrencyPair.equals(cpArr[j])) {
					actBankBuyingRates = getTxtBankBuyingRate().get(i).getAttribute("value");
					break;
				}
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to find FCINR Buying rates of : " + cpArr[j]);
		}
		return actBankBuyingRates;
	}

	public void clickBtnFecthRates() {
		getBtnFetchRate().clickByActions();

	}

	public List<String> returnInterbankSellingRatesFCFCFromIDS(String currencyPairForRates) { /// Rajesh
		String[] currencyPairForRate = reusable.getStringArray(currencyPairForRates);
		List<String> interbankRatesFC = new ArrayList<String>();

		int size = getTxtInterbankRateFC().size();
		String currencyPairFCFC = null;
		try {
			for (int i = 0; i < size; i++) {
				String currencyPairFC = getTextCurrencyPairFCBuying().get(i).getAttribute("value");
				for (int j = 0; j < currencyPairForRate.length; j++) {
					currencyPairFCFC = currencyPairForRate[j];
					if (currencyPairFC.equals(currencyPairFCFC)) {
						String text = getTxtInterbankRateFC().get(i).getAttribute("value");
						interbankRatesFC.add(text);
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			test.log(Status.INFO, e.getMessage());
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to find Interbank selling rates of : " + currencyPairFCFC);
		}
		return interbankRatesFC;
	}

	public List<String> returnBuyingInterbankSpotRatesFCFCFromIDS(String currencyPairForRates) {
		String[] currencyPairForRate = reusable.getStringArray(currencyPairForRates);
		List<String> interBankSpotRate = new ArrayList<String>();
		int size = getTextBuyingInterbankSR().size();
		String currencyPairFCFC = null;
		try {
			for (int i = 0; i < size; i++) {
				String currencyPairFC = getTextCurrencyPairFCBuying().get(i).getAttribute("value");
				for (int j = 0; j < currencyPairForRate.length; j++) {
					currencyPairFCFC = currencyPairForRate[j];
					if (currencyPairFC.equals(currencyPairFCFC)) {
						String textSR = getTextBuyingInterbankSR().get(i).getAttribute("value");
						interBankSpotRate.add(textSR);
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			test.log(Status.INFO, e.getMessage());
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to find Buying Interbank spot rates of : " + currencyPairFCFC);
		}
		return interBankSpotRate;

	}

	public void addRateSourceByAutoFetchIfraOrJpmc(String marketType, String isIFRA, String IFRACurrencyPair,
			String isJPMC, String JPMCCurrencyPair) {
		getTabRateSource().clickByJs();
		reusable.selectMarketType(marketType);
		getIconEdit().clickByJs();
		reusable.holdOn(1);
		if (getRadioAutoFetchMode().isChecked()) {
			getRadioBtnAutoFetchMode().clickByActions();
			reusable.holdOn(1);
			getRadioBtnAutoFetchMode().clickByActions();
		} else if (!getRadioAutoFetchMode().isChecked()) {
			getRadioBtnAutoFetchMode().clickByActions();
		}
		if (isIFRA.equals("Yes") && getRadioIFRA().getAttribute("aria-checked").equals("false")) {
			getRadioBtnIFRA().clickByActions();
			getSelectIFRACurrencyPair().clickByJs();
			String[] currencyPair = reusable.getStringArray(IFRACurrencyPair);
			for (int i = 0; i < currencyPair.length; i++) {
				getInputCurrencyPair().type(currencyPair[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
			reusable.holdOn(1);
			getSelectIFRACurrencyPair().clickByJs();
		}
		if (isJPMC.equals("Yes") && !getRadioJPMC().isChecked()) {
			getRadioBtnJPMC().clickByActions();
			getSelectJPMCCurrencyPair().clickByJs();
			String[] currencyPairs = reusable.getStringArray(JPMCCurrencyPair);
			reusable.holdOn(1);
			getInputCurrencyPair().scrollTo();
			reusable.holdOn(1);
			for (int i = 0; i < currencyPairs.length; i++) {
				getInputCurrencyPair().type(currencyPairs[i]);
				reusable.holdOn(1);
				getRadioCurrencyPair().clickByActions();
			}
		}
		if (getRadioManualMode().isChecked()) {
			getRadioManualMode().clickByActions();
		}
		reusable.holdOn(1);
		getBtnUpdate().scrollTo();
		reusable.holdOn(1);
		getBtnUpdate().clickByJs();
	}

	public boolean isNoDecimalLimit(String IFRACurrencyPair) {
		List<String> rates = returnInterbankSellingRatesFromIDS(IFRACurrencyPair);
		boolean IsNoDecimalLimit = false;
		String decimalPattern = "-?\\d*\\.?\\d+";
		for (String rate : rates) {
			IsNoDecimalLimit = rate.matches(decimalPattern);
			Assert.assertTrue(IsNoDecimalLimit, "decimal limit detected for rate: " + rate);

		}
		return IsNoDecimalLimit;
	}

	public float getCashSpotRate() {
		float negativeRates = 0;
		float rates = 0;
		int size = getTextCashSpot().size();
		for (int i = 0; i < size; i++) {
			String txt = getTextCashSpot().get(i).getAttribute("value");
			rates = Float.parseFloat(txt);
			if (rates < 0) {
				negativeRates = rates;
			}
		}
		return negativeRates;
	}

	public void approveOrRejectInputDataSheet(String comments, String approveOrReject, String marketType) {
		getTabInputDataSheet().clickByJs();
		reusable.holdOn(1);
		reusable.selectMarketType(marketType);
		reusable.holdOn(1);
//		getBtnFetchRate().clickByActions();
//		String msg = reusable.toastMessage();
//		if (msg.contains("Rates fetched successfully")) {
//			reusable.holdOn(1);
//			getInputCommentsInputDataSheet().scrollTo();
//		}
		getInputCommentsInputDataSheet().scrollTo();
		reusable.holdOn(1);
		getInputCommentsInputDataSheet().type(comments);
		if (approveOrReject.equalsIgnoreCase("Approve")) {
			getBtnAccept().clickByJs();
			getBtnYes().clickByJs();
		} else if (approveOrReject.equalsIgnoreCase("Reject")) {
			getBtnReject().clickByJs();
			getBtnYes().clickByJs();
		} else {
			test.log(Status.FAIL, "Unable to click on " + approveOrReject + " button.");
		}

	}

	public void clickBtnIDSSubmit() {
		getBtnSubmit().scrollTo();
		reusable.holdOn(1);
		getBtnSubmit().clickByJs();
		reusable.holdOn(1);
		getBtnYes().clickByJs();
	}

}
