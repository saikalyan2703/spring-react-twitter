create or replace function pg_remove_table (v_table_name varchar(255)) returns void as $$
declare statement text;
begin
	if exists (select 1 from information_schema.tables where table_name = v_table_name and  table_schema = current_schema()) then
		statement := 'drop table ' || v_table_name;
		raise info 'Dropping table %', v_table_name;
		EXECUTE statement;
	else
		raise info 'Table % does not exists', v_table_name;
	end if;
end;
$$
LANGUAGE plpgsql;