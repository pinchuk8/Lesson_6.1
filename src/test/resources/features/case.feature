Feature: CRUD case

  Background:
    Given Page is opened
    And  User is logged in
    And Project is added

  Scenario Outline: Add case
    When case "<case>" with precondition "<precondition>" is created
    Then message is "<visibleText>"
    Examples:
      | case  | precondition  | visibleText        |
      | case1 | precondition1 | Successfully added |

  Scenario Outline: Update case
    When case "<case>" with precondition "<precondition>" is created
    Then message is "<visibleText>"
    Examples:
      | case  | precondition  | visibleText        |
      | case2 | precondition2 | Successfully added |

  Scenario: Delete case
    Then delete case







