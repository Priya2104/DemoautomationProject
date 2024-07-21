package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import utilities.GenericUtilities;

public class OrganizationHierarchyPage extends BasePage {
	// WebDriverWait wait;
	// WebDriver driver;
	WebDriverWait wait;
	

	MerchandisePage BU_HomePage = new MerchandisePage(BaseClass.getDriver());
	 SystemAndReferenceMasterPage sysandrefmaster = new SystemAndReferenceMasterPage(BaseClass.getDriver());
	public OrganizationHierarchyPage(WebDriver driver) {
		super(driver);
	}

	GenericUtilities utils = new GenericUtilities(driver);
	//Chain
		@FindBy(xpath="//span[.='Organization Hierarchy']") 
		WebElement Organizationhierarchy_menu;
		@FindBy(xpath="(//span[.='Chain'])[2]")
		WebElement chainheader;
		@FindBy(xpath="//span[.='Add Chain']") 
		WebElement addChain_button;
		@FindBy(css="input#name") 
		WebElement chainname_click;
		@FindBy(css="div#alternateHierarchy") 
		WebElement AlternativeHierarchy_click;
		
		
		@FindBy(xpath = "//input[@type='text'][@role='searchbox']")
		WebElement coutryinput;
		
		@FindBy(css="li#alternateHierarchy_0") 
		WebElement arganizationoption_click;
		@FindBy(css="div#currencyList") 
		WebElement Currency_click;
		@FindBy(css="li#currencyList_0")
		WebElement currencyoption_click;
		@FindBy(css="div.p-multiselect-items-wrapper ul  span.ng-star-inserted")
		List<WebElement> multiOrganization_option;
		@FindBy(css="div#area") WebElement Area_select;
		
		//Range
		
		@FindBy(xpath="//span[.='Region']") 
		WebElement Regioncubmenu;
		@FindBy(xpath="//span[.='Add Region']") 
		WebElement addRegionButton_Click;
		@FindBy(css="li#area_0") 
		WebElement areaOption_select;
		@FindBy(css="input#regionName") 
		WebElement regionname;
		//Area
		@FindBy(xpath="//span[.='Area']") 
		WebElement Areasubmenu;
		@FindBy(xpath="//span[.='Add Area']") 
		WebElement AddAreaButton_click;
		@FindBy(css="div#chain")
		WebElement ChainSelec_click;
		@FindBy(css="li#chain_0")
		WebElement chainoption_click;
		@FindBy(css="input#name") 
		WebElement Areaname;
		@FindBy(xpath="(//span[.='Area'])[2]")
		WebElement Areamenuclick;
		//District
			@FindBy(xpath="//span[.='District']") 
			WebElement Districtsubmenu;
			@FindBy(xpath="//span[.='Add District']")
			WebElement AddDistrictname_click;
			@FindBy(css="div#region")
			WebElement Regiondivclick;
			@FindBy(css="li#region_0")
			WebElement Areaoptionclick;
			@FindBy(css="input#districtName") 
			WebElement Districtname;
	@FindBy(xpath="((//td[@id='row.id'])[1]/div/p-button)[1]")
			WebElement thredots_click;


		
		
   //
		public void addRegionButton_Click() {
			utils.explicit_Wait(Regioncubmenu, 200);
			utils.clickElement_using_Size("//span[.='Region']", Regioncubmenu);
			utils.explicit_Wait(addRegionButton_Click, 200);
			utils.clickElement_using_Size("//span[.='Add Region']", addRegionButton_Click);
		}
		
		public void provide_Range_Values(String Areaname,String RegionName,String Alternativehierarchy,String curencny,String status) {
			
			 utils.coutry_Select(Area_select, Areaname, coutryinput, areaOption_select, 120);
		    utils.sendkeys_ele(regionname, RegionName, 120);
		    utils.multi_Select(AlternativeHierarchy_click, Alternativehierarchy,  multiOrganization_option, 120);
		    utils.coutry_Select(Currency_click, curencny, coutryinput, currencyoption_click, 120);
		   
		    status_Options(status,sysandrefmaster.status_click);
		   validateCancel_Save();
			
	}
		
		public void OrganozationHierarchyMenu_Click() {
			utils.explicit_Wait(Organizationhierarchy_menu, 120);
		    utils.clickElement_using_Size("//span[.='Organization Hierarchy']", Organizationhierarchy_menu);
			
		}
		
		public void addOrHierarchy_button_Click() {
			utils.getSuccessmsg(chainheader);
			
			utils.explicit_Wait(addChain_button, 120);
		    utils.clickElement_using_Size("//span[.='Add Chain']", addChain_button);
		    
		    
		   
		}
		
