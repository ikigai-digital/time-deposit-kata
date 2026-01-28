# Time Deposit Refactoring Kata
## XA bank time deposit

It's unfortunate that the junior developer has left the company without handing his work over to anyone. And what is even more unfortunate is that you have been assigned to take over the code that he left behind. 

We were only able to salvage a portion of the business requirements. It is possible that there are some features that the user has requested and are already implemented in the code but not documented.

Part 1:
Refactoring TimeDeposit & TimeDepositCalculator
- The system should calculate the monthly interest based on the account type.
- No interest will be added to any time deposit plans for the first 30 days. 
- There are 3 types of time deposit plans available within the bank: basic, student, and premium
  - basic plan: 1%
  - student plan: 3%
  - premium plan: 5%
- Aside from the premium plan, which follows an auto-renewal strategy, all existing time deposit plans should be terminated after 1 year. After the plan is terminated, the balance of the time deposit account should become 0 as the funds will automatically be transferred to their savings account. 

We would like you to refactor the solution and ensure that the implementation meets all of the above requirements. Since the code is already running in production and no bugs have been reported regarding this feature, you can assume that all existing functionalities are implemented correctly. Please ensure that no existing functionalities are broken.

Limitations: 
- You may not modify the TimeDeposit class
- You may not modify the calculateInterest method signature

The TimeDeposit class contains all the necessary information to evaluate the applicable interest rate. If additional criteria are to be considered, we expect them to be added to the TimeDeposit class.
Do keep one thing in mind, we expect the criterias in evaluating the interest rate to become extremely complicated as the product grow down the line, so please be sure your design is extensible.

Part 2:
Debugging and improvement for TimeDepositService & TimeDepositStore
- The code is part of a large system in Production where GET and UPDATE operations in TimeDepositService are exposed via a REST API to serve mobile apps and web pages
- The calculateInterestForAll() method is triggered monthly via a scheduled job to process interest for all time deposits
- We received a report that balances were not calculated correctly for a small number of records across all deposit types. The TimeDepositCalculator code has been reviewed and the calculation logic is correct. Please suggest an approach to identify the root cause and, if possible, implement a fix.
- We are expanding our business to other countries and need to support multiple currencies for TimeDeposit accounts. We have a common Money class that stores both amount and currency denomination. Please update the TimeDeposit class to use this new Money type for its balance field.


PS: For the sake of time, you should assume that all inputs are valid. Please treat this as an actual assignment on the project and apply all the best practices that you know of. 
