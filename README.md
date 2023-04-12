# **Personal Project**

## *Budget Tracker*

### What will the application do?
- The user can make **categories of expenses** that they want to keep track of. Examples- rent, grocery, books, tuition, miscellaneous. 
- The user can **keep record of money earned**. 
- The user can **track money owed** to other people.
- The user can **track the total savings** made.

### Who will use it?
- Students
- People working 
- Anyone who wants to be more mindful of their finances.

### Why is this project of interest to you?
Ever since I started university and a part time job, keeping track of my finances has become both an important, yet incredibly tedious job.
An application that would summarize all my financial information, savings and keep track of money owed to friends and family would be 
beneficial to me and to other students. 

### User Stories
- *As a user, I want to be able to create and add a transaction (gain or expenditure) to my tracker.*
- *As a user, I want to be able to view my past transactions.*
- *As a user, I want to be shown my current balance.*
- *As a user, I want to be able to view only my expenditure history.*
- *As a user, I want to be able to view only my earning history.*
- *As a user, I want to be able to quit the FinancialTracker and leave*
- *As a user, I want my transactions and history to be saved when I leave, if I choose to.*
- *As a user, I want to be able to given the option to load my past transactions from file.*
### User Stories Achieved in Phase 1
- *Users are able to add these transactions to their accounts*
- *Users are able to view their balance*
- *Users are able to view only their expenditure history*
- *Users are able to view only their earning history*
- *Users are able to quit the Financial Tracker and leave*
- 
### User Stories Achieved in Phase 2
- *As a user, I want my transactions and history to be saved when I leave, if I choose to.*
- *As a user, I want to be able to given the option to load my past transactions from file.*


### User Stories Achieved in Phase 3
- *As a user, I want my transactions and history to be saved when I leave, if I choose to.*
- *As a user, I want to be able to given the option to load my past transactions from file.*
- *As a user, I can add new transactions*
- *As a user, I can view all my past transactions.*
- *As a user, I can filter my transactions based on type*
- *As a user, I can view my current balance.*
- *GUI based UI*

### Phase 3 Instructions for Grader ###

- You can generate the first required action related to adding Xs to a Y by clicking on add Transactions button.
- You can generate the second required action related to adding Xs to a Y by filtering transactions by transaction type.
- You can view a panel of all the X added to Y, by clicking on the History button which shows all previous transactions.
- You can locate my visual component by looking at my buffered image which appears as the application loads.
- You can save the state of my application by clicking on the save button.
- You can reload the state of my application by entering yes when prompted to load or not at the start of the application.
### Resources Used
Teller App was used as a reference point to build UI.
Serialization Demo App was used as reference to build data persistence

MIT edu - Visual Guide to Swing Components
https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

Oracle Java Documentation
https://docs.oracle.com/middleware/1212/jdev/OJDUG/java_swing.htm#OJDUG6949

### Phase 4: Task 2
#### Example of a log that the application may print:

Mon Apr 10 13:02:50 PDT 2023
New Transaction books added.

Mon Apr 10 13:02:52 PDT 2023
User viewed past transaction history.

Mon Apr 10 13:02:54 PDT 2023
User viewed past earnings history.

Mon Apr 10 13:02:54 PDT 2023
User viewed past expense history.

Process finished with exit code 0

### Note: 
For task 2 in Phase 4, when the user opts to load their previous data, 
 the log at the end will print out all transactions added by all users because they all use the addTransaction method. 
Instructors confirmed that this was okay. 

### Phase 4: Task 3
I would create an abstract class for my graphics.
My graphics classes are basically responsible for 
constructing an extra panel and showing particular
data on it. While there are a few differences 
between Transaction Graphics, History Graphics and 
Filtered History Graphics, there are a few similarities
too. First of all, all of them have a field of type 
Account. All of them have common methods concerning 
appearance and set up. I believe it would prevent
code duplication and create better cohesion and 
coupling for me to create an Abstract class like 
"Component Graphics" that has a field of Type Account. 
Additionally, the class could contain common methods such as setAppearance 
(which sets up the graphics in positions). The graphics classes can provide their 
own implementations for these methods too if required.
