@e2e @api
Feature: Api created Room Validation
  Scenario: Api Get Rooms
    Given Admin send Get request for all Rooms
    Then Verify body for the create room
