Feature: Gradle-Cucumber integration

  Scenario: Gradle reports 'BUILD FAILED' when Cucumber test fails
    Given "Manjyot" use Cucumber Main class to run tests
    When I run failing test
    Then Gradle should report "BUILD FAILED"


