package com.icici.forex.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.icici.forex.or.OthersPageOr;

public class OthersPage extends OthersPageOr {

	CommonReusableMethods reusable;
	ExtentTest test;

	public OthersPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
	}

	public void fillOthersDetailsForIBGCustomer(String entity, String clientNature, String officeAdd,
			String iciciBranch, String listOfCountries, String cpClassification, String cpStatus, String crossDefClause,
			String exportDefClause, String networth, String date, String sourceOfNetworth, String turnover,
			String listingDetails, String noOfAcceptance, String marginRights, String riskPolicy, String vRMscript,
			String clientType, String sME, String internalRating, String externalRating, String typeOfSecurity,
			String docDetails, String selectDoc, String ISDADetails, String FCADetails, String uploadDocPath,
			String docSignedBy, String location, String docStatus, String docAwaited, String commonSeal,
			String safeCustodyMemoNo, String limitOfAuth, String authLevel, String typeOfAuthority,
			String typeOfAuthorisation, String group, String modeOfOperation, String meetingDate, String GSTNumber,
			String GSTAddress, String multiGSTNo, String description, String reasonForBlocking, String inputReason,
			String docStorageLocation, String docSerialNo, String passportNo, String freeTexts) {

		getSelectStatus().clickByJs();
		getOptionActive().clickByJs();
		getSelectEntity().clickByJs();
		reusable.selectFromDropdown(entity);
		getSelectNatureOfClient().clickByJs();
		reusable.selectFromDropdown(clientNature);
		getInputLocalTouch().type("Test");
		getInputDealerName().type("Test");
		getCheckUSD10Mn().check();
		personalDetails(officeAdd, iciciBranch, listOfCountries, cpClassification, cpStatus, crossDefClause,
				exportDefClause, networth, date, sourceOfNetworth, turnover, listingDetails, noOfAcceptance,
				marginRights, riskPolicy, vRMscript, clientType, sME, internalRating, externalRating, typeOfSecurity,
				docDetails, selectDoc, ISDADetails, FCADetails, uploadDocPath, docSignedBy, location, docStatus,
				docAwaited, commonSeal, safeCustodyMemoNo);
		userDetails(limitOfAuth, authLevel, typeOfAuthority, typeOfAuthorisation, group, modeOfOperation, meetingDate,
				GSTNumber, GSTAddress, multiGSTNo, description, reasonForBlocking, inputReason, docStorageLocation,
				docSerialNo, passportNo, freeTexts);

	}

	public void personalDetails(String officeAdd, String iciciBranch, String listOfCountries, String cpClassification,
			String cpStatus, String crossDefClause, String exportDefClause, String networth, String date,
			String sourceOfNetworth, String turnover, String listingDetails, String noOfAcceptance, String marginRights,
			String riskPolicy, String vRMscript, String clientType, String sME, String internalRating,
			String externalRating, String typeOfSecurity, String docDetails, String selectDoc, String ISDADetails,
			String FCADetails, String uploadDocPath, String docSignedBy, String location, String docStatus,
			String docAwaited, String commonSeal, String safeCustodyMemoNo) {

		reusable = new CommonReusableMethods(getDriver(), test);
		reusable.holdOn(1);
		getSelectNatureOfClient().clickByJs();
		getInputSearch().type("Private Limited");
		getOptions().get(0).clickByActions();
		getInputRegOfficeAddress().type(officeAdd);
		getSelectICICIBank().clickByJs();
		reusable.selectFromDropdown(iciciBranch);
		getSelectCPClassification().clickByJs();
		reusable.selectFromDropdown(cpClassification);
		getSelectCounterpartyStatus().clickByJs();
		reusable.selectFromDropdown(cpStatus);
		getSelectCrossDefaultClause().clickByJs();
		reusable.selectFromDropdown(crossDefClause);
		getSelectExportDefaultClause().clickByJs();
		reusable.selectFromDropdown(exportDefClause);
		getInputNetworth().type(networth);
		getBtnDateOfNetworth().clickByJs();
		reusable.holdOn(1);
		reusable.selectDateFromCalendar(date);
		getInputSourceOfNetworth().type(sourceOfNetworth);
		getInputTurnover().type(turnover);
		getSelectListingDetails().clickByJs();
		reusable.selectFromDropdown(listingDetails);
		getSelectNoOfAcceptance().clickByJs();
		reusable.selectFromDropdown(noOfAcceptance);
		getSelectMarginRights().clickByJs();
		reusable.selectFromDropdown(marginRights);
		getSelectRiskManagePolicy().clickByJs();
		reusable.selectFromDropdown(riskPolicy);
		getSelectVRMScript().clickByJs();
		reusable.selectFromDropdown(vRMscript);
		getSelectClientType().scrollTo();
		reusable.holdOn(1);
		getSelectClientType().clickByJs();
		reusable.selectFromDropdown(clientType);
		getSelectSME().clickByJs();
		reusable.selectFromDropdown(sME);
		getSelectInternalRating().clickByJs();
		getInputSearch().type(internalRating);
		reusable.holdOn(1);
		reusable.selectFromDropdown(internalRating);
		getSelectExternalRating().clickByJs();
		getInputSearch().type(externalRating);
		reusable.selectFromDropdown(externalRating);
		getSelectTypeOfSecurity().clickByJs();
		reusable.selectFromDropdown(typeOfSecurity);
		getSelectDocumentDetails().clickByJs();
		reusable.selectFromDropdown(docDetails);
		reusable.holdOn(1);
		getExpandDocModule().clickByJs();
		getSelectSelectDocument().clickByJs();
		reusable.selectFromDropdown(selectDoc);
		getSelectISDADetailsRequired().clickByJs();
		reusable.selectFromDropdown(ISDADetails);
		getSelectFCADetailsRequired().clickByJs();
		reusable.selectFromDropdown(FCADetails);
		reusable.holdOn(1);
		getSelectUploadDocs().attachFile(uploadDocPath);
		getInputDocSignedBy().type(docSignedBy);
		getInputLocation().type(location);
		getSelectStatusOfDocs().clickByJs();
		reusable.selectFromDropdown(docStatus);
		getInputDocumentAwaited().type(externalRating);
		getSelectCommonSeal().clickByJs();
		reusable.selectFromDropdown(commonSeal);
		getInputSafeCustodyMemoNo().type(safeCustodyMemoNo);

	}

	public void userDetails(String limitOfAuth, String authLevel, String typeOfAuthority, String typeOfAuthorisation,
			String group, String modeOfOperation, String meetingDate, String GSTNumber, String GSTAddress,
			String multiGSTNo, String description, String reasonForBlocking, String inputReason,
			String docStorageLocation, String docSerialNo, String passportNo, String freeTexts) {

		reusable = new CommonReusableMethods(getDriver(), test);
		getExpandUserDetails().clickByJs();
		reusable.holdOn(1);
		if (getInputGSTNo().getText().equals("")) {
			getInputGSTNo().type(GSTNumber);
		}
		if (getInputGSTAddress().getText().equals("")) {
			getInputGSTAddress().type(GSTAddress);
		}
		getToggleGSTStatus().clickByJs();
		getSelectMultipleGSTNoRequired().clickByJs();
		reusable.selectFromDropdown(multiGSTNo);
		getInputDescription().type(description);
		getBtnLEIExpiry().clickByJs();
		reusable.holdOn(1);
		getBtnCalendarArrow().clickByJs();
		getClickYear().clickByJs();
		getClickMonth().clickByJs();
		getClickDate().clickByJs();
		if (getSelectedReasonForBlocking().getText().equals("Select")) {
			getSelectReasonForBlocking().clickByJs();
			reusable.selectFromDropdown(reasonForBlocking);
		}
		if (getSelectedReasonForBlocking().getAttribute("title").equals("Other")) {
			reusable.holdOn(1);
			getInputReasonForBlocking().type(inputReason);
		}
		getSelectDocStorageLocation().clickByJs();
		reusable.selectFromDropdown(docStorageLocation);
		getSelectDocSerialNo().clickByJs();
		reusable.selectFromDropdown(docSerialNo);
		getInputPassportNumCard().type(passportNo);
		for (int i = 0; i < getInputFreeTexts().size(); i++) {
			getInputFreeTexts().get(i).type(freeTexts);
		}
	}

	public void submit() {
		reusable = new CommonReusableMethods(driver, test);
		getBtnSubmit().scrollTo();
		reusable.holdOn(1);
		getBtnSubmit().clickByActions();
	}

	public void back() {
		getBtnBack().clickByJs();
	}

	public void openOthersPageByTab() {
		reusable = new CommonReusableMethods(driver, test);
		try {
			getTabOthers().clickByActions();
		} catch (ElementClickInterceptedException e) {
			reusable.holdOn(2);
			getTabOthers().clickByJs();
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed, Unable to clickByJs on Others Tab : " + e.getMessage());
		}
	}
}
