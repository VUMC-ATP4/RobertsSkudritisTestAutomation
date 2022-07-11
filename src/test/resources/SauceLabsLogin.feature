Feature: Tests all functionality sauce labs login page
  Scenario: Successful login
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and 'secret_sauce'
    And user clicks login button
    Then user sees inventory page

    Scenario: Users sees error message if username empty
      Given user navigates to 'https://www.saucedemo.com/'
      And user sees page title 'Swag Labs'
      When user enters '' and 'secret_sauce'
      And user clicks login button
      Then user sees error message 'Epic sadface: Username is required'

  Scenario: Users sees error message if password empty
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'standard_user' and ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Password is required'

  Scenario: Users sees error message if wrong credentials
    Given user navigates to 'https://www.saucedemo.com/'
    And user sees page title 'Swag Labs'
    When user enters 'Roberts' and 'Parole'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username and password do not match any user in this service'

#  Scenario: Users sees correct error message
#    Given user navigates to 'https://www.saucedemo.com/'
#    And user sees page title 'Swag Labs'
#    When user enters '<username>' and '<password>'
#    And user clicks login button
#    Then user sees error message '<error_message>'
#    Examples:
#    |username|password|error_message|
