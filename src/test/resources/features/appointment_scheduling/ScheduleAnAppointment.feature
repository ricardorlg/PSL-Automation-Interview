#Author: ricardolarrahondo2@hotmail.com
@Functional_Tests
Feature: Schedule an Appoiment in the system
  As an user I want to have an online form In order to Schedule an Appoiment

  Background: 
    Given the user is in the Schedule Appoinment page

  Scenario: Verifies that the system validates the date field as a mandatory
    When the user does not chooses a date
    And submits the form
    Then the system should show the "missingDateErrorMessage"

  Scenario: Verifies that the system validates the pacient document as a mandatory
    When the user does not types his document
    And submits the form
    Then the system should show the "missingDocumentErrorMessage"

  Scenario: Verifies that the system validates the doctor document as a mandatory
    When the user does not types his doctor document
    And submits the form
    Then the system should show the "missingDocumentErrorMessage"

  Scenario: Verifies the system validates that the appointment date is bigger than the current date
    When the user chooses the current date as an appoiment date
    And submits the form
    Then the system should show the "errorDateValidationMessage"

  Scenario: Verifies the system informs when the user document is not registered in the system
    When the user fills the form but his document is not registered in the system
    And submits the form
    Then the system should show the "pacientDocumentNotRegistered"

  Scenario: Verifies the system informs when the doctor document is not registered in the system
    When the user fills the form but the doctor document is not registered in the system
    And submits the form
    Then the system should show the "doctorDocumentNotRegistered"

  Scenario: Verifies the system shows the information about the appoinment registered
    When the user fills the form with correct information
    And submits the form
    Then the system should show the "appointmenSuccesMessage"
    And the correct information about the appointment
