import { Download, FileChooser, Locator, Page, expect } from "@playwright/test";

/**
 * BasePage
 * ----------
 * Common reusable Playwright actions.
 * All page objects should extend this class.
 */
export class BasePage {

    page: Page;

    constructor(page: Page) {
        this.page = page;
    }

    // ===========================
    // Click Operations
    // ===========================

    /**
     * Click on an element.
     */
    async click(locator: Locator): Promise<void> {
        await locator.click();
    }

    /**
     * Double click on an element.
     */
    async doubleClick(locator: Locator): Promise<void> {
        await locator.dblclick();
    }

    async goToURL(url : string): Promise<void>{
        await this.page.goto(url);
    }

    /**
     * Right click on an element.
     */
    async rightClick(locator: Locator): Promise<void> {
        await locator.click({ button: "right" });
    }

    // ===========================
    // Text/Input Operations
    // ===========================

    /**
     * Clear existing value and enter new value.
     */
    async setValue(locator: Locator, value: string): Promise<void> {
        await locator.fill(value);
    }

    /**
     * Type text character by character.
     */
    async typeValue(locator: Locator, value: string): Promise<void> {
        await locator.pressSequentially(value);
    }

    /**
     * Clear input field.
     */
    async clear(locator: Locator): Promise<void> {
        await locator.clear();
    }

    /**
     * Press keyboard key.
     */
    async pressKey(locator: Locator, key: string): Promise<void> {
        await locator.press(key);
    }

    // ===========================
    // Text Retrieval
    // ===========================

    /**
     * Returns text content.
     */
    async getText(locator: Locator): Promise<string> {
        return (await locator.textContent()) ?? "";
    }

    /**
     * Returns visible text.
     */
    async getVisibleText(locator: Locator): Promise<string> {
        return (await locator.innerText()).trim();
    }

    /**
     * Returns all text contents.
     */
    async getAllTexts(locator: Locator): Promise<string[]> {
        return await locator.allTextContents();
    }

    /**
     * Returns all visible texts.
     */
    async getAllVisibleTexts(locator: Locator): Promise<string[]> {
        return await locator.allInnerTexts();
    }

    // ===========================
    // Validation Methods
    // ===========================

    /**
     * Check whether element is visible.
     */
    async isVisible(locator: Locator): Promise<boolean> {
        return await locator.isVisible();
    }

    /**
     * Check whether element is enabled.
     */
    async isEnabled(locator: Locator): Promise<boolean> {
        return await locator.isEnabled();
    }

    /**
     * Check whether checkbox/radio is checked.
     */
    async isChecked(locator: Locator): Promise<boolean> {
        return await locator.isChecked();
    }

    // ===========================
    // Dropdown Operations
    // ===========================

    /**
     * Select dropdown by label.
     */
    async selectOptionByLabel(locator: Locator, optionLabel: string): Promise<void> {
        await locator.selectOption({ label: optionLabel });
    }

    /**
     * Select dropdown by value.
     */
    async selectOptionByValue(locator: Locator, optionValue: string): Promise<void> {
        await locator.selectOption({ value: optionValue });
    }

    /**
     * Select dropdown by index.
     */
    async selectOptionByIndex(locator: Locator, optionIndex: number): Promise<void> {
        await locator.selectOption({ index: optionIndex });
    }

    // ===========================
    // Mouse Operations
    // ===========================

    /**
     * Hover over an element.
     */
    async mouseHover(locator: Locator): Promise<void> {
        await locator.hover();
    }

    /**
     * Drag source element and drop on target.
     */
    async dragAndDrop(source: Locator, target: Locator): Promise<void> {
        await source.dragTo(target);
    }

    // ===========================
    // Page Information
    // ===========================

    /**
     * Returns current page title.
     */
    async getPageTitle(): Promise<string> {
        return await this.page.title();
    }

    /**
     * Returns current page URL.
     */
    async getPageUrl(): Promise<string> {
        return this.page.url();
    }

    // ===========================
    // Attribute Operations
    // ===========================

    /**
     * Returns attribute value.
     */
    async getAttribute(locator: Locator, attributeName: string): Promise<string | null> {
        return await locator.getAttribute(attributeName);
    }

