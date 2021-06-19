## Task  

Create a sandbox Java banking application that can be used for:  
- Sending money between two predefined accounts with a positive starting balance  
- Requesting account balance and list of transactions  
Requirements for the application:  
- Exposes HTTP / JSON interface for:  
    - sending money between accounts
    - requesting account statement with account balance and list of transactions
- Accounts and transactions are persisted in relational database
- Has one end-to-end test that:
    - Sends money from one account to another
    - Verifies that resulting account balances are correct
- Has README file with instructions how to run it  

## How to run solution
Run ```gradlew bootRun``` from project directory on Windows, or ```.\gradlew bootRun``` on Linux  
- There are 3 predefined wallets 1,2,3 with respective amounts 123,456 and 789
- Make request ```POST http://localhost:8080/transactions``` with JSON body ```{ "from": 1, "to": 2, "amount": "10.0"}``` 
to transfer 10 units from wallet 1 to wallet 2
- Make request ```GET http://localhost:8080/wallets/2/statement``` to check statement for wallet 2