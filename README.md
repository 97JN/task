# task

H2 configuration : <br><br>

Driver Class:	 org.h2.Driver <br>
JDBC URL: jdbc:h2:mem:task <br>
User Name:	intern <br>
Password:	intern <br><br>

after running application if u want to see whats in database go to: http://localhost:8081/h2-console <br><br>

to test app we have some inserts in import.sql file, if you want to test endpoints that allows you to reserve lectures you have to leave it as it is, if you want to test some Get methods like get all users or generate reports you can switch commented lines in this file to have more data to see better results. For now we have empty database with only lectures and conferences with no users. <br><br>


About application:<br>
- i used String insted of date beacuse H2 database converted time to UTC no matter if i switched it to UTC+2 in application.yml or patterns <br>
- i understood that we dont need to register user or create hes account, just put some username and email to get reservation on selected lecture<br>
- user can sign to only 1 lecture during conference with username and login, but for example:<br>
we want so sign for conference 1 and conference 2, after time we want to get sign for third conferece but if someone was first by giving same username but different email in that third conference we cant sign using that username becasue its already taken, so its work like: first come first served.<br><br>


here's enpoints with example request:<br><br>

@Get<br>
get conference plan<br>
http://localhost:8081/api/conferences<br><br>

@Get<br>
get all participants in conferences<br>
http://localhost:8081/api/conferences/allUsers<br><br>

@Get<br>
get all lectures for user<br>
http://localhost:8081/api/reserve/user/lectures<br><br>

@Get<br>
reports by conferences<br>
http://localhost:8081/api/report/interest<br><br>

@Get<br>
reports by lectures<br>
http://localhost:8081/api/report/conference<br><br>

@Delete<br>
cancel reservation<br>
http://localhost:8081/api/reserve/cancel/{username}/reservation/{reservatinId}<br><br>

@Post<br>
reserve lecture by username and password<br>
http://localhost:8081/api/reserve/{conferenceId}/set/{lectureId}<br><br>

example request body:<br>
{<br>
    "username":"user",<br>
    "email":"user@gmail.com"<br>
}<br><br>

@Post<br>
change email<br>
http://localhost:8081/api/changer<br><br>

example request body<br>
{<br>
    "username":"user1",<br>
    "email":"user1@gmail.com",<br>
    "newEmail":"user@wp.pl"<br>
}<br>







