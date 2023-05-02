@HomePage
Feature: Validate Home Page is complete and Navigation tabs are working
 
Background:
Given Application Homepage is open

@TC_HP_001
Scenario: To Verify Image Carousel Contains Services button and redirects to Services Page
 Given User clicks on the Services Button from the Image carousel
 Then Verify if "Services" Page is displayed
 
@TC_HP_002
Scenario Outline: To Verify A Certain Section is Displayed on Home Page
Given On Homepage verify if <Section> is Diplayed
Examples:
|Section|
|"Who We Are"|
|"Case Studies"|
|"Upcoming Events"|
|"Partnerships"|

@TC_HP_007
Scenario Outline: Verify Top Header Contains Required Navigation Tabs
Given On Homepage verify if <Tabs> is present in Header
|About|
|Our Approach|
|Our Team|
|Careers|
|Blog|
|Contact|
|Newsroom|

@TC_HP_008
Scenario Outline: To Verify User is redirected to the Related page after clicking on a Navigation Tab
Given User clicks on a <Navigation Tab> in the top header
Then Verify if Related Page is displayed
Examples:
|Navigation Tab|
|"Careers"|
|"Blog"|


@TC_HP_015 @Test
Scenario: To Verify User is redirected to Facebook after clicking on Facebook button in Home Page Footer
Given User clicks on "Facebook" icon in the footer
Then Verify if new tab or window opens up with the related social account

@Test
Scenario: To Verify User is redirected to Twitter after clicking on Twitter button in Home Page Footer
Given User clicks on "Twitter" icon in the footer
Then Verify if new tab or window opens up with the related social account

@Test
Scenario: To Verify User is redirected to LinkedIn after clicking on LinkedIn button in Home Page Footer
Given User clicks on "LinkedIn" icon in the footer
Then Verify if new tab or window opens up with the related social account
