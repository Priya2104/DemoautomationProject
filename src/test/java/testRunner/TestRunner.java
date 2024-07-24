package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.PropertiesReader;
import utilities.UploadToXray;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {".//Features"},
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:reports/myreport.html", "rerun:target/rerun.txt","json:Report/cucumber/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        publish = false,
        

        //tags = "@ClassErrorMessage or @BUErrorMessage or @DivisionErrorMessage or @GropuErrorMessage or @DepartmentErrorMessage or @SubClassErrorMessage"
        //tags ="@BusinesUnitSetUpPage or @GroupSetupHierarchy or @ClassSetupHierarchy or  @DepartmentSetupHierarchy or @SubClassSetupHierarchy or @DivisionSetupHierarchy"
		 // tags="@LanguageMasterAdd"
        //tags="@LogoMasterMobile or  @LogoMasterDesktop or  @LogoMasterDesktopError or @LogoMasterMobileError or @LanguageMasterAdd"
		 //tags="@PKHD-338_View_and_edit_CurrencyMaster"
        // tags="@BUMandatoryFieldEmptyError or @DivisionErrorMessage or @GropuErrorMessage or @DepartmentErrorMessage or @ClassErrorMessage or @SubClassErrorMessage"
               	 
        //
      //tags="@PKHD-251 or @MerchendiseSetupMerx or @BUMandatoryFieldEmptyError or @DivisionErrorMessage or @GropuErrorMessage or @DepartmentErrorMessage or @ClassErrorMessage or @SubClassErrorMessage or @LogoMasterDesktop or @LogoMasterMobile or @LogoMasterDesktopError or @LogoMasterMobileError or @LanguageMasterAdd or @CityMasterAdd or @AddDGMasterAdd or @PKHD-338_CurrencyMaster or @PKHD-338_View_and_edit_CurrencyMaster or @PKHD-4842 or @PKHD-339_CountryMaster or @PKHD-4843 or @PKHD-4845 or @PKHD-4846 or @PKHD-4847 or @PKHD-4848 or @PKHD-507_HTSMaster or @PKHD-609_Search_edit_HTS or @StateMasterAdd or @BusinesUnitSetUpPage or @DivisionSetupHierarchy or @GroupSetupHierarchy or @DepartmentSetupHierarchy or @ClassSetupHierarchy or @SubClassSetupHierarchy or @TransferZoneAdd or @VATRegionMaster or @VATMaster or @DiffType or @DiffValue or @DiffRange or @ChainSetup or @RegionSetup or @AreaSetup or @DistrictSetup or @ReportingCategory or @ItemTypeSettingTest or @alternateHierarchy "
       //tags="@BusinesUnitSetUpPage or @DivisionSetupHierarchy or @GroupSetupHierarchy or @DepartmentSetupHierarchy or @ClassSetupHierarchy or @SubClassSetupHierarchy"
        //tags="@ReportingCategory or @ItemTypeSettingTest or @alternateHierarchy"
        tags="@VMI-Consignment"
        
		)
public class TestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
        
       

   
    }
    
//	String Config_filePath ="src/test/resources/config.properties";
//	PropertiesReader config = new PropertiesReader(Config_filePath);
//    
//	@AfterClass
//	public void tearDown() throws Exception {
//		
//		//BaseClass.quitDriver();
//		// Xray running 
//		if(config.getProperty("upload_toXray").contains("Yes"))
//        {
//            UploadToXray xray = new UploadToXray();
//            xray.RemonteResultats();
//        }else
//        {
//            System.out.print("Ignored Xray");
//        }
//	}
}