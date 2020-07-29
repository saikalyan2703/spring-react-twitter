create or replace function get_users()
returns table (
	username varchar(32),
	email varchar(255)
) as
$$
begin
	return query select u.username, u.email from users u;
end;
$$
LANGUAGE plpgsql;