    // ===========================
    // Wait Methods
    // ===========================

    /**
     * Wait until element becomes visible.
     */
    async waitForVisible(locator: Locator): Promise<void> {
        await locator.waitFor({ state: "visible" });
    }

    /**
     * Wait until element is hidden.
     */
    async waitForHidden(locator: Locator): Promise<void> {
        await locator.waitFor({ state: "hidden" });
    }

    /**
     * Wait for page loading to complete.
     */
    async waitForPageLoad(): Promise<void> {
        await this.page.waitForLoadState("networkidle");
    }

    /**
     * Wait for given time.
     * Avoid using this unless absolutely necessary.
     */
    async wait(milliseconds: number): Promise<void> {
        await this.page.waitForTimeout(milliseconds);
    }

    /**
     * Wait for page to load completely.
     * This method waits for the 'load' event to be fired, indicating that the page has fully loaded.
     * It is useful when you want to ensure that all resources on the page have been loaded before proceeding with further actions.
     */
    async waitForLoadState(): Promise<void> {
        await this.page.waitForLoadState('load');
    }

    // ===========================
    // Generic Utility Methods
    // ===========================

    /**
     * Scroll element into view.
     */
    async scrollIntoView(locator: Locator): Promise<void> {
        await locator.scrollIntoViewIfNeeded();
    }

    // Scroll to the top of the page
    async scrollToTop(): Promise<void> {
        await this.page.evaluate(() => {
            window.scrollTo(0, 0);
        });
    } 

    // Scroll to the bottom of the page
    async scrollToBottom(): Promise<void> { 
        await this.page.evaluate(() => {
            window.scrollTo(0, document.body.scrollHeight);
        });
    }

    /**
     * Get number of matching elements.
     */
    async getCount(locator: Locator): Promise<number> {
        return await locator.count();
    }

    /**
     * Take screenshot.
     */
    async takeScreenshot(path: string): Promise<void> {
        await this.page.screenshot({
            path,
            fullPage: true
        });
    }

    /**
     * Refresh browser page.
     */
    async refreshPage(): Promise<void> {
        await this.page.reload();
    }

    /**
     * Navigate back.
     */
    async navigateBack(): Promise<void> {
        await this.page.goBack();
    }

    /**
     * Navigate forward.
     */
    async navigateForward(): Promise<void> {
        await this.page.goForward();
    }

    // ===========================
    // Assertions
    // ===========================

    /**
     * Verify element is visible.
     */
    async verifyVisible(locator: Locator): Promise<void> {
        await expect(locator).toBeVisible();
    }

    async matchText(locator: Locator, expectedText: string): Promise<void> {
        const actualText = await this.getVisibleText(locator);
        if (actualText !== expectedText) {
            throw new Error(`Text mismatch: Expected "${expectedText}", but got "${actualText}"`);
        }else{
            console.log(`Text matched: "${expectedText}"`);
        }
    }

    async splitAndMatchText(locator: Locator, expectedText: string): Promise<void> {
        const actualText = await this.getVisibleText(locator);
        const parts = actualText.split("  ");
        const trimmedParts = parts.map(part => part.trim());
        if (!trimmedParts.includes(expectedText)) {
            throw new Error(`Text mismatch: Expected "${expectedText}" not found in "${actualText}"`);
        }else{
            console.log(`Text matched: "${expectedText}"`);
        }
    }

    async matchStrings(actualString: string, expectedString: string): Promise<void> {
        if (actualString !== expectedString) {
            throw new Error(`Failed, String mismatch: Expected "${expectedString}", but got "${actualString}"`);
        }else{
            console.log(`Passed, String matched: "${expectedString}"`);
        }
    }

    /**
     * Verify element contains expected text.
     */
    async verifyText(locator: Locator, expectedText: string): Promise<void> {
        await expect(locator).toHaveText(expectedText);
    }

    /**
     * Verify page title.
     */
    async verifyTitle(expectedTitle: string): Promise<void> {
        await expect(this.page).toHaveTitle(expectedTitle);
    }

