use mi_bd;

-- Utiliza la función PERIOD_ADD para agregar un período de 3 meses al año-mes '2022-07'.
SELECT PERIOD_ADD('202207', 3) AS Nuevo_Periodo;
-- Utiliza la función PERIOD_DIFF para calcular el número de meses entre los períodos '2022-03' y '2022-12'.
SELECT PERIOD_DIFF(202212, 202203) AS Meses_Diferencia;
-- Utiliza la función QUARTER para obtener el trimestre de la fecha de entrega del envío con código de producto 'PQR456'.
SELECT QUARTER(fecha_entrega) AS Trimestre
FROM envios
WHERE codigo_producto = 'PQR456';
-- Utiliza la función SEC_TO_TIME para convertir 3665 segundos en formato 'hh:mm:ss'.
SELECT SEC_TO_TIME(3665) AS Hora_Minuto_Segundo;
-- Utiliza la función SECOND para obtener los segundos de la hora de envío del envío con ID 2.
SELECT SECOND(fecha_envio) AS Segundos_Envio FROM envios WHERE id =
2;
-- Utiliza la función STR_TO_DATE para convertir la cadena '2022()08()15' en una fecha.
SELECT STR_TO_DATE('2022()08()15', '%Y()%m()%d') AS Nueva_Fecha;
-- Utiliza la función SUBDATE (o DATE_SUB) para restar 5 días a la fecha de entrega del envío con código de producto 'GHI888'.
SELECT DATE_SUB(fecha_entrega, INTERVAL 5 DAY) AS
Nueva_Fecha_Entrega
FROM envios
WHERE codigo_producto = 'GHI888';
-- Utiliza la función SUBTIME para restar 2 horas y 15 minutos a la hora de envío del envío con ID 7.
SELECT SUBTIME(fecha_envio, '02:15:00') AS Nueva_Hora_Envio
FROM envios
WHERE id = 7;
-- Utiliza la función TIME para extraer la porción de tiempo de la fecha de envío del envío con ID 1.
SELECT TIME(fecha_envio) AS Hora_Envio
FROM envios
WHERE id = 1;
-- Utiliza la función TIME_FORMAT para formatear la hora de envío del envío con ID 2 en 'hh:mm:ss'.
SELECT TIME_FORMAT(fecha_envio, '%H:%i:%s') AS Hora_Formateada
FROM envios
WHERE id = 2;
-- Utiliza la función TIME_TO_SEC para convertir la hora de envío del envío con ID 3 en segundos.
SELECT TIME_TO_SEC(TIME(fecha_envio)) AS Segundos_Envio
FROM envios
WHERE id = 3;
-- Utiliza la función TIMEDIFF para calcular la diferencia de horas entre las fechas de envío y entrega del envío con ID 4.
SELECT TIMEDIFF(fecha_entrega, fecha_envio) AS Diferencia_Tiempo
FROM envios
WHERE id = 4;
-- Utiliza la función SYSDATE para obtener la hora exacta en la que se ejecuta la función en la consulta. Para comprobar esto invoca SYSDATE, luego la función SLEEP durante 5 segundos y luego vuelve a invocar la función SYSDATE, y verifica la diferencia entre ambas invocaciones con TIMEDIFF.
SELECT TIMEDIFF(hora_final, hora_inicial) AS diferencia_de_hora 
FROM (
    SELECT 
        SYSDATE() AS hora_inicial, 
        SLEEP(5) AS pausa, 
        SYSDATE() AS hora_final
) AS tiempos;
-- Crea una consulta que utilice la función TIMESTAMP para obtener todos los valores de fecha_envio sumandole 12 horas.
SELECT TIMESTAMP(fecha_envio, '12:00:00') AS fecha_y_hora_modificada
FROM envios;
-- Utiliza la función TIMESTAMPADD para agregar 3 horas a la fecha de entrega del envío con código de producto 'XYZ789'.
SELECT TIMESTAMPADD(HOUR, 3, fecha_entrega) AS Nueva_Fecha_Entrega
FROM envios
WHERE codigo_producto = 'XYZ789';
