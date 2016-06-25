/*==============================================================*/
/* Table : ACTION                                               */
/*==============================================================*/
insert into ACTION values (1, null, "Attacher ceinture", 10);
insert into ACTION values (2, 1, "Demarrer", 10);
insert into ACTION values (3, 2, "Traverser une piste", 10);
insert into ACTION values (4, 2, "Passer sous un avion", 5);
insert into ACTION values (5, 2, "Garer le vehicule", 9);
insert into ACTION values (6, 2, "Suivre ligne", 10);



/*==============================================================*/
/* Table : USER                                            */
/*==============================================================*/
insert into USER values (1, "Learner", "Marc", "marc.zominy@etu.univ-lyon1.fr", "PASS1", "TRAINEE");
insert into USER values (2, "Learner", "Sydney", "sydney.gael@etu.univ-lyon1.fr", "PASS2", "TRAINEE");
insert into USER values (3, "Learner", "Bastien", "bastien.guyl@etu.univ-lyon1.fr", "PASS3", "TRAINEE");
insert into USER values (4, "Learner", "Alexis", "alexis.rabilloud@etu.univ-lyon1.fr", "PASS4", "TRAINEE");
insert into USER values (5, "Learner", "Datcu", "thomas.datcu@etu.univ-lyon1.fr", "PASS5", "TRAINEE");
insert into USER values (6, "naitsirhC", "laiV", "chris.vial@univ-lyon1.fr", "PASS6", "TRAINER");
insert into USER values (7, "Christian", "Vial", "christian.vial@univ-lyon1.fr", "PASS7", "TRAINER");
insert into USER values (8, "Emmanuel", "Perrin", "manu.perrin@univ-lyon1.fr", "PASS8", "ADMIN");



/*==============================================================*/
/* Table : CALENDAR                                           */
/*==============================================================*/
insert into CALENDAR values (CURRENT_DATE); -- curdate() getdate()?



/*==============================================================*/
/* Table : GAME                                                  */
/*==============================================================*/
insert into GAME values(1, "bases vehicule");
insert into GAME values(2, "bases conduite");



/*==============================================================*/
/* Table : MISSION                                              */
/*==============================================================*/
insert into MISSION values(1, "demarrage");
insert into MISSION values(2, "prise en main");
insert into MISSION values(3, "controle");
insert into MISSION values(4, "manoeuvres");



/*==============================================================*/
/* Table : GAME_MISSIONS                                             */
/*==============================================================*/
insert into GAME_MISSIONS values(1, 1);
insert into GAME_MISSIONS values(1, 2);
insert into GAME_MISSIONS values(2, 3);
insert into GAME_MISSIONS values(2, 4);



/*==============================================================*/
/* Table : OBJECTIVE                                             */
/*==============================================================*/
insert into OBJECTIVE values(1, 1, "demarrage 20", 20);
insert into OBJECTIVE values(2, 1, "demarrage 10", 10);
insert into OBJECTIVE values(3, 2, "prise en main 20", 20);
insert into OBJECTIVE values(4, 3, "controle 20", 20);
insert into OBJECTIVE values(5, 4, "manoeuvres 10", 10);



/*==============================================================*/
/* Table : OBJECTIVE_ACTIONS                                          */
/*==============================================================*/
insert into OBJECTIVE_ACTIONS values(1, 1);
insert into OBJECTIVE_ACTIONS values(2, 1);
insert into OBJECTIVE_ACTIONS values(1, 2);
insert into OBJECTIVE_ACTIONS values(2, 2);
insert into OBJECTIVE_ACTIONS values(6, 3);
insert into OBJECTIVE_ACTIONS values(3, 4);
insert into OBJECTIVE_ACTIONS values(4, 4);
insert into OBJECTIVE_ACTIONS values(5, 5);



/*==============================================================*/
/* Table : REGISTATION                                              */
/*==============================================================*/
insert into REGISTRATION values(1, 1, 1);
insert into REGISTRATION values(2, 1, 2);
insert into REGISTRATION values(3, 1, 3);
insert into REGISTRATION values(4, 1, 4);
insert into REGISTRATION values(5, 2, 1);
insert into REGISTRATION values(6, 2, 2);



/*==============================================================*/
/* Table : RESULT                                              */
/*==============================================================*/
insert into RESULT values(current_date, 1, 200);
insert into RESULT values(current_date, 2, 100);
insert into RESULT values(current_date, 3, 0);
insert into RESULT values(current_date, 4, 150);
insert into RESULT values(current_date, 5, 200);




/*==============================================================*/
/* Table : COEFFICIENT                                           */
/*==============================================================*/
insert into COEFFICIENT values(1, 1, "Attacher ceinture", 2);
insert into COEFFICIENT values(2, 2, "Demarrer", 1);
insert into COEFFICIENT values(3, 3, "Traverser Piste", 3);
insert into COEFFICIENT values(4, 4, "Passer sous avion", 2);
insert into COEFFICIENT values(5, 5, "Se garer", 1);
insert into COEFFICIENT values(6, 6, "Suivre ligne", 1);




/*==============================================================*/
/* Table : TRAINING_GROUP                                           */
/*==============================================================*/
insert into TRAINING_GROUP values(6, 1);
insert into TRAINING_GROUP values(6, 2);
insert into TRAINING_GROUP values(6, 3);
insert into TRAINING_GROUP values(7, 4);
insert into TRAINING_GROUP values(7, 5);