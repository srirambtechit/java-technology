delimiter //

create procedure scount(IN cnt OUT)
begin
select count(*) into cnt from screen;
end

delimiter ;


