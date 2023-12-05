@e2e @database
Feature:Admin validates room creation by DB
  Scenario: Database Created Room Validation
    Given Admin create connection to DB
    When execute query for the room
    Then validates room creation from result set
