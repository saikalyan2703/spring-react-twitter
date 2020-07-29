create or replace function get_following_list(v_username varchar(32))
returns table (
	username varchar(32)
) as $$
declare v_id bigint;
begin
	select id into v_id from users where username = v_username;
	return query select u.username from users u inner join followers f on u.id = f.following where f.followed_by = v_id;
end;
$$
LANGUAGE plpgsql;