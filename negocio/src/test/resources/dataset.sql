---------------------Niveles accesos--------------------
INSERT INTO NIVEL_ACCESO VALUES (1, "A", "ADMINISTRADOR");
INSERT INTO NIVEL_ACCESO VALUES (2, "A", "ADMINISTRADOR HOTEL");
INSERT INTO NIVEL_ACCESO VALUES (3, "A", "CLIENTE");

---------------------Ciudades--------------------
INSERT INTO ciudad (codigo, nombre) VALUES (1, "Armenia");
INSERT INTO ciudad (codigo, nombre) VALUES (2, "Bogota");
INSERT INTO ciudad (codigo, nombre) VALUES (3, "Cartagena");
INSERT INTO ciudad (codigo, nombre) VALUES (4, "Manizales");
INSERT INTO ciudad (codigo, nombre) VALUES (5, "Pereira");

---------------------Usuarios--------------------
insert into usuario (CEDULA, EMAIL, NOMBRE, PASSWORD, CIUDAD_CODIGO, NIVEL_ACCESO_CODIGO) values ("1094975931", "jpzh315@gmail.com", "Juan Pablo Zabala", "passw0rd123*", 1,1);
insert into usuario (CEDULA, EMAIL, NOMBRE, PASSWORD, CIUDAD_CODIGO, NIVEL_ACCESO_CODIGO) values ("1094969178", "pepe@email.com", "Pepe Perez", "654", 2,1);
insert into usuario (CEDULA, EMAIL, NOMBRE, PASSWORD, CIUDAD_CODIGO, NIVEL_ACCESO_CODIGO) values ("89004116", "pedro@email.com", "Pedro Martinez", "342", 3,1);
insert into usuario (CEDULA, EMAIL, NOMBRE, PASSWORD, CIUDAD_CODIGO, NIVEL_ACCESO_CODIGO) values ("109478263", "pedro1@email.com", "Pedro Martinez", "342", 3,1);

---------------------Usuarios teléfonos----------------

INSERT INTO USUARIO_TELEFONO VALUES ("1094975931", "8172281123");
INSERT INTO USUARIO_TELEFONO VALUES ("1094969178", "3182762734");
INSERT INTO USUARIO_TELEFONO VALUES ("89004116", "3128716334");



---------------------Vuelos--------------------
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (1,"Avianca", "A", "1","3", "En transito");
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (2,"Viva Air", "A", "3","1", "En transito");
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (3,"EasyFly", "A", "4","2", "En transito");
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (4,"LATAM (Colombia)", "A", "3","5", "En transito");
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (5,"Wingo", "A", "1","4", "En transito");
INSERT INTO vuelo (codigo, aerolinea, estado, ciudad_origen_codigo, ciudad_destino_codigo,estado_vuelo) VALUES (6,"Cosmos S.A", "A", "5","2", "En transito");

---------------------Sillas--------------------
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A1", "5000", "1", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A2", "5000", "1", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A3", "5000", "1", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B1", "15000", "1", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B2", "15000", "1", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B3", "15000", "1", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C1", "25000", "1", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C2", "25000", "1", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C3", "25000", "1", "A", "Disponible");

INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A1", "5000", "2", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A2", "5000", "2", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("A3", "5000", "2", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B1", "15000", "2", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B2", "15000", "2", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("B3", "15000", "2", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C1", "25000", "2", "A", "Disponible");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C2", "25000", "2", "A", "Ocuapda");
INSERT INTO silla (posicion, precio, vuelo_codigo, estado, estado_silla) VALUES ("C3", "25000", "2", "A", "Disponible");

---------------------Hoteles--------------------
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (1,"Hotel Casa grande","Calle 1 # 24-55", "4", "7467833", "1", "903873633-2");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (2,"Hotel De Lujo","Calle 32 # 66-45", "2", "318278233", "2", "801983733-4");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (3,"Hotel San Marcos","Calle 15 # 23-45", "5", "781633344", "3", "18398373-7");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (4,"Hotel Villa Nación","Calle 17 # 17-46", "3", "3109874567", "4", "17837333-4");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (5,"Hotel Happy","Calle 17 # 17-46", "3", "3109874567", "4", "18993773-2");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (6,"Hotel Eco","Calle 22 # 34-46", "3", "3109874567", "1", "900762522-5");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (7,"Hotel Start","Calle 12 # 45-34", "5", "73652344", "4", "1289723311-8");
INSERT INTO hotel (codigo, nombre, direccion, numero_estrellas, telefono, ciudad_codigo, nit) VALUES (8,"Hotel Mocawa","Calle 17 # 76-78", "5", "62827663", "1", "17827265533-1");

------------------Habitaciones--------------------
INSERT INTO habitacion VALUES (1, 2, "A",520000,1);
INSERT INTO habitacion VALUES (2, 2, "A",200000,1);
INSERT INTO habitacion VALUES (3, 2, "A",150000,2);
INSERT INTO habitacion VALUES (4, 2, "A",250000,3);
INSERT INTO habitacion VALUES (5, 2, "A",184000,1);
INSERT INTO habitacion VALUES (6, 2, "A",186000,2);
INSERT INTO habitacion VALUES (7, 2, "A",789022,4);
INSERT INTO habitacion VALUES (8, 2, "A",783442,6);
INSERT INTO habitacion VALUES (9, 2, "A",130000,5);
INSERT INTO habitacion VALUES (10, 2, "A",250000,7);
INSERT INTO habitacion VALUES (11, 2, "A",1990900,4);
INSERT INTO habitacion VALUES (12, 2, "A",134900,8);

-------------------cama habitaciones--------------
INSERT INTO habitacion_camas VALUES (1,1);
INSERT INTO habitacion_camas VALUES (2,1);
INSERT INTO habitacion_camas VALUES (3,1);
INSERT INTO habitacion_camas VALUES (4,1);
INSERT INTO habitacion_camas VALUES (5,1);
INSERT INTO habitacion_camas VALUES (6,1);
INSERT INTO habitacion_camas VALUES (7,1);
INSERT INTO habitacion_camas VALUES (8,1);
INSERT INTO habitacion_camas VALUES (9,1);
INSERT INTO habitacion_camas VALUES (10,1);
INSERT INTO habitacion_camas VALUES (11,1);
INSERT INTO habitacion_camas VALUES (12,1);

----------------------Metodo Pago------------------
INSERT INTO METODO_PAGO (CODIGO, NOMBRE, ESTADO) VALUES (1, "CREDITO", "A");
INSERT INTO METODO_PAGO (CODIGO, NOMBRE, ESTADO) VALUES (2, "CONTADO", "A");

-----------------------Reserva---------------------
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (1, 4, "A", "2022-04-22", "2022-04-24", "2022-01-01", 500000, "89004116",1);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (2, 3, "A", "2022-04-21", "2022-04-26", "2022-04-26", 300000, "1094975931",1);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (3, 2, "A", "2022-04-18", "2022-04-22", "2022-04-22", 500000, "1094975931",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (4, 1, "A", "2022-04-12", "2022-04-16", "2022-04-16", 250000, "1094969178",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (5, 7, "A", "2022-04-11", "2022-04-15", "2022-04-15", 500000, "89004116",1);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (6, 2, "A", "2022-04-25", "2022-04-30", "2022-04-30", 190000, "1094969178",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (7, 1, "A", "2022-04-30", "2022-05-03", "2022-05-03", 120000, "1094975931",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (8, 8, "A", "2022-04-12", "2022-04-22", "2022-04-22", 890111, "89004116",1);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (9, 2, "A", "2022-04-12", "2022-04-15", "2022-04-15", 7452200, "1094969178",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (10, 2, "A", "2022-02-15", "2022-02-16", "2022-04-16", 500000, "1094969178",2);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (11, 2, "A", "2022-02-15", "2022-02-18", "2022-04-18", 3290883, "89004116",1);
INSERT INTO RESERVA (codigo, cantidad_personas, estado_reserva, fecha_inicio, fecha_fin, fecha_reserva, precio_total, usuario_cedula,metodo_pago_codigo) VALUES (12, 2, "A", "2022-02-25", "2022-02-27", "2022-01-30", 1450000, "1094969178",1);

-----------------------Reserva silla---------------------
INSERT INTO RESERVA_SILLAS VALUES (1, 1);
INSERT INTO RESERVA_SILLAS VALUES (1, 2);
INSERT INTO RESERVA_SILLAS VALUES (1, 3);
INSERT INTO RESERVA_SILLAS VALUES (1, 4);
INSERT INTO RESERVA_SILLAS VALUES (1, 5);
INSERT INTO RESERVA_SILLAS VALUES (1, 6);
INSERT INTO RESERVA_SILLAS VALUES (2, 1);
INSERT INTO RESERVA_SILLAS VALUES (2, 2);
INSERT INTO RESERVA_SILLAS VALUES (2, 3);
INSERT INTO RESERVA_SILLAS VALUES (2, 4);

-------------------Reserva habitaciones-------------------
INSERT INTO RESERVA_HABITACIONES VALUES (1, 5);
INSERT INTO RESERVA_HABITACIONES VALUES (2, 1);
INSERT INTO RESERVA_HABITACIONES VALUES (3, 5);
INSERT INTO RESERVA_HABITACIONES VALUES (4, 2);
INSERT INTO RESERVA_HABITACIONES VALUES (5, 4);
INSERT INTO RESERVA_HABITACIONES VALUES (6, 3);
INSERT INTO RESERVA_HABITACIONES VALUES (7, 1);
INSERT INTO RESERVA_HABITACIONES VALUES (8, 2);

-------------------------Comentarios-----------------------
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (1, 5, "Es un buen hotel","2022-01-01", "1094975931", 1);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (2, 4, "Buena atención","2022-01-20", "1094975931", 2);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (3, 3, "No me gustó la comida","2022-01-15", "89004116", 3);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (4, 5, "Excelente la atención","2022-01-11", "1094969178", 4);

INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (5, 5, "Excelente atención, amabilidad","2022-01-01", "1094975931", 5);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (6, 2, "Buen desayuno","2022-01-20", "1094975931", 6);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (7, 5, "Dejan enntrar mascotas :)","2022-01-15", "89004116", 7);
INSERT INTO COMENTARIO (codigo, calificacion, comentario, fecha_calificacion, usuario_cedula, hotel_codigo) VALUES (8, 5, "Buen lugar para disfruta en familia","2022-01-11", "1094969178", 8);

----------------------Caracteristicas---------------------
INSERT INTO CARACTERISTICA VALUES (1, "A", "Hotel buena ubicación cerca a centro comercial");
INSERT INTO CARACTERISTICA VALUES (2, "A", "Hote calidad y precio bajo");
INSERT INTO CARACTERISTICA VALUES (3, "A", "Hotel con los mejores precios, buena ubicación");
INSERT INTO CARACTERISTICA VALUES (4, "A", "Desayuno gratuito, pago anticipado");
INSERT INTO CARACTERISTICA VALUES (5, "A", "Se encuentra en Cali, a 5 km de la plaza de toros de Cañaveralejo y a 8 km del parque Panamericano, y ofrece alojamiento con salón compartido");
INSERT INTO CARACTERISTICA VALUES (6, "A", "Baño en habitación, sofá, bañera, toalla, plancha, caja fuerte");
INSERT INTO CARACTERISTICA VALUES (7, "A", "Habitacion con aire acondicionado");
INSERT INTO CARACTERISTICA VALUES (8, "A", "Wifi gratis, armario, escritorio, ducha agua caliente");

----------------------Caracteristicas hoteles---------------------

INSERT INTO hotel_caracteristicas VALUES (1,1);
INSERT INTO hotel_caracteristicas VALUES (2,2);
INSERT INTO hotel_caracteristicas VALUES (3,3);
INSERT INTO hotel_caracteristicas VALUES (4,5);

-------------------Caracteristicas habitaciones---------------------

INSERT INTO habitacion_caracteristicas VALUES (1,4);
INSERT INTO habitacion_caracteristicas VALUES (2,6);
INSERT INTO habitacion_caracteristicas VALUES (3,7);
INSERT INTO habitacion_caracteristicas VALUES (4,8);


