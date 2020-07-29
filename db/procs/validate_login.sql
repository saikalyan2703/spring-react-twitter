create or replace function validate_login (v_username varchar(32), v_password varchar(255)) returns text as
$$
declare v_error text;
begin
	if not exists (select 1 from users where username = v_username) then
		select 'User ' || v_username || ' is not registered' into v_error;
		return v_error;
	end if;
	
	if not exists (select 1 from users where username = v_username and password = v_password) then
		select 'Invalid password' into v_error;
		return v_error;
	end if;
	
	return v_error;
end;
$$
LANGUAGE plpgsql;