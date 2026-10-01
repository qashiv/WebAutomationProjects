package com.E2logy.gfhotel.Inspection.pages;

import com.E2logy.gfhotel.Inspection.pages.or.InspectionLandingPageOR;
import com.E2logy.gfhotel.utilities.WebUtil;

public class InspectionLandingPage extends InspectionLandingPageOR {
	private WebUtil wt;
	public	InspectionLandingPage(WebUtil wu){
		super(wu);
		this.wt=wu;
	}
	
	
	public void clickNoButton() {
		wt.click(getNoBT());
		
	}
	public void clickAddNoteButton() {
		wt.click(getAddnoteBT());
		
	}
	public void clickYesButton() {
		wt.click(getYesBT());
		
	}

	public void checkTankWaterCheckBox() {
		wt.click(getTankwaterCB());

	}
	
	
	public void checkTubDrainCheckBox() {
		wt.click(getTubdrainCB());
	}
	public void checkBathTubCheckBox() {
		wt.click(getBathtubCB());
	}
	
	// LIVING
	
	public void checkRoomSafeCheckBox() {
		wt.click(getRoomsafeCB());
	}
	public void checkSmokedetecterCheckBox() {
		wt.click(getSmokediteCB());
	}
	public void checkAlarmClockCheckBox() {
		wt.click(getAlarmclockCB());
	}
	public void checkTVremoteCheckBox() {
		wt.click(getTvremoteCB());
	}
		
		// hall
		public void checkDoorsLatchCheckBox() {
			wt.click(getDoorsCB());
		}

		// review
		public void clickTimeOut() {
			wt.click(getOuttimeDD());

		}

		public String selectDate() {
			wt.click(getChoosedateBT());
			String dateofinpection = wt.getText(getOuttimeDD());
			return dateofinpection;
		}
		// Validtaion

		public void clickCreatedInspection() {
			wt.click(getInpectionDataINT());
		}
		public void clickTimeOut1() {
			// TODO Auto-generated method stub
			
		}}
