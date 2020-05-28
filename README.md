# anagram-application

## Steps to run:
1. Clone the project
2. Make sure you have docker installed on the machine you are running
3. Run the command: 
	
	```
		docker-compose up
	```
	
4. You will be able to see the logs which says the apllication is running on your local host on port 8080
5. On the browser you can hit the following apis:

	*	https://localhost:8080/&lt; string1 &gt;/&lt; string2 &gt; ---> To check if string string1 and string2 are anagrams
	*	https://localhost:8080/&lt; string1 &gt;           ---> To return list of anagrams of string1
