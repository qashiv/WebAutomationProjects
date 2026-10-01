package com.E2logy.gfhotel.ChecklistPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.E2logy.gfhotel.common.pages.CommonPage;
import com.E2logy.gfhotel.utilities.WebUtil;

public class CheckListPage extends ChecklistPageOR {

	WebUtil ut;
	private WebElement staticDropdown;
	
	public CheckListPage(WebUtil ut) {
		super(ut);
		this.ut = ut;
	}

	public void clickAddChecklistButton() {
		ut.click(getAddChecklistBT());
	}

	public void clickRoomButton() {
		ut.click(getRoomBT());
	}

	public void clickGuestRoomPreventativeLink() {
		ut.click(getGuestroompreLK());
	}

	public void clickStatrtInspectionButton() {
		ut.click(getStartinspectionBT());
	}

	public void addingChecklist(String checklist, String selectProperty, String zone) {
		CommonPage cmp = new CommonPage(ut);
		
		cmp.goToCheckList();
		clickAddChecklistButton();
		ut.sendKeys(checklistName, checklist);
		cmp.selectDropdown(selectProperty, selectProperty); 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmp.selectDropdown(selectZone, zone);
		ut.click(clickOnAddButton);
		ut.click(staticDropdown);
	}
	
	public void openchecklistByName(String checklistName) {
		List<WebElement> Checklists = getChecklists();		
	}

	public void AddCategoryAndTask(String category, String task) {
		CommonPage cmp = new CommonPage(ut);
		cmp.goToCheckList();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ut.click(clickOnInfoUser);
		ut.sendKeys(enterCategory, category);
		ut.sendKeys(enterTask, task);;
		
	}
	
	public void clickOnActiveToggle() {
		
		CommonPage cmp = new CommonPage(ut);
		cmp.goToCheckList();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ut.click(clickOnInfoUser);
		ut.threadWait(2000);
		ut.click(clickOnActiveStatus);
		ut.click(clickOnUpdateBT);
	}
	
	public void clickOnUpdateButton() {
		ut.click(clickOnUpdateBT);
	}
	

	public void clickOnPerformButton() {
		ut.click(clickOnPerformBT);
	}
	
	public void validateTheCategoeryAndTaskName() {
	CommonPage cmp = new CommonPage(ut);
	boolean bol =	cmp.selectDropdown(selectBT, "myWork");
	Assert.assertEquals(bol, true);
	}
	
	public void validateActiveChecklist() {
		CommonPage cmp = new CommonPage(ut);
		boolean bol =	cmp.selectDropdown(selectProperty, "");
		
	}
	
	public void importTemplates(String str) {
		CommonPage cmp = new CommonPage(ut);
		ut.click(clickImportTemplates);
		cmp.selectDropdown(selectBT, str);
		ut.click(clickOnContinue);
		
	}
	
	public void checkListFilterList() {
		CommonPage cmp = new CommonPage(ut);
		cmp.goToCheckList();
		ut.click(addFilter);
		cmp.selectDropdown(selectProperty, "Buffalo Niagara Marriott");
		cmp.selectDropdown(selectZone, "Room");
		ut.click(searchButton);
		
	}
	
}