		public void provide_Chain_Values(String ChainName,String Alternativehierarchy,String curencny,String status) {
			    utils.sendkeys_ele(chainname_click, ChainName, 120);
			    utils.multi_Select(AlternativeHierarchy_click, Alternativehierarchy,  multiOrganization_option, 120);
			    utils.coutry_Select(Currency_click, curencny, coutryinput, currencyoption_click, 120);
			   
			    status_Options(status,sysandrefmaster.status_click);
			   validateCancel_Save();
				
		}
		
		/*
		
		public void provide_Chaindetails_forSearchField(String chainname) {

			utils.waitScreen(3000);
			if(chainname.startsWith("chainname")) {
			chainheader.click();
			}
			utils.waitScreen(1000);
			utils.range_Search_Filter_Select(sysandrefmaster.SearchCurrencyName, chainname);
			sysandrefmaster.validatetherecord_Ele();

			utils.edit_Click(sysandrefmaster.threedots, sysandrefmaster.edit);
}

*/

		
		public void provide_Regiondetails_forSearchField(String chainname) {

			utils.waitScreen(3000);
			chainheader.click();
			utils.waitScreen(1000);
			utils.range_Search_Filter_Select(sysandrefmaster.SearchCurrencyName, chainname);
			sysandrefmaster.validatetherecord_Ele();

			utils.edit_Click(sysandrefmaster.threedots, sysandrefmaster.edit);



		}
		public void provide_Rangedetails_forSearchField(String rangename) {

			utils.waitScreen(3000);
			chainheader.click();
			utils.waitScreen(1000);
			utils.range_Search_Filter_Select(sysandrefmaster.SearchCurrencyName, rangename);
			sysandrefmaster.validatetherecord_Ele();

			utils.edit_Click(sysandrefmaster.threedots, sysandrefmaster.edit);



		}
		public void validateCancel_Save() {
			utils.clickElementWithJavaScript1(sysandrefmaster.CXancelButton);
			String getCancelText = utils.getSuccessmsg(sysandrefmaster.CancelText);
			System.out.println(getCancelText);
			utils.clickElementWithJavaScript1(sysandrefmaster.CancelNo);
			utils.clickElementWithJavaScript1(sysandrefmaster.saveButton_);
		}

		//Area
		
		public void addAreaButton_Click() {
			utils.explicit_Wait(Areasubmenu, 200);
			utils.clickElement_using_Size("//span[.='Area']", Areasubmenu);
			utils.explicit_Wait(AddAreaButton_click, 200);
			utils.clickElement_using_Size("//span[.='Add Area']", AddAreaButton_click);
		}
		
		public void provide_Area_Values(String Chainname,String AreaName,String Alternativehierarchy,String curencny,String status) {
			
			 utils.coutry_Select(ChainSelec_click, Chainname, coutryinput, chainoption_click, 120);
		    utils.sendkeys_ele(Areaname, AreaName, 120);
		    utils.multi_Select(AlternativeHierarchy_click, Alternativehierarchy,  multiOrganization_option, 120);
		    utils.coutry_Select(Currency_click, curencny, coutryinput, currencyoption_click, 120);
		   
		    status_Options(status,sysandrefmaster.status_click);
		   validateCancel_Save();
			
	}
		
		
		public void addDistrictButton_Click() {
			utils.explicit_Wait(Districtsubmenu, 200);
			utils.clickElement_using_Size("//span[.='District']", Districtsubmenu);
			utils.explicit_Wait(AddDistrictname_click, 200);
			utils.clickElement_using_Size("//span[.='Add District']", AddDistrictname_click);
		}
		
		public void provide_District_Values(String Regionname,String DistrictName,String Alternativehierarchy,String curencny,String status) {
			
			 utils.coutry_Select(Regiondivclick, Regionname, coutryinput, Areaoptionclick, 120);
		    utils.sendkeys_ele(Districtname, DistrictName, 120);
		    utils.multi_Select(AlternativeHierarchy_click, Alternativehierarchy,  multiOrganization_option, 120);
		    utils.coutry_Select(Currency_click, curencny, coutryinput, currencyoption_click, 120);
		   
		    status_Options(status,sysandrefmaster.status_click);
		   validateCancel_Save();
			
	}
	public void provide_Chaindetails_forSearchField(String chainname) {

			utils.waitScreen(3000);
			if(chainname.startsWith("chainname")) {
			chainheader.click();
			}
			if(chainname.startsWith("Areaname")) {
				Areamenuclick.click();
			}
			utils.waitScreen(1000);
			utils.range_Search_Filter_Select(sysandrefmaster.SearchCurrencyName, chainname);
			sysandrefmaster.validatetherecord_Ele();

			utils.edit_Click(thredots_click, sysandrefmaster.edit);



		}

		public void status_Options(String status, WebElement statusele) {
			utils.explicit_Wait(statusele, 100);
			utils.clickElementWithJavaScript1(statusele);
			for (WebElement sta : sysandrefmaster.statusoptions) {
				if (sta.getText().equalsIgnoreCase(status)) {
					sta.click();
					break;
				}
			}
		}


	
	
	}