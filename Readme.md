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


FOR CODE：

Also need run gym.sql before test the code, We have saved all the user data in mysql, so not run gym.sql will get an error when you test main.java to create or enter the account 
