select pg_remove_table('tweets');

create table tweets (
	id bigserial primary key,
	user_id bigint references users(id),
	tweet text,
	created_on timestamp
);

create index user_id_index on tweets(user_id);