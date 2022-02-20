Feature: CRUD milestones

  Background:
    Given page is opened
    And  user is logged in
    And project is added

  Scenario: CRUD
    Given milestone "abc" with description "xwz"
    Then milestone is added
    Given update milestone "cba" with description "zwz"
    Then milestone is update
    Then delete milestone