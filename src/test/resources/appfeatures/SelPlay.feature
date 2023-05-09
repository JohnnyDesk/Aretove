Feature: This feature contains Selenium Playground Demos

Background: Selenium Playground HomePage is open
Given Browser Navigates to Selenium Playground HomePage

@SingleSelect
Scenario: Single Select Drop Down List Demo
Given User Selects Select Dropdown List Demo on Homepage
Given Select the 3rd value from the list
Then Select "Friday" from the list

@MultiSelect
Scenario: Multi Select Drop Down List Demo
Given User Selects Select Dropdown List Demo on Homepage
Given Select the 2nd value from the multi select list
Then Select "New York" from the multi select list

@WindowHandle
Scenario: Handle Multiple Windows and get their title
Given User Selects Window Popup Modal Demo on 
And User Selects Window Popup Modal Demo on 
Then Switches to every Window and gets their title