@ApiTest
Feature: Manage Pets

  Scenario: Add a pet
    In order to sell a pet
    As a store owner
    I want to add a new pet to the catalog

    Given I have the following pet
      | name     | id | status    |
      | teo      |  1 | available |
      | firulais |  2 | available |
      | lucas    |  3 | available |
    When I add the pet to the store
    Then the pet should be available in the store

  Scenario: Delete a pet
    In order to update my catalog
    As a store owner
    I want to delete a pet from the catalog

    Given I have the following pet
      | name  | id |
      | lucas |  3 |
    When I delete the pet from the store
    Then the pet should not be available in the store
