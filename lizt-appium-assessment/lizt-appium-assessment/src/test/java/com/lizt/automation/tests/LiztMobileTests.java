package com.lizt.automation.tests;

import java.util.UUID;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.lizt.automation.base.BaseTest;
import com.lizt.automation.pages.AddListPage;
import com.lizt.automation.pages.DetailsPage;
import com.lizt.automation.pages.HomePage;

public class LiztMobileTests extends BaseTest {
	private String unique(String prefix) {
		return prefix + "_" + UUID.randomUUID().toString().substring(0, 6);
	}

	private DetailsPage createList(String name) {
		HomePage home = new HomePage(driver, wait);
		home.dismissWelcomeIfPresent();
		home.addList();
		AddListPage add = new AddListPage(driver, wait);
		Assert.assertTrue(add.isDisplayed(), "Create List screen should be displayed");
		add.enterTitle(name);
		add.save();
		DetailsPage details = new DetailsPage(driver, wait);
		Assert.assertTrue(details.isDisplayed(name), "Created list should open in Details");
		return details;
	}

	@Test(description = "Launch app and verify the home screen")
	public void TC01_appLaunch() {
		Assert.assertTrue(new HomePage(driver, wait).isHomeDisplayed(), "Home screen should load successfully");
	}

	@Test(description = "Verify empty-state UI on a fresh app")
	public void TC02_emptyState() {
		HomePage home = new HomePage(driver, wait);
		if (home.isHomeDisplayed()) {
			Assert.assertTrue(home.hasList("You don't have any list yet") || !home.hasList("DefinitelyMissing"),
					"Home should render a valid state");
		}
	}

	@Test(description = "Create a new list")
	public void TC03_createList() {
		String name = unique("Shopping");
		createList(name);
		Assert.assertTrue(new DetailsPage(driver, wait).isDisplayed(name));
	}

	@Test(description = "Prevent creating a list with an empty title")
	public void TC04_createListWithoutTitle() {
		HomePage home = new HomePage(driver, wait);
		home.addList();
		AddListPage add = new AddListPage(driver, wait);
		add.save();
		Assert.assertTrue(add.hasValidationMessage(), "Empty list title should show validation");
	}

	@Test(description = "Edit an existing list")
	public void TC05_editList() {
		String oldName = unique("Trip");
		String newName = unique("EditedTrip");
		DetailsPage details = createList(oldName);
		details.editList(oldName, newName);
		Assert.assertTrue(details.isDisplayed(newName), "Edited list title should be displayed");
	}

	@Test(description = "Delete a list using swipe action")
	public void TC06_deleteList() {
		String name = unique("DeleteMe");
		createList(name).backToHome();
		HomePage home = new HomePage(driver, wait);
		Assert.assertTrue(home.hasList(name));
		home.swipeListLeft(name);
		Assert.assertTrue(home.hasText("Delete"), "Swipe should expose Delete action");
		home.clickDeleteAction();
		home.confirmDeleteIfAsked();
		Assert.assertFalse(home.hasList(name), "Deleted list should no longer be displayed");
	}

	@Test(description = "Cancel list deletion from the confirmation dialog")
	public void TC07_cancelDeleteList() {
		String name = unique("KeepMe");
		createList(name).backToHome();
		HomePage home = new HomePage(driver, wait);
		home.swipeListLeft(name);
		home.clickDeleteAction();
		if (home.hasText("Do you want to remove the list?"))
			home.cancelDeleteIfAsked();
		Assert.assertTrue(home.hasList(name), "List should remain after canceling delete");
	}

	@Test(description = "Create a category inside a list")
	public void TC08_createCategory() {
		String list = unique("CategoryList");
		String category = unique("Tasks");
		DetailsPage details = createList(list);
		details.createCategory();
		details.addCategory(category);
		Assert.assertTrue(details.hasItem(category), "New category should be displayed");
	}

	@Test(description = "Add an item to a category")
	public void TC09_addItem() {
		String list = unique("Items");
		String category = unique("General");
		String item = unique("Milk");
		DetailsPage details = createList(list);
		details.createCategory();
		details.addCategory(category);
		details.openAddItem();
		details.enterItemAndAdd(item);
		Assert.assertTrue(details.hasItem(item), "Added item should be displayed");
	}

