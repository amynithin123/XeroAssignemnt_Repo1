Feature: Acceptance testing to validate that a Xero user is able to add a bank account inside any Xero Organisation
  To Validate that a Xero User is able to add a bank account inside any Xero Organisation

  @regression
  Scenario Outline: Validate Xero user is able to login to the Xero Home page when entering valid credentials and add an organisation and bank account successfully
    Given user launches Chrome browser
    When User navigates to "https://www.xero.com/nz/" the Home page
    And User clicks on Login button in the Login page
    And User enters"<email_address>" in the Email address field
    And User enters"<password>" in the Password field
    And User clicks on Login button
    And User clicks on User a backup method instead link and clicks on Security questions icon and answers the security questions and confirm
    Then Validate that user is successfully login to the Xero Home page
    Given user clicks on Demo Company in the Home Page and clicks My Xero link and enters "<business_name>" "<Industry>" "<Country>" to add business
    When User clicks on Accounting  and click Bank Accounts and clicks on Add Bank Account and  selects the "<bank>" and enters the mandatory credentials and clicks continue, bank account will be added successfully

    Examples: 
      | email_address          |  | password      |  | business_name |  | Industry     |  | Country     |   | bank     |
      | amynithin123@gmail.com |  | BALA.mani123! |  | SSS           |  | Stockbroking |  | New Zealand |   | ANZ (NZ) |
