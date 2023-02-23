Feature: Login to the CGI application


Scenario Outline:  User able to login with valid crendtials only

Given Open the application with any browser
And Navigate to the required position of the application
When I enter username as <username> and password as <password> in to the fields
And I clicks on the login button
Then User should see successfull <exceptedstatus> after login
Examples:
|username               |password  |exceptedstatus|
|user1                  |pass1     |fail          |
|user2                  |pass2     |fail          |
|user3                  |pass3     |fail          |
|saipattabhi18@gmail.com|Sai@336699|pass          |