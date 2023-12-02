 @e2e
Feature: Admin Creates Room
  Background: Sign in
    Given Admin visits url "https://medunna.com"
    When click on users button
    And click on Sign in button
    And enter username into Username Field
    And enter password into Password Field
    And click on Sign In submit button

  Scenario: Room Creation
    When click on items&Titles button

