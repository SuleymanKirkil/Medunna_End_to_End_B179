 @e2e
Feature: Admin Creates Room
  Background: Sign in
    Given Admin visits url "https://medunna.com"
    When click on users button
    And click on Sign in button
    And enter username into Username Field
    And enter password into Password Field
    And click on Sign In submit button

  Scenario Outline: Room Creation
    When click on items&Titles button
    And  click on Room button
    And click on Create new Room button
    And enter room number into Room Number field
    And select SUITE option from room type dropdown
    And select status box
    And enter "<price>" into Price field
    And enter "<description>" into Description field
    And click Save submit button

    Examples:
    | price | description   |
    | 210   | Batch 179    |



