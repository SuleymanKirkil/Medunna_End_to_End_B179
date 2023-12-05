@e2e @api
  Feature: Specific Room Validation
    Scenario: Room Validation By Get With IdOfRoom
      Given Admin send Get request for created room by its Id
      Then validates body for created room
