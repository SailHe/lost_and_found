/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/6 23:08:55                           */
/*==============================================================*/


drop table if exists laf_item;

drop table if exists laf_message;

drop table if exists laf_return_log;

drop table if exists sys_user;

/*==============================================================*/
/* Table: laf_item                                              */
/*==============================================================*/
create table laf_item
(
   item_id              int not null auto_increment,
   item_name            varchar(25),
   item_desc            varchar(500),
   item_pick_up_time    datetime,
   create_time          datetime default CURRENT_TIMESTAMP,
   edit_time            datetime default CURRENT_TIMESTAMP,
   primary key (item_id)
);

alter table laf_item comment 'lost and found item table';

/*==============================================================*/
/* Table: laf_message                                           */
/*==============================================================*/
create table laf_message
(
   message_id           int not null auto_increment,
   user_id              int comment 'user primary key',
   item_id              int,
   message_desc         varchar(500),
   msg_img_urls         varchar(500) comment 'a url list with scroll img url or single',
   message_type         tinyint,
   create_time          datetime default CURRENT_TIMESTAMP,
   edit_time            datetime default CURRENT_TIMESTAMP,
   primary key (message_id)
);

alter table laf_message comment 'lost and found message table';

/*==============================================================*/
/* Table: laf_return_log                                        */
/*==============================================================*/
create table laf_return_log
(
   return_id            int not null auto_increment,
   piker_user_id        int comment 'user primary key',
   owner_user_id        int comment 'user primary key',
   item_id              int,
   return_img_url       varchar(50) comment 'evidence img',
   create_time          datetime default CURRENT_TIMESTAMP,
   edit_time            datetime default CURRENT_TIMESTAMP,
   primary key (return_id)
);

alter table laf_return_log comment 'lost and found return log table';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int not null auto_increment comment 'user primary key',
   user_username        varchar(50) comment 'unique',
   user_password        varchar(50),
   user_realname        varchar(50),
   user_nickname        varchar(50),
   user_avatar_url      varchar(128),
   user_email_address   varchar(50) comment 'For registration',
   user_contact_way     varchar(50) comment 'Some other contact methods, such as phone, QQ',
   user_sex             varchar(4),
   user_birthday        date,
   user_role            tinyint comment 'Decision authority, Related to permissions',
   user_token           varchar(255),
   user_sign_in_ip      varchar(20),
   user_sign_in_time    datetime,
   create_time          datetime default CURRENT_TIMESTAMP,
   edit_time            datetime default CURRENT_TIMESTAMP,
   primary key (user_id)
);

alter table sys_user comment 'user table';

alter table laf_message add constraint FK_associate_item foreign key (item_id)
      references laf_item (item_id) on delete cascade on update cascade;

alter table laf_message add constraint FK_publisher foreign key (user_id)
      references sys_user (user_id) on delete cascade on update cascade;

alter table laf_return_log add constraint FK_owner foreign key (owner_user_id)
      references sys_user (user_id) on delete cascade on update cascade;

alter table laf_return_log add constraint FK_picker foreign key (piker_user_id)
      references sys_user (user_id) on delete cascade on update cascade;

alter table laf_return_log add constraint FK_return_item foreign key (item_id)
      references laf_item (item_id) on delete cascade on update cascade;

