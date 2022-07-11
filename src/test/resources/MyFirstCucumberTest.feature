Feature: My first cucumber feature

  Scenario: User can see correct title Google
    Given user navigates to 'https://www.google.lv/'
    Then user sees page title 'Google'

  Scenario: User can see correct title LU
    Given user navigates to 'https://www.lu.lv/'
    Then user sees page title 'Latvijas Universitāte'

  Scenario: User can see correct title RTU
    Given user navigates to 'https://www.rtu.lv/'
    Then user sees page title 'Rīgas Tehniskā universitāte | Inženierzinātņu centrs Baltijā'

#  Scenario: User can login with correct username/password
#    Given user is navigated to saucelabs page
#    When user enters 'standard_user' and 'secret_sauce'
#    And user clicks login button
#    Then user sees inventory page