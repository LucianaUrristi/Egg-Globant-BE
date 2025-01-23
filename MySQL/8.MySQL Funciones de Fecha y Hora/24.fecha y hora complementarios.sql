use mi_bd;


-- Utiliza la función DAYOFWEEK para obtener el número del día de la semana en que se realizó el envío con ID 7.
SELECT DAYOFWEEK(fecha_envio) AS dia_semana
	FROM envios
	WHERE id = 7;
-- Utiliza la función DAYOFYEAR para obtener el día del año en que se entregará el envío con código de producto 'JKL999'.
SELECT DAYOFYEAR(fecha_entrega) AS dia_anio
	FROM envios
	WHERE codigo_producto = 'JKL999';
-- Utiliza la función EXTRACT para obtener el año de la fecha de envío del envío con código de producto 'LMN001'.
SELECT EXTRACT(YEAR FROM fecha_envio) AS anio_envio
	FROM envios
	WHERE codigo_producto = 'LMN001';
-- Utiliza la función FROM_DAYS para obtener la fecha correspondiente a 737402 días a partir del año 0.
SELECT FROM_DAYS(737402) AS fecha_desde_anio_0;
-- Utiliza la función FROM_UNIXTIME para saber que fecha sería si pasaron 1.617.799.784 segundos desde 1970.
SELECT FROM_UNIXTIME(1617799784) AS fecha_desde_1970;
-- Utiliza la función GET_FORMAT para obtener el formato de fecha “EUR” para formatear la fecha de entrega del envío con código de producto 'XYZ789'.
SELECT DATE_FORMAT(fecha_entrega, GET_FORMAT(DATE, 'EUR')) AS fecha_entrega_formateada
	FROM envios
	WHERE codigo_producto = 'XYZ789';
-- Utiliza la función HOUR para extraer la hora de la fecha de envío del envío con ID 1.
SELECT HOUR(fecha_envio) AS hora_envio
	FROM envios
	WHERE id = 1;
-- Utiliza la función LAST_DAY para obtener el último día del mes de la fecha de entrega programada para el envío con código de producto 'XYZ789'.
SELECT LAST_DAY(fecha_entrega) AS ultimo_dia_mes
	FROM envios
	WHERE codigo_producto = 'XYZ789';
-- Utiliza la función LOCALTIME para obtener la hora y la fecha local actual del servidor.
SELECT LOCALTIME() AS fecha_hora_local;
-- Utiliza la función MAKEDATE para crear una fecha correspondiente al año 2023 y al día del año 180.
SELECT MAKEDATE(2023, 180) AS fecha_creada;
-- Utiliza la función MAKETIME para crear una hora con 3 horas, 30 minutos y 15 segundos.
SELECT MAKETIME(3, 30, 15) AS hora_creada;
-- Utiliza la función MICROSECOND para obtener los microsegundos de la fecha de entrega del envío con ID 3.
SELECT MICROSECOND(fecha_entrega) AS microsegundos_entrega
	FROM envios
	WHERE id = 3;
-- Utiliza la función MINUTE para obtener el minuto de la hora de envío del envío con ID 4.
SELECT MINUTE(fecha_envio) AS minuto_envio
	FROM envios
	WHERE id = 4;
-- Utiliza la función MONTH para obtener el mes de la fecha de envío del envío con ID 5.
SELECT MONTH(fecha_envio) AS mes_envio
	FROM envios
	WHERE id = 5;
-- Utiliza la función MONTHNAME para obtener el nombre del mes de la fecha de envío del envío con ID 6.
SELECT MONTHNAME(fecha_envio) AS nombre_mes_envio
	FROM envios
	WHERE id = 6;
-- Utiliza la función NOW para obtener la fecha y hora actual.
SELECT NOW() AS fecha_hora_actual;
-- Utiliza la función TIMESTAMPDIFF para calcular la diferencia en días entre la fecha de envío del envío con ID 5 y la fecha de entrega del envío con ID 6.
SELECT TIMESTAMPDIFF(DAY, 
	(SELECT fecha_envio FROM envios WHERE id = 5), 
    (SELECT fecha_entrega FROM envios WHERE id = 6)
) AS dias_diferencia;
-- Utiliza la función TO_DAYS para convertir la fecha de envío del envío con ID 7 en días.
SELECT TO_DAYS(fecha_envio) AS dias_envio
	FROM envios
	WHERE id = 7;
-- Utiliza la función TO_SECONDS para convertir la fecha de entrega del envío con código de producto 'JKL999' en segundos desde el Año 0.
SELECT TO_SECONDS(fecha_entrega) AS segundos_desde_anio_0
	FROM envios
	WHERE codigo_producto = 'JKL999';
-- Utiliza la función UNIX_TIMESTAMP para obtener una marca de tiempo Unix de la fecha de envío del envío con ID 1.
SELECT UNIX_TIMESTAMP(fecha_envio) AS timestamp_unix
	FROM envios
	WHERE id = 1;
-- Utiliza la función UTC_DATE para obtener la fecha UTC actual.
SELECT UTC_DATE() AS fecha_utc_actual;
-- Utiliza la función UTC_TIME para obtener la hora UTC actual.
SELECT UTC_TIME() AS hora_utc_actual;
-- Utiliza la función UTC_TIMESTAMP para obtener la fecha y hora UTC actual.
SELECT UTC_TIMESTAMP() AS fecha_hora_utc_actual;
-- Utiliza la función WEEK para obtener el número de semana de la fecha de envío del envío con ID 2.
SELECT WEEK(fecha_envio) AS numero_semana
	FROM envios
	WHERE id = 2;
-- Utiliza la función WEEKDAY para obtener el índice del día de la semana de la fecha de envío del envío con ID 3.
SELECT WEEKDAY(fecha_envio) AS indice_dia_semana
	FROM envios
	WHERE id = 3;
-- Utiliza la función WEEKOFYEAR para obtener la semana del calendario de la fecha de entrega del envío con ID 4.
SELECT WEEKOFYEAR(fecha_entrega) AS semana_calendario
	FROM envios
	WHERE id = 4;
-- Utiliza la función YEAR para obtener el año de la fecha de envío del envío con ID 5.
SELECT YEAR(fecha_envio) AS anio_envio
	FROM envios
	WHERE id = 5;
-- Utiliza la función YEARWEEK para obtener el año y la semana de la fecha de envío del envío con ID 6.
SELECT YEARWEEK(fecha_envio) AS anio_semana_envio
	FROM envios
	WHERE id = 6;