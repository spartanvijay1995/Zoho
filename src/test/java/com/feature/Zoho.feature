Feature: Zoho project
Scenario: User go to the Zoho homepage
Given user Launch The Url
When user Click The SignUp Button
And user Enter The EmailId and Password and Login Into The Zoho Acccount
And user Find EmailId and Password Is Not Valid
Then user TakeScreenshot and Saved In The Driver 