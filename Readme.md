# Gym Management System
For EECS3311 Project  

This is the instructions for using the program

For Using System:

NOTE: if the first run does not work, close the program and run again

You need have java and mysql on your PC First.
Then you need to download gym.sql and run it in mysql to create the database. Use GymManagementSystem.exe to access our system.
If there is an error shows "No JVM could be found on your system. Please define EXE4J_JAVA_HOME". Please downloaded java from https://www.java.com/ and reinstalled once than it should be ran it successfully.
To access Admin account. With account: Admin and password:123456.(You must run gym.sql to access the system,otherwise the system will not support your operation)
If your exe file is stuck in login in, go into your mysql and check the gym Database has been created or not, if not, please run gym.sql again.


For Iteartion2 update: 

We have implemented different user logins and you can register different identities. Different main screens have been designed for each of these different users. We display the user's current login name and identity on the home page. 
For the admin account we can create new courses, modify courses, and delete existing courses, all the options within the "manage course" button. Contrast to Iteartion1, we can now modify the user's identity within the "manage member". Note that when you register a user under the admin account, you need to fill in all the user information, otherwise an error will be reported
For membership account users can change their personal information, select courses, view information about existing coaches and view class schedules.
For coach, front desk, janitorial we have set up an identical interface where you can change your personal information and view work infomation


For Iteartion3 update: 

We have added a manage equipment option on the admin screen.Fixed a few bugs, when a user does not have enough funds, they will be notified that they cannot enroll in a course. Similarly, if a user already has access to a certain course, they will not be able to enroll in that same course again.Reassign all database IDs as a continuous numerical sequence and then add the starting value to the SQL code. This will facilitate easier testing of the database.

FOR CODE：

Before testing the code, please ensure that you have executed the gym.sql file. This is because all user data has been stored in MySQL, and failure to run gym.sql may result in errors when attempting to create or access user accounts through main.java
