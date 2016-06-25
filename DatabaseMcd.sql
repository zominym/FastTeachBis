/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  18/05/2016 11:07:53                      */
/*==============================================================*/


set foreign_key_checks = 0;

drop table if exists ACTION;

drop table if exists USER;

drop table if exists CALENDAR;

drop table if exists GAME_MISSIONS;

drop table if exists OBJECTIVE_ACTIONS;

drop table if exists COEFFICIENT;

drop table if exists GAME;

drop table if exists MISSION;

drop table if exists OBJECTIVE;

drop table if exists RESULT;

drop table if exists TRAINING_GROUP;

drop table if exists REGISTRATION;

set foreign_key_checks = 1;

/*==============================================================*/
/* Table : ACTION                                               */
/*==============================================================*/
create table ACTION
(
   ACTION_ID            int not null,
   SUCCESSOR        int,
   LIBACTION            char(25),
   SCOREMIN             int,
   primary key (ACTION_ID)
);

/*==============================================================*/
/* Table : USER                                            */
/*==============================================================*/
create table USER
(
   USER_ID         int not null,
   SURNAME         char(25),
   NAME       char(25),
   MAIL       char(50),
   PASS       char(25),
   ROLE       char(25),
   primary key (USER_ID)
);

/*==============================================================*/
/* Table : CALENDAR                                           */
/*==============================================================*/
create table CALENDAR
(
   DAYDATE             date not null,
   primary key (DAYDATE)
);

/*==============================================================*/
/* Table : GAME_MISSIONS                                             */
/*==============================================================*/
create table GAME_MISSIONS
(
   GAME_ID              int not null,
   MISSION_ID           int not null,
   primary key (GAME_ID, MISSION_ID)
);

/*==============================================================*/
/* Table : OBJECTIVE_ACTIONS                                          */
/*==============================================================*/
create table OBJECTIVE_ACTIONS
(
   ACTION_ID            int not null,
   OBJECTIVE_ID         int not null,
   primary key (ACTION_ID, OBJECTIVE_ID)
);

/*==============================================================*/
/* Table : COEFFICIENT                                           */
/*==============================================================*/
create table COEFFICIENT
(
   COEFFICIENT_ID             int not null,
   ACTION_ID            int not null,
   INDIC_LABEL             char(20),
   WEIGHT                int,
   primary key (COEFFICIENT_ID)
);

/*==============================================================*/
/* Table : GAME                                                  */
/*==============================================================*/
create table GAME
(
   GAME_ID               int not null,
   GAME_LABEL           char(25),
   primary key (GAME_ID)
);

/*==============================================================*/
/* Table : MISSION                                              */
/*==============================================================*/
create table MISSION
(
   MISSION_ID           int not null,
   MISSION_LABEL           char(25),
   primary key (MISSION_ID)
);

/*==============================================================*/
/* Table : OBJECTIVE                                             */
/*==============================================================*/
create table OBJECTIVE
(
   OBJECTIVE_ID         int not null,
   MISSION_ID           int not null,
   OBECTIF_LABEL           char(25),
   TOTAL_SCORE_MIN      int,
   primary key (OBJECTIVE_ID)
);

/*==============================================================*/
/* Table : RESULT                                              */
/*==============================================================*/
create table RESULT
(
   DAYDATE             date not null,
   REGISTRATION_ID           int not null,
   SCORE                int,
   primary key (DAYDATE, REGISTRATION_ID)
);

/*==============================================================*/
/* Table : TRAINING_GROUP                                              */
/*==============================================================*/
create table TRAINING_GROUP
(
   TRAINER_ID           int not null,
   TRAINEE_ID             int not null,
   primary key (TRAINER_ID, TRAINEE_ID)
);


/*==============================================================*/
/* Table : REGISTRATION                                              */
/*==============================================================*/
create table REGISTRATION
(
   REGISTRATION_ID      int not null,
   GAME_ID          int not null,
   TRAINEE_ID             int not null,
   primary key (REGISTRATION_ID)
);

alter table ACTION add constraint FK_ACTION_SUCCESSOR foreign key (SUCCESSOR)
      references ACTION (ACTION_ID) on delete restrict on update restrict;

alter table GAME_MISSIONS add constraint FK_GAME_MISSIONS_GAME_ID foreign key (GAME_ID)
      references GAME (GAME_ID) on delete restrict on update restrict;

alter table GAME_MISSIONS add constraint FK_GAME_MISSIONS_MISSION_ID foreign key (MISSION_ID)
      references MISSION (MISSION_ID) on delete restrict on update restrict;

alter table OBJECTIVE_ACTIONS add constraint FK_OBJECTIVE_ACTIONS_ACTION_ID foreign key (ACTION_ID)
      references ACTION (ACTION_ID) on delete restrict on update restrict;

alter table OBJECTIVE_ACTIONS add constraint FK_OBJECTIVE_ACTIONS_OBJECTIVE_ID foreign key (OBJECTIVE_ID)
      references OBJECTIVE (OBJECTIVE_ID) on delete restrict on update restrict;

alter table COEFFICIENT add constraint FK_COEFFICIENT_ACTION_ID foreign key (ACTION_ID)
      references ACTION (ACTION_ID) on delete restrict on update restrict;

alter table OBJECTIVE add constraint FK_OBJECTIVE_MISSION_ID foreign key (MISSION_ID)
      references MISSION (MISSION_ID) on delete restrict on update restrict;

alter table RESULT add constraint FK_RESULT_DAYDATE foreign key (DAYDATE)
      references CALENDAR (DAYDATE) on delete restrict on update restrict;

alter table RESULT add constraint FK_RESULT_REGISTRATION_ID foreign key (REGISTRATION_ID)
      references REGISTRATION (REGISTRATION_ID) on delete restrict on update restrict;

alter table TRAINING_GROUP add constraint FK_TRAINING_GROUP_TRAINER_ID foreign key (TRAINER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table TRAINING_GROUP add constraint FK_TRAINING_GROUP_TRAINEE_ID foreign key (TRAINEE_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table USER add constraint U_MAIL unique (MAIL);

alter table REGISTRATION add constraint FK_REGISTRATION_GAME_ID foreign key (GAME_ID)
      references GAME (GAME_ID) on delete restrict on update restrict;

alter table REGISTRATION add constraint FK_REGISTRATION_TRAINEE_ID foreign key (TRAINEE_ID)
      references USER (USER_ID) on delete restrict on update restrict;