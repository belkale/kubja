CREATE TABLE `users` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `firstname` varchar(255) default NULL,
  `lastname` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `dob` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `enabled` bit(1) default NULL,
  `authStr` varchar(255) default NULL,
  `street` varchar(255) default NULL,
  `city` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `country` varchar(255) default NULL,
  `zipcode` varchar(255) default NULL,
  PRIMARY KEY  (`login`)
);
