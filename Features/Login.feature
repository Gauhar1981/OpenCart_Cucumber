Feature: Login with valid credentials

  @Sanity @Regression
  Scenario: Successful login with valid credentials
  Given user navigates to login page
  When user enter email as  "test@test.com" and password as "test0522"
  And user clicks on Login button
  Then user should navigate to MyAccount page
  #@Regression
  #Scenario Outline: Data Driver Login
    #Given user navigates to login page
    #When user enter  email as "<email>" and password as "<password>"
    #And user clicks on Login button
    #Then user should navigate to MyAccount page
#
    #Examples: 
      #| email            | password  |
      #| test123@test.com | Test11122 |
      #| test05@gmail.com | test05    |
      #| test@test.com    | test0522  |
