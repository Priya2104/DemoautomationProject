Feature: Edit Page Functionality

  Background: 
    Given The user navigates to login page of Merx
    When The user login Merx application with email as and password
    And The user clicks on the Sign in button
    And User Can Select Company "DUNNS"
    And Click on merchandise Menu

  @Sanityforedit
  Scenario Outline: Edit BusinessUnit and Verify page details
    When I Create Merchandise data with API request
    Then I will search with Business Unit ID and select Edit
    And I will update the fields "<Business Unit Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated fields.

    Examples: 
      | Business Unit Name | Reporting Category | Alternate Hierarchy | Status |
      |                    | check reference    | sample testing      | Active |

  @Sanityforedit
  Scenario Outline: Edit DivisionUnit and Verify page details
    Then I will search with Division Unit ID and select Edit
    And I will update the Division fields "<Division Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated Division fields.

    Examples: 
      | Division Name | Reporting Category | Alternate Hierarchy | Status |
      |               | check reference    | sample testing      | Active |

  @Sanityforedit
  Scenario Outline: Edit Group and Verify page details
    Then I will search with Group Unit ID and select Edit
    And I will update the Group fields "<Group Name>","<Reporting Category>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated Group fields.

    Examples: 
      | Group Name | Reporting Category | Alternate Hierarchy | Status |
      |            | check reference    | sample testing      | Active |

  @Sanityforedit
  Scenario Outline: Edit Department and Verify page details
    Then I will search with Department Unit ID and select Edit
    And I will update the Department fields "<Department Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated Department fields.

    Examples: 
      | Department Name | Reporting Category | Item Type    | Alternate Hierarchy | Status |
      |                 | check reference    | Gift Regular | sample testing      | Active |

  @Sanityforedit
  Scenario Outline: Edit Class and Verify page details
    Then I will search with Class Unit ID and select Edit
    And I will update the Class fields "<Class Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated Class fields.

    Examples: 
      | Class Name | Reporting Category | Item Type    | Alternate Hierarchy | Status |
      |            | check reference    | Gift Regular | sample testing      | Active |

  @Sanityforedit
  Scenario Outline: Edit Subclass and Verify page details
    Then I will search with Subclass Unit ID and select Edit
    And I will update the Subclass fields "<Subclass Name>","<Reporting Category>","<Item Type>","<Alternate Hierarchy>","<Status>"
    And I will verify the updated Subclass fields.

    Examples: 
      | Subclass Name | Reporting Category | Item Type    | Alternate Hierarchy | Status |
      |               | check reference    | Gift Regular | sample testing      | Active |

  #Delete scenarios
  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Subclass view Page
   # When I Create Merchandise data with API request
    Then I will search with Subclass unit ID
    And I will Delete the record
    And I will verify the deleted Subclass record should not exist in the system

  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Class view Page
    Then I will search with Class unit ID
    And I will Delete the record
    And I will verify the deleted Class record should not exist in the system

  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Department view Page
    Then I will search with Department unit ID
    And I will Delete the record
    And I will verify the deleted Department record should not exist in the system

  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Group view Page
    Then I will search with Group unit ID
    And I will Delete the record
    And I will verify the deleted Group record should not exist in the system

  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Division view Page
    Then I will search with Division unit ID
    And I will Delete the record
    And I will verify the deleted Division record should not exist in the system

  @SanityforDelete
  Scenario: Verify the Successful Deletion from the Business view Page
    Then I will search with Business unit ID
    And I will Delete the record
    And I will verify the deleted BU record should not exist in the system