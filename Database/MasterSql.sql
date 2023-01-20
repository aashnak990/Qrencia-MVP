create database qrencia_mvp;

use qrencia_mvp;
create table competitions(id int auto_increment primary key, name varchar(255) unique, mode enum('Online','Offline'), start_date date, end_date date, active_flg enum('Y','N') default 'Y');
create table training_courses(id int auto_increment primary key, name varchar(255) unique,mode enum('Online','Offline'), start_date date, end_date date, active_flg enum('Y','N') default 'Y');
create table candidate(id int auto_increment primary key, name varchar(255), address varchar(255), active_flg enum('Y','N') default 'Y');
create table candidate_competition_mapping(id int auto_increment primary key, candidate_id int, competition_id int, marks double, foreign key(candidate_id) references candidate(id), foreign key(competition_id) references competitions(id));
create table candidate_training_mapping(id int auto_increment primary key, candidate_id int, training_id int, foreign key(candidate_id) references candidate(id), foreign key(training_id) references training_courses(id));
create table feedback (id int auto_increment primary key, comment varchar(255), user_id int, work_id int);