select pg_remove_table('users');

create table users (
	id bigserial primary key,
	username varchar(32),
	first_name varchar(255),
	last_name varchar(255),
	email varchar(255),
	password varchar(255),
	constraint unique_username unique (username),
	constraint unique_email unique (email)
);