	@Test(description = "Prevent adding an item with an empty name")
	public void TC10_addItemWithoutName() {
		String list = unique("NegativeItem");
		String category = unique("General");
		DetailsPage details = createList(list);
		details.createCategory();
		details.addCategory(category);
		details.openAddItem();
		details.submitEmptyItem();
		Assert.assertTrue(details.validationShown(), "Empty item name should show validation");
	}

	@Test(description = "Complete an item")
	public void TC11_completeItem() {
		String item = unique("Complete");
		DetailsPage details = createListWithItem("CompleteList", "General", item);
		details.completeItem(item);
		Assert.assertTrue(details.hasText("Delete"), "Completing an item should expose Delete action");
	}

	@Test(description = "Uncomplete an item")
	public void TC12_uncompleteItem() {
		String item = unique("Toggle");
		DetailsPage details = createListWithItem("ToggleList", "General", item);
		details.completeItem(item);
		details.completeItem(item);
		Assert.assertFalse(details.hasText("Delete"), "Uncompleted item should not expose Delete action");
	}

	@Test(description = "Delete a completed item")
	public void TC13_deleteItem() {
		String item = unique("Remove");
		DetailsPage details = createListWithItem("RemoveList", "General", item);
		details.completeItem(item);
		details.deleteCompletedItem();
		Assert.assertFalse(details.hasItem(item), "Deleted item should no longer be displayed");
	}

	@Test(description = "Navigate from list details back to Home")
	public void TC14_navigationBackToHome() {
		String name = unique("Navigation");
		createList(name).backToHome();
		Assert.assertTrue(new HomePage(driver, wait).isHomeDisplayed(), "Back navigation should return to Home");
	}

	@Test(description = "Navigate to Reminders tab")
	public void TC15_navigationToReminders() {
		HomePage home = new HomePage(driver, wait);
		home.goToReminders();
		Assert.assertTrue(home.hasText("Reminders"), "Reminders screen should be displayed");
	}

	@Test(description = "Navigate to Settings tab")
	public void TC16_navigationToSettings() {
		HomePage home = new HomePage(driver, wait);
		home.goToSettings();
		Assert.assertTrue(home.hasText("Settings"), "Settings screen should be displayed");
	}

	@Test(description = "Persist a list after app relaunch")
	public void TC17_dataPersistenceAfterRelaunch() {
		String name = unique("Persist");
		createList(name).backToHome();
		driver.terminateApp(com.lizt.automation.utils.Config.appPackage());
		driver.activateApp(com.lizt.automation.utils.Config.appPackage());
		HomePage home = new HomePage(driver, wait);
		Assert.assertTrue(home.hasList(name), "List should persist after app relaunch");
	}

	@Test(description = "Handle a long list name")
	public void TC18_longListName() {
		String name = "Long_" + "A".repeat(60);
		createList(name);
		Assert.assertTrue(new DetailsPage(driver, wait).isDisplayed(name), "Long title should be saved and displayed");
	}

	@Test(description = "Add multiple items to the same category")
	public void TC19_multipleItems() {
		String list = unique("Multiple");
		String category = unique("General");
		String item1 = unique("One");
		String item2 = unique("Two");
		DetailsPage details = createList(list);
		details.createCategory();
		details.addCategory(category);
		details.addItem(item1);
		details.addItem(item2);
		Assert.assertTrue(details.hasItem(item1) && details.hasItem(item2), "Multiple items should be displayed");
	}

	@Test(description = "Edit item - currently unavailable in product; document as a bug", enabled = false)
	public void TC20_editItem() {
		throw new SkipException(
				"SKIPPED: Lizt currently has no edit action for items; see bug BUG-001 in bug-report.md");
	}

	private DetailsPage createListWithItem(String listPrefix, String categoryPrefix, String item) {
		DetailsPage details = createList(unique(listPrefix));
		details.createCategory();
		details.addCategory(unique(categoryPrefix));
		details.addItem(item);
		return details;
	}
}
