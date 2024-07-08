@SysAndRefMaster

Feature: Merchandise Business unit view page

  Background:
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "AVENIDA"
    #And Click on merchandise Menu
    #Then The user should be redirected to the Merchandise Page
     
 @LogoMasterDesktop
Scenario: Upload Desktop Logo Image Max Size 5MBand Verify Success
  When I click on Logo Master
  When I upload an image for "Desktop" logo "less than 5MB" "rgba(0, 0, 0, 0.87)"
  Then I should validate upload image "Desktop"
  
   @LogoMasterMobile
Scenario: Upload Mobile Logo Image Max Size 5MBand Verify Success
  When I click on Logo Master
  When I upload an image for "Mobile" logo "less than 5MB" "rgba(0, 0, 0, 0.87)"
  Then I should validate upload image "Mobile"
   @LogoMasterDesktopError
Scenario: Upload Desktop Logo Image Max Size More than 5MB and verify Error.
  When I click on Logo Master
  When I upload an image for "Desktop" logo "more than 5MB" "rgba(244, 67, 54, 1)"
  Then I should validate upload image "Desktop"
  
   @LogoMasterMobileError
Scenario: Upload Desktop Logo Image Max Size More than 5MB and verify Error
  When I click on Logo Master
  When I upload an image for "Mobile" logo "more than 5MB" "rgba(244, 67, 54, 1)"
  Then I should validate upload image "Mobile"
  
   @LanguageMasterAdd
Scenario Outline: add new language
  When I click on LANGUAGE MASTER
  And I create a new LANGUAGE MASTER "<LanguageCode>","<LanguageName>","<LanguageShortName>","<ApplicableCountries>","<Status>"
  Then I should validate LANGUAGE MASTER in the table
  
  Examples:
		  | LanguageCode | LanguageName | LanguageShortName | ApplicableCountries | Status |
		  | Lan | LanDes | Hindi | 91 | Active |
@CityMasterAdd
Scenario Outline: add new citymaster
  When I click on CITY MASTER
  And I create a new CITY MASTER "<City Code>","<City Name>","<Country Name>","<State Name>","<TimeZone>","<Status>"
  Then I should validate CITY MASTER in the table
  
  Examples:
		  | City Code | City Name | Country Name | State Name | TimeZone | Status |
		  | Cit | CNa | 66 | CS22 |(GMT +5:30) Bombay, Calcutta, Madras, New Delhi | Active |