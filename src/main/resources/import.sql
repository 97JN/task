INSERT INTO conference(id, conference_name, start_date, end_date)VALUES (1,'Conference 1','2023-06-01 10:00', '2023-06-01 11:45');
INSERT INTO conference(id, conference_name, start_date, end_date)VALUES (2,'Conference 2','2023-06-01 12:00', '2023-06-01 13:45');
INSERT INTO conference(id, conference_name, start_date, end_date)VALUES (3,'Conference 3','2023-06-01 14:00', '2023-06-01 15:45');

INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (1,'Lecture 1',5,1,1);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (2,'Lecture 2',5,3,1);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (3,'Lecture 3',5,5,1);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (4,'Lecture 4',5,5,2);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (5,'Lecture 5',5,3,2);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (6,'Lecture 6',5,4,2);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (7,'Lecture 7',5,4,3);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (8,'Lecture 8',5,4,3);
INSERT INTO lecture(id, lecture_name, person_limit, person_entries_left, conference_id)VALUES (9,'Lecture 9',5,3,3);

INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (1,'user','user@gmail.com',1,1);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (2,'user','user@gmail.com',2,5);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (3,'user1','user1@gmail.com',1,1);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (4,'eminem','eminem@gmail.com',3,9);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (5,'eminem2','eminemm@gmail.com',1,1);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (6,'tiger','tiger@gmail.com',3,7);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (7,'user','user@gmail.com',3,9);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (8,'user1234','user1234@gmail.com',3,8);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (9,'pooh','pooh@gmail.com',1,2);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (10,'newuser','new@gmail.com',1,1);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (11,'dracula','dracula@gmail.com',1,2);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (12,'darthvader','darthvader@gmail.com',2,6);
INSERT INTO reservation(id, username, email, conference_id, lecture_id)VALUES (13,'obiwan','obiwan@gmail.com',2,5);
