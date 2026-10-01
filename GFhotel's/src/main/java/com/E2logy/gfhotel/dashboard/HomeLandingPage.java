package com.E2logy.gfhotel.dashboard;



import com.E2logy.gfhotel.utilities.WebUtil;

public class HomeLandingPage extends HomeLandingPageOR {

	private WebUtil wt;// null

	public HomeLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;

	}

//	public String getwelcomeText() {
//		String text = wt.MyGetText(welcometext);
//         
//		return text;
//	}

	public void clickOnGFBotIcon() {
		
		wt.click(gfBotIcon);
		
	}
	
	public void clickOnRecentDailyLogViewMoreLink() {
		wt.click(RecentDailyLogViewMoreLink);
	}
	
	
	public void validateTheSelectProperties(String elementName) {
		wt.click(clickOnProperties);
		for(int i=0; i<selectTheProperties.size();i++) {
			
			if(i==3) {
				wt.verifyTextContains(selectTheProperties.get(i).getText(), elementName);
				selectTheProperties.get(3).click();
				break;
			}
		}
		}
		
		public void clickOnSelectProperties() {
			wt.click(clickOnProperties);
		
			for(int i=0; i<selectTheProperties.size();i++) {
				
				if(i==2) {
					selectTheProperties.get(i).click();
					break;
				}
			}}
			
			public void clickOnRecentInspectionsViewMoreLink() {
				wt.click(RecentInspectionViewMoreLink);
			}
		
			public int countOfRecentInspectenlist() {
				int count= elementUnderRecentInspections.size();
				return count;
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

