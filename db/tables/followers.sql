select pg_remove_table('followers');

create table followers (
	id bigserial primary key,
	followed_by bigint references users(id),
	following bigint references users(id)
);

create index followed_by_index on followers (followed_by);

create index following_index on followers (following);