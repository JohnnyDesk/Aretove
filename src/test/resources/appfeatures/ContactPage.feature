Feature: To Validate Contact Us Page is Displayed and User is able to submit contact information

Background:
Given Application Homepage is open and user clicks on Contact option in the top header

@TC_CP_001
Scenario: To Verify application behaviour upon giving letters as input in Phone field of Contact form
Given User Clicks on Pune Office Tab
And User enters First Name
And User enters Email
And User enter Message 
And User Enters their Phone Number as 9009a09009
When User Clicks on Submit
Then Verify if User gets an error message