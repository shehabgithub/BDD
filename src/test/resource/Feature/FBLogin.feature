Feature: Facebook login

#Scenario: Valid username and invalid password to login

#	Given user at facebook home page
#	When user enter username "shehab.sydney@gmail.com"	
#	And user enter password "132457896"
#	And user click in the login button
#	Then user see error message
#	Then user see error message
	 
	
	@Smoke
	Scenario Outline: "<testname>"
	
	Given user at facebook home page
	When user enter username "<username>"
	And user enter password "<password>"
	And user click in login button
	Then user see error message "<expectederror>" "<actualerrorlocator>"
	
	Examples:
	
	|testname           							|username					|password			|expectederror																			 		|actualerrorlocator	|
	|ivalid user name and invalid password			|shehab1.sydney@gmail.com	|123459879          |The password you’ve entered is incorrect. Forgot Password? 								 	|actualerrormsg		|
	|invalid username and invalid password			|sehab.sydney@gmail.com		|12345689			|The email or phone number you’ve entered doesn’t match any account. Sign up for an account. 	|actualerrormsg		|
	|empty username and valid password				|							|adferwwsf			|The email or phone number you’ve entered doesn’t match any account. Sign up for an account. 	|actualerrormsg		|
	
	
	 