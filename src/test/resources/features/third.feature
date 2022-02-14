Feature: более сложный тест
  Background:
    Given открыт браузер
    * страница логина открыта

  Scenario: Использование AND в Given
   Given  User logged in

  Scenario: Простой тест со всеми ключевыми словами
    Then Username field is displayed