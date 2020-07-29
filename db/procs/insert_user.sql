create or replace function insert_user(v_username varchar(32), v_first_name varchar(255), v_last_name varchar(255), v_email varchar(255), v_password varchar(255)) returns text as
$$
declare v_error text;
begin
	if exists (select 1 from users where username = v_username) then
		select 'Username ' || v_username || ' already exists' into v_error;
		return v_error;
	end if;
	
	if exists (select 1 from users where email = v_email) then
		select 'Email ' || v_email || ' is already registered' into v_error;
		return v_error;
	end if;
	
	insert into users (username, email, first_name, last_name, password) values (v_username, v_email, v_first_name, v_last_name, v_password);
	return v_error;
end;
$$
LANGUAGE plpgsql;