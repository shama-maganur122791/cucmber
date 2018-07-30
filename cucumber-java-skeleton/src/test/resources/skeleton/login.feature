Feature: Login Feature
Background:
Given The url of the application

@UI
Scenario: Valid User
When user enters mercury as username
And user enters mercury as password
And user clicks on submit
Then user is valid
@UI
Scenario: Invalid User
When user enters abc as username
And user enters abc as password
And user clicks on submit
Then user is in valid
