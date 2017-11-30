# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                            integer auto_increment not null,
  title                         varchar(255),
  content                       varchar(255),
  image                         LONGBLOB,
  constraint pk_task primary key (id)
);


# --- !Downs

drop table if exists task;

