Feature: On Boarding a new Partner

Scenario : Creating a new partner for ART

Given  I open chrome and launch the ART application
I Enter a valid Saudi Phone Number
When I Click on next button
Then Shows the OTP Screen

Scenario Outline : Entering a valid OTP

Given I'M on OTP Page
And I Enter OTP1<otp1> and OTP2<otp2> and OTP<otp3> and OTP4<otp4>
When Click on 'Verify' button
Then should the 'one last feet page'
Examples:
|otp1|otp2|otp3|otp4|
|9|9|9|9|




