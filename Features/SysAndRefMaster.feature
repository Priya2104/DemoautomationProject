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
		  | Lan | LanDes | Hi | 109 | Active |
@CityMasterAdd
Scenario Outline: add new citymaster
  When I click on CITY MASTER
  And I create a new CITY MASTER "<City Code>","<City Name>","<Country Name>","<State Name>","<TimeZone>","<Status>"
  Then I should validate CITY MASTER in the table
  
  Examples:
		  | City Code | City Name | Country Name | State Name | TimeZone | Status |
		  | Cit | CNa | 66 | CS22 |(GMT +5:30) Bombay, Calcutta, Madras, New Delhi | Active |

@AddDGMasterAdd
Scenario Outline: Add new DG master
  When I click on DG MASTER
  And I create a new DG MASTER "<DG class>","<DG Description>","<Status>","<DG Subclass Code>","<DG SubClass Description>","<DGUNDescription>"
  Then I should validate DG MASTER in the table
  
  Examples:
		  | DG class | DG Description | Status |DG Subclass Code | DG SubClass Description | DGUNDescription |
		  | DGCLS1907 | Flammable Solids | Active |DgSc |DGSUBExplosive | UNEXPLOSE|

@PKHD-4840 @PKHD-338_CurrencyMaster @Regression
  Scenario Outline: Create Currency Master
    When User clicks on Masters menu
    And user clicks on Currency Master menu
    Then user navigate to the Currency Page
    When User Provides all the Currency mandatory details as "<Currency Code>","<Currency Name>","<Applicable Countries>","<status>","<Number of decimals>"
    Then User Validate the success message as "Record saved successfully"

    Examples: 
      | Currency Code | Currency Name | Applicable Countries | status   | Number of decimals |
      | ANJ101        | ANJcurrency   | INDIA1,ATLANTICIA    | Active   |                  2 |
      | ANJ102        | Anjcurrency1  | PNG                  | Inactive |                  1 |

  @PKHD-4841 @PKHD-338_View_and_edit_CurrencyMaster @Regression
  Scenario: Search and Edit the Currency Master
    When User clicks on Masters menu
    And user clicks on Currency Master menu
    And User provide Currency Code as "ANJ102" and Currency Name as "Anjcurrency1" and filter the record
    And User update the Currency records with data
      | ANJcurrency09 |
      | ZALAND,CS22   |
      | Active        |
      |             1 |
    Then User Validate the success message as "Record updated successfully"

  #ountry
  @PKHD-4842 @PKHD-339_CountryMaster @Regression
  Scenario Outline: Create Country Master
    When User clicks on Masters menu
    And user clicks on Country Master menu
    Then user navigate to the Country Page
    And User Provides all the Country mandatory details as "<Country Code>","<Country Name>","<ISO1>","<ISO2>","<ISO3>","<Timezone>","<status>"
    Then User Validate the success message as "Record saved successfully, now continue to next step"

    Examples: 
      | Country Code | Country Name | ISO1   | ISO2   | ISO3   | Timezone      | status   |
      | ANJ101       | ANJcountry   | ISO101 | ISO102 | ISO103 | Alaska,Hawaii | Active   |
      | ANJ102       | Anjcountry1  | ISO201 | ISO202 | ISO203 | Taiohae       | Inactive |

  @PKHD-4843 @PKHD-339_View_and_edit_CountryMaster @Regression
  Scenario: Search and Edit the Country Master
    When User clicks on Masters menu
    And user clicks on Country Master menu
    And User provide Country Code as "109" and Country Name as "109" and filter the record
    And User update the Country records with data
      | ANJCountry09 |
      | ISO0001      |
      | ISO0002      |
      | ISO0003      |
      | Eucla        |
      | Active       |
    Then User Validate the success message as "Record updated successfully"

  @PKHD-4845 @PKHD-340_UOMMaster @Regression
  Scenario Outline: Create UOM Master
    When User clicks on Masters menu
    And user clicks on UOM menu
    Then user navigate to the UOM master Page
    And User Provides all the UOM mandatory details as "<Unit of Measure Name>","<Symbol>","<Measurement Unit>","<status>"
    Then User Validate the success message as "Record created successfully"

    Examples: 
      | Unit of Measure Name | Symbol | Measurement Unit | status   |
      | UOMLength            | L_     | Length           | Active   |
      | UOMwheight           | W_     | Weight           | Active   |
      | UOMValume            | V_     | Volume           | Inactive |

  @PKHD-4846 @PKHD-340_View_and_edit_UOMMaster @Regression
  Scenario: Search and Edit the UOM Master
    When User clicks on Masters menu
    And user clicks on UOM menu
    And User provide UOMmeasurecode as "00000000003" and UOMMeasure Name as "UOM-1806" and filter the record
    And User update the UOM records with data
      | UOM_edit_ |
      | U_        |
      | Length    |
      | Inactive  |
    Then User Validate the success message as "Record updated successfully"

  @PKHD-4847 @PKHD-966_SuburbMaster @Regression
  Scenario Outline: Create Suburb Master
    When User clicks on Masters menu
    And user clicks on Suburb menu
    Then user navigate to the Suburb master Page
    And User Provides all the Suburb mandatory details as "<Suburb Code>","<Suburb Name>","<Country>","<State>","<City>","<Postal>","<status>"
    Then User Validate the success message as "Record Saved Successfully!!"

    Examples: 
      | Suburb Code | Suburb Name   | Country | State | City    | Postal | status |
      | Sub09       | suburbmaster1 | PNG     | CS22  | CITY342 | 987677 | Active |

  @PKHD-4848 @PKHD-966_View_and_edit_SuburbMaster @Regression
  Scenario: Search and Edit the Suburb Master
    When User clicks on Masters menu
    And user clicks on Suburb menu
    And User provide Suburbcode as "suburbcode09" and Suburbname as "suburbname09" and filter the record
    And User update the Suburb records with data
      | suburbname0009 |
      | PNG            |
      | CS22           |
      | NC             |
      |          78899 |
      | Active         |
    Then User Validate the success message as "Record Updated Successfully!!"

  @PKHD-507_HTSMaster
  Scenario Outline: Ceate HTS MAster
    When User clicks on Masters menu
    And user clicks on HTS menu
    Then user navigate to the HTS master Page
    And User Provides all the HTS mandatory details as "<HTS Code>","<HTS Description>","<status>"
    Then User Validate the success message as "Record saved successfully, now continue to next step"

    Examples: 
      | HTS Code | HTS Description | status |
      | HTS_     | HTSDes          | Active |

  @PKHD-609_Search_edit_HTS
  Scenario: Search and Edit the Suburb Master
    When User clicks on Masters menu
    And user clicks on HTS menu
    And User provide HTScode as "HTS_DnH" and HTSName as "HTSDes" and filter the record
    And User update the HTS records with data
      | HTS Code        | HTS_ |
      | HTS Description | HTSDes  |
      | status          | Active  |
    Then User Validate the success message as "Record updated successfully!"
    

@StateMasterAdd
Scenario Outline: add new State
  When I click on STATE MASTER
  And I create a new STATE MASTER "<StateCode>","<StateCode>","<CountryAssociated>","<TimeZone>","<Status>"
  Then I should validate STATE MASTER in the table
  
  Examples:
		  | StateCode | StateCode | CountryAssociated | TimeZone | Status |
		  | RGT | RGTSK | 090 |  | Active |		  
		  
		  
		 
		  
		  
		  
