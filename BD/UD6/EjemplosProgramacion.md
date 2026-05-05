# Procedimientos SQL

```sql
DELIMITER $$

-- ==========================================
-- 1. variable1
-- ==========================================
DROP PROCEDURE IF EXISTS variable1 $$
CREATE PROCEDURE variable1 ()
BEGIN
    DECLARE v_entero1, v_entero2, v_entero3 INT;
    DECLARE v_entero4 INT DEFAULT -4000;
    DECLARE v_entero5 INT DEFAULT 400000000;
    DECLARE v_real1 FLOAT DEFAULT 344.67;
    DECLARE v_real2 FLOAT DEFAULT 1.5e14;
    DECLARE v_caracter1 NUMERIC(7,2) DEFAULT 4561.44;
    DECLARE v_caracter2 VARCHAR(20);
    DECLARE v_fecha1 DATE DEFAULT '1966-11-03';
    DECLARE v_fecha2 DATE DEFAULT CURRENT_DATE();

    SELECT v_entero1;
    SELECT real_3;
    SELECT v_fecha2;
END $$

-- ==========================================
-- 2. variable2
-- ==========================================
DROP PROCEDURE IF EXISTS variable2 $$
CREATE PROCEDURE variable2 ()
BEGIN
    DECLARE v_caracter1 CHAR(1);
    DECLARE v_forma_pago1 ENUM ('metalico', 'tarjeta', 'transferencia');

    SET v_forma_pago1 = 1;
    SET v_forma_pago1 = 'tarjeta';
    SET v_forma_pago1 = 'TARJETA';
END $$

-- ==========================================
-- 3. asignal
-- ==========================================
DROP PROCEDURE IF EXISTS asignal $$
CREATE PROCEDURE asignal ()
BEGIN
    DECLARE v_entero1, v_entero2, v_entero3 INT;
    DECLARE v_entero4 INT DEFAULT -4000;
    DECLARE v_real1 FLOAT DEFAULT 344.67;
    DECLARE v_real2 FLOAT DEFAULT 1.5e14;
    DECLARE v_real3 NUMERIC(7,2) DEFAULT 4561.44;
    DECLARE v_caracter1 CHAR(1) DEFAULT 'y';
    DECLARE v_fecha1 DATE DEFAULT '1966-11-03';
    DECLARE v_fecha2 DATE DEFAULT CURRENT_DATE();

    SET v_caracter1 = 'N';
    SET v_entero1 = v_entero4 + 10000;
    SET v_real2 = v_entero4 + v_real3;
    SET v_fecha1 = '2006/01/05', v_fecha2 = v_fecha2 + 1;

    SELECT v_caracter1;
    SELECT v_entero1;
    SELECT v_real2;
    SELECT v_fecha1;
    SELECT v_fecha2;
END $$

-- ==========================================
-- 4. variable3
-- ==========================================
DROP PROCEDURE IF EXISTS variable3 $$
CREATE PROCEDURE variable3 ()
BEGIN
    SET @v1 = @v1 * 2;
END $$

-- ==========================================
-- 5. parametro3
-- ==========================================
DROP PROCEDURE IF EXISTS parametro3 $$
CREATE PROCEDURE parametro3 (INOUT p_p1 DECIMAL(7,2))
BEGIN
    SET p_p1 = p_p1 / 166.386;
END $$

-- ==========================================
-- 6. condicional3
-- ==========================================
DROP PROCEDURE IF EXISTS condicional3 $$
CREATE PROCEDURE condicional3 ()
BEGIN
    DECLARE v_edad TINYINT UNSIGNED DEFAULT NULL;

    IF v_edad <= 30 THEN
        SELECT 'Joven';
    END IF;

    IF v_edad > 30 THEN
        SELECT 'Adulto';
    END IF;
END $$

-- ==========================================
-- 7. condicional2
-- ==========================================
DROP PROCEDURE IF EXISTS condicional2 $$
CREATE PROCEDURE condicional2 ()
BEGIN
    DECLARE v_edad TINYINT UNSIGNED DEFAULT NULL;

    IF v_edad <= 30 THEN
        SELECT 'Joven';
    ELSE
        SELECT 'Adulto';
    END IF;
END $$

-- ==========================================
-- 8. condicional1
-- ==========================================
DROP PROCEDURE IF EXISTS condicional1 $$
CREATE PROCEDURE condicional1 ()
BEGIN
    DECLARE v_edad TINYINT UNSIGNED DEFAULT 27;

    IF v_edad <= 12 THEN
        SELECT 'Niño';
    ELSEIF v_edad <= 30 THEN
        SELECT 'Joven';
    ELSE
        SELECT 'Adulto';
    END IF;
END $$

-- ==========================================
-- 9. when1
-- ==========================================
DROP PROCEDURE IF EXISTS when1 $$
CREATE PROCEDURE when1 ()
BEGIN
    DECLARE v_forma_pago ENUM ('metalico','tarjeta','transferencia');

    SET v_forma_pago = 'metalico';

    CASE v_forma_pago
        WHEN 'metalico' THEN
            SELECT 'Forma de pago elegida: Metalico';
        WHEN 'tarjeta' THEN
            SELECT 'Forma de pago elegida: Tarjeta';
        ELSE
            SELECT 'Forma de pago elegida: Transferencia';
    END CASE;
END $$

DELIMITER ;
-- ==========================================
-- 10. iterate-bucle
-- ==========================================
delimiter $$
begin
	declare i tinyiny unsigned;
    set i=0;
    mibucle: loop
		set i = i+1;
        if i = 3 then
			iterate mibucle;
		end if;
		select 'Valor de i =' + i as i;
        if i=4 then
			leave mibucle;
	end if;
end loop mibucle;
delimiter ;
-- ==========================================
-- 11. repeat-bucle
-- ==========================================
delimiter $$

drop procedure if exists bucle3 $$
create procedure bucle3 ()
begin 
	declare i tinyint unsigned;
    set i=0;
    mibucle: repeat
    set i=i+1;
    select 'Valor de i=' +i as i;
    until i=4
end repeat mibucle;
end $$
delimiter ;
-- ==========================================
-- 12. while-bucle
-- ==========================================
delimiter $$
drop procedure if exists bucle4 $$
create procedure bucle4 ()
begin
	declare i tinyint unsigned;
    set i=0;
    mibucle: while i<4 do
		set i=i+1;
        select 'Valor de i='+i as i;
	end while mibucle;
end $$
delimiter ;
-- ==========================================
-- 13. bucle-anidado
-- ==========================================

delimiter $$
drop procedure if exists bucle4 $$
create procedure bucle5 ()
begin
    declare i,j tinyint unsigned default 1;
    bucle_externo: loop
        set j=1;
        bucle_interno:loop
            select concat('Valor de i y j: ', i, '-',j) as i_j;
            set j=j+1;
            if j>2 then
                leave bucle_interno;
            end if;
        end loop bucle_interno;
        set i=i+1;
        if i>2 then
            leave bucle_externo;
        end if;
    end loop bucle_externo;
end $$
delimiter ;