    /**
     * Verify page URL.
     */
    async verifyUrl(expectedUrl: string): Promise<void> {
        await expect(this.page).toHaveURL(expectedUrl);
    }

    /**
     * Get input field value.
     */
    async getInputValue(locator: Locator): Promise<string> {
        return await locator.inputValue();
    }

    // Get selected option text from dropdown
    async getSelectedOption(locator: Locator): Promise<string | null> {
        const selectedOption = await locator.evaluate((select) => {
            const selected = (select as HTMLSelectElement).selectedOptions[0];
            return selected ? selected.textContent : null;
        });
        return selectedOption;
    }

    // Get selected option value from dropdown
    async getSelectedDropdownValue(locator: Locator): Promise<string | null> {
        const selectedValue = await locator.evaluate((select) => {
            const selected = (select as HTMLSelectElement).selectedOptions[0];
            return selected ? selected.value : null;
        });
        return selectedValue;
    }

    // Get all options from dropdown
    async getDropdownOptions(locator: Locator): Promise<string[]> {
        const options = await locator.evaluate((select) => {
            return Array.from((select as HTMLSelectElement).options).map(option => option.textContent || "");
        });
        return options;
    }

    async switchToTab(index: number): Promise<Page> {
        const pages = this.page.context().pages();
        let newPage: Page = pages[index];
        return newPage;
    }

    async switchToLatestTab(): Promise<Page> {
        const pages = this.page.context().pages();
        let latestPage: Page = pages[pages.length - 1];
        return latestPage;
    }

    async closeCurrentTab(): Promise<void> {
        await this.page.close();
    }

    async switchToTabByTitle(title: string): Promise<Page | null> {
        const pages = this.page.context().pages();
        for (const p of pages) {
            const pageTitle = await p.title();
            if (pageTitle === title) {
                return p;
            }
        }
        return null;
    }

    async switchToTabByUrl(url: string): Promise<Page | null> {
        const pages = this.page.context().pages();
        for (const p of pages) {
            const pageUrl = p.url();
            if (pageUrl === url) {
                return p;
            }
        }
        return null;
    }
    /*
    * All the below methods are related to Alert  
    */
    async acceptAlert(): Promise<void> {
        this.page.on('dialog', async dialog => {
            await dialog.accept();
        });
    }

    async dismissAlert(): Promise<void> {
        this.page.on('dialog', async dialog => {
            await dialog.dismiss();
        });
    }

    async getAlertText(): Promise<string> {
        return new Promise((resolve) => {
            this.page.on('dialog', async dialog => {
                resolve(dialog.message());
                await dialog.dismiss();
            });
        });
    }

    async sendAlertText(text: string): Promise<void> {
        this.page.on('dialog', async dialog => {
            await dialog.accept(text);
        });
    }

    async waitForAlert(): Promise<void> {
        await this.page.waitForEvent('dialog');
    }

    async waitForAlertAndAccept(): Promise<void> {
        const dialog = await this.page.waitForEvent('dialog');
        await dialog.accept();
    }

    // file path like- ..\\Files\\Image.jpg or 
    // process.cwd() + "Files\\Image.jpg"  
    // CWD - Current Working Directory 
    async uploadFile(locator: Locator, filePath: string){
        await locator.setInputFiles(filePath);
    }

    async uploadMultipleFiles(locator : Locator, filePath : string[]){
        await locator.setInputFiles(filePath);
    }

    async removeUploadedFiles(locator: Locator){
        await locator.setInputFiles([]);
    }

    async clickAndUploadFile(locator: Locator, filePath: string){
        let fileChooserPromise: Promise<FileChooser> = this.page.waitForEvent("filechooser");
        await locator.click();
        let fileChooser : FileChooser = await fileChooserPromise;
        await fileChooser.setFiles(filePath);
    }

    async clickAndDownloadFile(locator: Locator, filePath: string){
        let fileDownloadPromise: Promise<Download> = this.page.waitForEvent("download");
        await locator.click();
        let download : Download = await fileDownloadPromise;
        await download.saveAs(filePath);
    }

    async closeBrowser(){
        await this.page.close();
    }

}  